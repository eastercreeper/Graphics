package other;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
//TODO: Change the name of the class from AnimationShell to the name of your class
public class JumpingBallAnimation extends JPanel {

    //TODO: set the initial width and height of your image
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 1000;

    //required global variables
    private BufferedImage image;
    private Graphics g;
    private Timer timer;
    private Ball ball;//TODO: change this to whatever object(s) you are animating

    private  JumpingBall[] jumpingBall;
    private  int hitCount;
    private int Switchn;


    //Constructor required by BufferedImage
    public JumpingBallAnimation() {
        //set up Buffered Image and Graphics objects
        image =  new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        g = image.getGraphics();




		/*TODO: Code to setup the objects you will animate goes here
		        All objects declared above should be initialized here
			    ex. cloud = new Cloud(100, 100, 250, 70, Color.WHITE);
			        cloud.setXSpeed(2);
		*/

        jumpingBall = new JumpingBall[10];
        for(int i = 0; i < jumpingBall.length; i++) {
            jumpingBall[i] =new JumpingBall(100,100,(int)(Math.random() * 100),Color.RED);
        }

        ball = new Ball(500,500,200, Color.BLUE);
        ball.setRandomSpeed(20);

        //set up and start the Timer
        timer = new Timer(1, new TimerListener());
        timer.start();

    }

    //TimerListener class that is called repeatedly by the timer
    private class TimerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            /* TODO: Move the objects that need to be animated
             * 		 Draw your ENTIRE scene
             * 		 Don't forget to call repaint!
             */
            g.setColor(Color.BLACK);
            g.fillRect(0,0,WIDTH,HEIGHT);
            g.setColor(Color.WHITE);
            g.drawString("Hits: " + hitCount,10,10);
            ball.move(WIDTH,HEIGHT);
            ball.draw(g);


            for(int i = 0; i < jumpingBall.length; i++) {
                jumpingBall[i].draw(g);
                if(jumpingBall[i].isMarbleTouchingMango(ball)) {
                    if (jumpingBall[i].getColor() == Color.RED) {
                        jumpingBall[i].setColor(Color.GREEN);
                    } else if (jumpingBall[i].getColor() == Color.GREEN) {
                        jumpingBall[i].setColor(Color.RED);
                    }
                    jumpingBall[i].MoveTheCatFromTheBasket(WIDTH,HEIGHT);

                    hitCount++;
                }
            }


            repaint(); //leave this alone, it MUST  be the last thing in this method
        }

    }

    //do not modify this
    public void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
    }

    //main method with standard graphics code
    public static void main(String[] args) {
        JFrame frame = new JFrame("Epliepsy");
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocation(0, 0);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new JumpingBallAnimation()); //TODO: Change this to the name of your class!
        frame.setVisible(true);
    }

}