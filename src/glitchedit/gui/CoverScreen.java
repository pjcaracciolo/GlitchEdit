//GlitchEdit Assignment
//Author: Paul Caracciolo
//Date: Nov 16, 2016
//Class: CS161
//Email: pjcaracc@rams.colostate.edu

package glitchedit.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.Toolkit;

public class CoverScreen extends JFrame {
	/**
	 * 
	 */
	private JButton btnLoadImage;

	/**
	 * Create the frame.
	 */
	public CoverScreen() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CoverScreen.class.getResource("/glitchedit/gui/brush.png")));
		setBackground(Color.LIGHT_GRAY);
		setResizable(false);
		setTitle("GlitchEdit");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 425, 368);
		getContentPane().setLayout(new BorderLayout(0, 0));

		JLabel lblGlitchedit = new JLabel("GlitchEdit");
		lblGlitchedit.setFont(new Font("Papyrus", Font.PLAIN, 32));
		lblGlitchedit.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblGlitchedit, BorderLayout.NORTH);

		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(CoverScreen.class.getResource("/glitchedit/gui/glitcheditopener.PNG")));
		getContentPane().add(label, BorderLayout.CENTER);

		btnLoadImage = new JButton("");
		btnLoadImage.setBackground(SystemColor.menu);
		btnLoadImage
				.setIcon(new ImageIcon(CoverScreen.class.getResource("/glitchedit/gui/button_load-image.png")));
		btnLoadImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser imgFile = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG, GIF, PNG Images", "jpg", "gif",
						"png");
				imgFile.setFileFilter(filter);
				int value = imgFile.showOpenDialog(null);
				if (value == JFileChooser.APPROVE_OPTION) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								
								Image img = new ImageIcon(imgFile.getSelectedFile().getAbsolutePath()).getImage();
								BufferedImage image = new BufferedImage(img.getWidth(null),img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
								image.getGraphics().drawImage(img, 0, 0, null);
								Window frame = new Window(image);
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
					setVisible(false);
					dispose();
				}
			}
		});
		getContentPane().add(btnLoadImage, BorderLayout.SOUTH);
	}

	public Icon getBtnLoadImageIcon() {
		return btnLoadImage.getIcon();
	}

	public void setBtnLoadImageIcon(Icon icon) {
		btnLoadImage.setIcon(icon);
	}
}
