//GlitchEdit Assignment
//Author: Paul Caracciolo
//Date: Nov 16, 2016
//Class: CS161
//Email: pjcaracc@rams.colostate.edu

package glitchedit.modification;

import java.awt.Image;
import java.awt.image.BufferedImage;

public abstract class Modification {
	
	private BufferedImage image;
	
	public Modification(Image source) {
		image = new BufferedImage(source.getWidth(null),source.getHeight(null), BufferedImage.TYPE_INT_RGB);
		image.getGraphics().drawImage(source, 0, 0, null);
	}

	public abstract BufferedImage modify();
	
	public BufferedImage getImage() {
		return image;
	}
	
	public void setImage(BufferedImage image) {
		this.image = image;
	}
	
}
