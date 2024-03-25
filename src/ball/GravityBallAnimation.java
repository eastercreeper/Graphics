package other;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;


public class GravityBallAnimation extends JPanel {

	//TODO: set the initial width and height of your image
	private static final int WIDTH = 1000;
	private static final int HEIGHT = 700;
	private int deltaTime = 10;

	//required global variables
	private BufferedImage image;
	private Graphics g;
	private Timer timer;
	private GravityBall gravityBall; //TODO: change this to whatever object(s) you are animating

	//Constructor required by BufferedImage
	public GravityBallAnimation() {
		//set up Buffered Image and Graphics objects
		image =  new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		g = image.getGraphics();


		/*TODO: Code to setup the objects you will animate goes here
		        All objects declared above should be initialized here
			    ex. cloud = new Cloud(100, 100, 250, 70, Color.WHITE);
			        cloud.setXSpeed(2);
		*/

		gravityBall = new GravityBall(100,100,20, Color.BLUE,0.85);
		gravityBall.setInitialVelocity(10,45);

		//set up and start the Timer
		timer = new Timer(deltaTime, new TimerListener());
		timer.start();

	}

	//TimerListener class that is called repeatedly by the timer
	private class TimerListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			/* TODO: Move the objects that need to be animated
			 * 		 Draw your ENTIRE scene
			 * 		 Don't forget to call repaint!
			 *
			 */
		g.setColor(Color.WHITE);
		g.fillRect(0,0,WIDTH,HEIGHT);
		gravityBall.move(WIDTH,HEIGHT,deltaTime);
		gravityBall.draw(g);
		g.drawString("x " + gravityBall.getX(), 100, 100);
			g.drawString("xSpeed " + gravityBall.getxSpeed(), 100, 150);


			g.drawString("y " + gravityBall.getY(), 100, 200);
			g.drawString("ySpeed " + gravityBall.getySpeed(), 100, 250);





			repaint(); //leave this alone, it MUST  be the last thing in this method
		}

	}

	//do not modify this
	public void paintComponent(Graphics g) {
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
	}

	//main method with standard graphics code
	public static void main(String[] args) {
		JFrame frame = new JFrame("Animation Shell");
		frame.setSize(WIDTH, HEIGHT);
		frame.setLocation(0, 0);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new GravityBallAnimation()); //TODO: Change this to the name of your class!
		frame.setVisible(true);
	}

}