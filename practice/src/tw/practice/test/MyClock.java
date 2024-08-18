package tw.practice.test;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

public class MyClock extends JPanel { 
	
	private double second,minute,hour;
	private long milisecond;
	private Timer timer;
	  
	public MyClock() {
		
		timer = new Timer();
		timer.scheduleAtFixedRate(new MyTask(),0,16);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.setColor(Color.black);
		g2d.fillOval(10,10,500,500);
		g2d.setColor(Color.white);
		g2d.fillOval(255,255,10,10);
		g2d.setStroke(new BasicStroke(3));
		g2d.drawLine(260,260,260+(int)(240*(Math.sin(second))),260-(int)(240*(Math.cos(second))));
		g2d.drawLine(260,260,260+(int)(180*(Math.sin(minute))),260-(int)(180*(Math.cos(minute))));
		g2d.drawLine(260,260,260+(int)(120*(Math.sin(hour))),260-(int)(120*(Math.cos(hour))));
		
	}
	
	public class MyTask extends TimerTask{
		@Override
		public void run() {
			milisecond = System.currentTimeMillis();
			second = (Math.PI/30000)*milisecond;
			minute = second/60;
			hour = ((minute/60)/12)-(Math.PI/6);
			repaint();
		}
	}
} 