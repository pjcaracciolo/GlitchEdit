package glitchedit.mods;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.concurrent.ThreadLocalRandom;

import glitchedit.algorithms.Algorithms;
import glitchedit.modification.Modification;

public class PixelColor extends Modification {

	public PixelColor(Image source) {
		super(source);
		// TODO Auto-generated constructor stub
	}

	@Override
	public BufferedImage modify() {
	/*	BufferedImage image = getImage();
		for (int i = 0; i < image.getWidth(); i++) {
			Color c = new Color(ThreadLocalRandom.current().nextInt(0, 256), ThreadLocalRandom.current().nextInt(0, 256), ThreadLocalRandom.current().nextInt(0, 256), 0);
			for (int j = 0; j < image.getHeight(); j++) {
				image.setRGB(i, j,  c.getRGB());
			}
		}
		return image;*/
		return Algorithms.cascadingPixels(getImage());
	}

}
