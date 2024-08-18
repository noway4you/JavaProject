package tw.practice.test;

import java.awt.Desktop;
import java.io.File;

public class file_practice {

	public static void main(String[] args) {
		File file = new File("C:/WINDOWS/system32/SnippingTool.exe");
		try {
			Desktop.getDesktop().open(file);
		} catch (Exception e) {
			System.out.println("error => " + e);
		}
	}
}
