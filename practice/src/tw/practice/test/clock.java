package tw.practice.test;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class clock extends JFrame{

	private MyClock c;
	
	public clock() {
		
		c = new MyClock();
		
		setLayout(new BorderLayout());
		add(c,BorderLayout.CENTER);
		
		setSize(600,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new clock();
	}
}
