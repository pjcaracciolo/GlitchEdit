//GlitchEdit Assignment
//Author: Paul Caracciolo
//Date: Nov 16, 2016
//Class: CS161
//Email: pjcaracc@rams.colostate.edu

package glitchedit.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import glitchedit.mods.ColorBars;
import glitchedit.mods.FlipImage;
import glitchedit.mods.PixelColor;
import glitchedit.mods.PixelSort;
import glitchedit.mods.RearrangeBars;

public class Window extends JFrame {

	private JPanel contentPane;
	ImagePanel panel;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Window(BufferedImage image) {
		this();
		panel.setSourceImage(image);
		System.out.println(image.getWidth(null) + " : " + image.getHeight(null));
		this.setSize((image.getWidth(null) / 7), (image.getHeight(null) / 7));
	}

	public Window() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Window.class.getResource("/glitchedit/gui/brush.png")));
		setResizable(false);
		setTitle("GlitchEdit");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 496);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmSaveAs = new JMenuItem("Save as");
		mntmSaveAs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser save = new JFileChooser();
				if (save.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
					try {
						ImageIO.write(panel.getSourceImage(), "JPEG", save.getSelectedFile().getName().endsWith(".jpg")
								? save.getSelectedFile() : new File(save.getSelectedFile().getAbsolutePath() + ".jpg"));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}
		});
		mnFile.add(mntmSaveAs);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		panel = new ImagePanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panel, BorderLayout.CENTER);

		JToolBar toolBar = new JToolBar();
		toolBar.setOrientation(SwingConstants.VERTICAL);
		contentPane.add(toolBar, BorderLayout.WEST);

		JPanel panel_1 = new JPanel();
		toolBar.add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JButton btnNewButton = new JButton("Rearrange Bars");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		panel_1.add(btnNewButton, gbc_btnNewButton);

		JButton btnColorBars = new JButton("Color Bars");
		btnColorBars.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setSourceImage(new ColorBars(panel.getSourceImage()).modify());
				panel.repaint();
			}
		});
		GridBagConstraints gbc_btnColorBars = new GridBagConstraints();
		gbc_btnColorBars.insets = new Insets(0, 0, 5, 0);
		gbc_btnColorBars.gridx = 0;
		gbc_btnColorBars.gridy = 1;
		panel_1.add(btnColorBars, gbc_btnColorBars);

		JButton btnFlipImage = new JButton("Flip Image");
		btnFlipImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setSourceImage(new FlipImage(panel.getSourceImage()).modify());
				panel.repaint();
			}
		});
		GridBagConstraints gbc_btnFlipImage = new GridBagConstraints();
		gbc_btnFlipImage.insets = new Insets(0, 0, 5, 0);
		gbc_btnFlipImage.gridx = 0;
		gbc_btnFlipImage.gridy = 2;
		panel_1.add(btnFlipImage, gbc_btnFlipImage);
		
		JButton btnPixelColorSwitch = new JButton("Pixel Color Switch");
		btnPixelColorSwitch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setSourceImage(new PixelColor(panel.getSourceImage()).modify());
				panel.repaint();
			}
		});
		GridBagConstraints gbc_btnPixelColorSwitch = new GridBagConstraints();
		gbc_btnPixelColorSwitch.insets = new Insets(0, 0, 5, 0);
		gbc_btnPixelColorSwitch.gridx = 0;
		gbc_btnPixelColorSwitch.gridy = 3;
		panel_1.add(btnPixelColorSwitch, gbc_btnPixelColorSwitch);
		
		JButton btnPixelSort = new JButton("Pixel Sort");
		btnPixelSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setSourceImage(new PixelSort(panel.getSourceImage()).modify());
				panel.repaint();
			}
		});
		GridBagConstraints gbc_btnPixelSort = new GridBagConstraints();
		gbc_btnPixelSort.gridx = 0;
		gbc_btnPixelSort.gridy = 4;
		panel_1.add(btnPixelSort, gbc_btnPixelSort);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setSourceImage(new RearrangeBars(panel.getSourceImage()).modify());
				panel.repaint();
			}
		});
	}

}
