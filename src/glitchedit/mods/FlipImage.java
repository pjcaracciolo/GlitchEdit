//GlitchEdit Assignment
//Author: Paul Caracciolo
//Date: Nov 16, 2016
//Class: CS161
//Email: pjcaracc@rams.colostate.edu

package glitchedit.mods;

import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import glitchedit.modification.Modification;

public class FlipImage extends Modification {

	public FlipImage(Image source) {
		super(source);
		// TODO Auto-generated constructor stub
	}

	@Override
	public BufferedImage modify() {
		AffineTransform tx = AffineTransform.getScaleInstance(-1, -1);
		tx.translate(-getImage().getWidth(null), -getImage().getHeight(null));
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
		setImage(op.filter(getImage(), null));
		return getImage();
	}

}
