//GlitchEdit Assignment
//Author: Paul Caracciolo
//Date: Nov 16, 2016
//Class: CS161
//Email: pjcaracc@rams.colostate.edu

package glitchedit.gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
	
	private BufferedImage sourceImage;

	BufferedImage image;
	
	public ImagePanel() {
		Image img = new ImageIcon("C:\\Users\\PJ Caracciolo\\Desktop\\Edited Photos\\IMG_1885-Pano-3.jpg").getImage();
		image = new BufferedImage(img.getWidth(null),img.getHeight(null), BufferedImage.TYPE_INT_RGB);
		
	}
	@Override
	protected void paintComponent(Graphics g2) {
		Graphics2D g = (Graphics2D) g2;
		super.paintComponent(g);
		if(sourceImage != null)
		g.drawImage(sourceImage, 0, 0, getWidth(), getHeight(), null);
	}
	
	public void setSourceImage(BufferedImage image) {
		sourceImage = image;
	}
	
	public BufferedImage getSourceImage() {
		return sourceImage;
	}

}
