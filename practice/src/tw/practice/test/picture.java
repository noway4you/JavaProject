package tw.practice.test;

import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class picture extends JFrame{
	
	public picture() {
		ImageIcon img = new ImageIcon("C:/Users/user/Desktop/picture.jpg");
		JLabel label = new JLabel(img);
		add(label);
		
		setSize(img.getIconWidth(),img.getIconHeight());
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new picture();
	}

}
