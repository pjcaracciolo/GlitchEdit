package glitchedit.application;

import java.awt.EventQueue;

import glitchedit.gui.CoverScreen;

public class GlitchEdit {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CoverScreen frame = new CoverScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
