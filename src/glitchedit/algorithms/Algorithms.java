//GlitchEdit Assignment
//Author: Paul Caracciolo
//Date: Nov 17, 2016
//Class: CS161
//Email: pjcaracc@rams.colostate.edu

package glitchedit.algorithms;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

import javax.imageio.ImageIO;

public class Algorithms {

	public static BufferedImage tvStatic(BufferedImage img) {
		BufferedImage image = img;
		for (int i = 0; i < image.getWidth(); i++) {
			for (int j = 0; j < image.getHeight(); j++) {
				image.setRGB(i, j,
						new Color(ThreadLocalRandom.current().nextInt(0, 256),
								ThreadLocalRandom.current().nextInt(0, 256),
								ThreadLocalRandom.current().nextInt(0, 256), 0).getRGB());
			}
		}
		return img;
	}

	public static BufferedImage cascadingPixels(BufferedImage img) {
		BufferedImage image = img;
		int k = 0;
		for (int i = 0; i < image.getWidth(); i += ThreadLocalRandom.current().nextInt(1, 4)) {
			Color c = new Color(ThreadLocalRandom.current().nextInt(0, 256),
					ThreadLocalRandom.current().nextInt(0, 256), ThreadLocalRandom.current().nextInt(0, 256), 0);
			for (int j = 0; j < image.getHeight(); j += ThreadLocalRandom.current().nextInt(1, 4)) {
				image.setRGB(i, j, c.getRGB());

			}
			/*
			 * if(ThreadLocalRandom.current().nextInt(0, 220) == 100) { try {
			 * ImageIO.write(image, "JPEG", new File(
			 * "C:\\Users\\Pj Caracciolo\\Desktop\\Edited Photos\\GlitchArt\\pic"
			 * + k + ".jpg")); } catch (IOException e) { // TODO Auto-generated
			 * catch block e.printStackTrace(); } k++; }
			 */
		}
		System.out.println(k);
		return image;
	}
}