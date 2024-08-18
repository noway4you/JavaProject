package flappy_bird;

import javax.swing.JFrame;

public class app {

	public static void main(String[] args) throws Exception{
		int board_width = 360;
		int board_height = 640;
		
		JFrame frame = new JFrame("flappy bird");
		frame.setVisible(true);
		frame.setSize(board_width,board_height);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		FlappyBird flappy_bird = new FlappyBird();
		frame.add(flappy_bird);
		frame.pack();
		flappy_bird.requestFocus();
		frame.setVisible(true);
	}

}
