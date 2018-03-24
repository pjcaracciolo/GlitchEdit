package glitchedit.mods;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

import glitchedit.modification.Modification;

public class ColorBars extends Modification {

	public ColorBars(Image source) {
		super(source);
		// TODO Auto-generated constructor stub
	}

	@Override
	public BufferedImage modify() {
		LinkedList<BufferedImage> images = new LinkedList<BufferedImage>();
		int height = getImage().getHeight();
		int barHeight = height / 5;
		BufferedImage img = getImage();
		for (int i = 0; i < 5; i++) {
			BufferedImage sub = img.getSubimage(0, barHeight*i, getImage().getWidth(), barHeight);
			images.add(sub);
		}
		for(BufferedImage i:images) {
			Graphics2D g = i.createGraphics();
			Color col = new Color(ThreadLocalRandom.current().nextInt(0, 256),ThreadLocalRandom.current().nextInt(0, 256),ThreadLocalRandom.current().nextInt(0, 256),60);
			g.setColor(col);
			g.fillRect(0, 0, i.getWidth(), i.getHeight());
			g.drawImage(i, null, 0, 0);
			g.dispose();
		
		}
		BufferedImage image = new BufferedImage(getImage().getWidth(),getImage().getHeight(),BufferedImage.TYPE_INT_RGB);
		Graphics2D g = image.createGraphics();
		for(int i =0;i<5;i++) {
			g.drawImage(images.getFirst(),null, 0, barHeight*i);
			images.removeFirst();
		}
		return image;
	}
	
	

}
