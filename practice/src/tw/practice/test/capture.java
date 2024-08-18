package tw.practice.test;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class capture {

	public capture() throws Exception {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle screenRectangle = new Rectangle(screenSize);
		Robot robot = new Robot();
		BufferedImage img = robot.createScreenCapture(screenRectangle);
		File file = new File("C:/Users/user/Desktop/picture1.jpg");
		BufferedImage subimg = img.getSubimage(100,100,500,500);
		ImageIO.write(subimg,"jpg",file);
	}
	
	public static void main(String[] args) throws Exception {
		new capture();
	}

}
