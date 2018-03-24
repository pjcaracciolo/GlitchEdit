package glitchedit.mods;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import glitchedit.modification.Modification;

public class RearrangeBars extends Modification {

	public RearrangeBars(Image source) {
		super(source);

	}

	private boolean horizontal = false;

	@Override
	public BufferedImage modify() {
		LinkedList<BufferedImage> images = new LinkedList<BufferedImage>();
		int height = getImage().getHeight();
		int barHeight = height / 5;
		int width = getImage().getWidth();
		int barWidth = width / 5;

		BufferedImage img = getImage();
		for (int i = 0; i < 5; i++) {
			if (horizontal) {
				BufferedImage sub = img.getSubimage(0, barHeight * i, getImage().getWidth(), barHeight);
				images.add(sub);
			} else {
				BufferedImage sub = img.getSubimage(barWidth * i, 0, barWidth, height);
				images.add(sub);
			}
		}
		BufferedImage image = new BufferedImage(getImage().getWidth(), getImage().getHeight(),
				BufferedImage.TYPE_INT_RGB);
		Graphics2D g = image.createGraphics();
		for (int i = 0; i < 5; i++) {
			if (horizontal) {
				g.drawImage(images.getLast(), null, 0, barHeight * i);
			} else {
				g.drawImage(images.getLast(), null, barWidth * i, 0);
			}
			images.removeLast();
		}

		System.out.println("Done");
		return image;
	}

}
