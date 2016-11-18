//GlitchEdit Assignment
//Author: Paul Caracciolo
//Date: Nov 17, 2016
//Class: CS161
//Email: pjcaracc@rams.colostate.edu

package glitchedit.mods;

import java.awt.Image;
import java.awt.image.BufferedImage;

import glitchedit.modification.Modification;

public class PixelSort extends Modification {
	//if dir is 1 it will sort horizontally, if it is 2 it will sort vertically.  by can be 1, 2, or 3
	int dir, by;

	public PixelSort(Image source) {
		super(source);
		// TODO Auto-generated constructor stub
	}

	@Override
	public BufferedImage modify() {
		// TODO Auto-generated method stub
		return sort(2,80);
	}
	
	
	public BufferedImage sort(int dir, int by) {
		 BufferedImage image = getImage();

	    this.dir = dir;
	    this.by = by;
	    int lim = (this.dir == 2 ? image.getHeight() : image.getWidth());
	 
	    for(int i = 0; i < lim; i++) 
	        radix(i, image);
	    
	    return image;
	}
	
	public void radix(int t, BufferedImage image) {
	    int h = (dir == 2 ? image.getWidth() : image.getHeight());
	 
	    for (int s = Byte.SIZE - 1; s > -1; s--) {
	        byte tmp[] = new byte[h];
	        int indices[] = new int[h];
	 
	        int j = 0;  
	 
	        for (int i = 0; i < h; i++) {
	            byte value;
	 
	            if(by == 1)
	                value = (byte) (((dir == 1 ? image.getRGB(t, i) : image.getRGB(i, t)) & 0x00ff0000) >> 16 - 128);
	            else if(by == 2)
	                value = (byte) (((dir == 1 ? image.getRGB(t, i) : image.getRGB(i, t)) & 0x0000ff00) >> 8 - 128);
	            else
	                value = (byte) (((dir == 1 ? image.getRGB(t, i) : image.getRGB(i, t)) & 0x000000ff) - 128);
	 
	            boolean move = value << s >= 0;
	 
	            if (s == 0 ? !move : move) {
	                indices[j] = (dir == 1 ? image.getRGB(t, i) : image.getRGB(i, t));
	                tmp[j++] = value;
	            } else {
	                if(dir == 1)
	                    image.setRGB(t, i-j, image.getRGB(t, i));
	                else if(dir == 2)
	                    image.setRGB(i-j, t, image.getRGB(i, t));
	                }
	            }
	        
	 
	        for (int i = j; i < tmp.length; i++) {
	            if(by == 1)
	                tmp[j] = (byte) (((dir == 1 ? image.getRGB(t, i-j) : image.getRGB(i-j, t)) & 0x00ff0000) >> 16 - 128);
	            else if(by == 2)
	                tmp[j] = (byte) (((dir == 1 ? image.getRGB(t, i-j) : image.getRGB(i-j, t)) & 0x0000ff00) >> 8 - 128);
	            else
	                tmp[j] = (byte) (((dir == 1 ? image.getRGB(t, i-j) : image.getRGB(i-j, t)) & 0x000000ff) - 128);
	 
	            indices[i] = (dir == 1 ? image.getRGB(t, i-j) : image.getRGB(i-j, t));          
	        }   
	 
	 
	        for(int i = 0; i < tmp.length; i++) {
	            if(dir == 1) 
	                image.setRGB(t, i, indices[i]);
	            else if(dir == 2)
	                image.setRGB(i, t, indices[i]);
	        }
	    }
	}

}
