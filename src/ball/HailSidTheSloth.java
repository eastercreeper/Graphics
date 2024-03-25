package other;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class HailSidTheSloth extends JPanel {

    private static final int WIDTH = 1000;
    private static final int HEIGHT = 1000;

    //required global variables
    private BufferedImage image;
    private Graphics g;
    private Timer timer;
    private Ball ball;

    private  int hitCount;
    private int Switchn;
    private ArrayList<JumpingBall> jumpingBalls = new ArrayList<JumpingBall>();


    //Constructor required by BufferedImage
    public HailSidTheSloth() {
        //set up Buffered Image and Graphics objects
        image =  new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        g = image.getGraphics();





        for(int i = 0; i < 1000; i++) {


            jumpingBalls.add(new JumpingBall((int) (Math.random() * WIDTH), (int) (Math.random() * HEIGHT), 2000, new Color((int)(Math.random() * 255),(int)(Math.random() * 255),(int)(Math.random() * 255))));

            jumpingBalls.add(new JumpingBall((int) (Math.random() * WIDTH), (int) (Math.random() * HEIGHT), 2000, new Color((int)(Math.random() * 255),(int)(Math.random() * 255),(int)(Math.random() * 255))));
            jumpingBalls.add(new JumpingBall((int) (Math.random() * WIDTH), (int) (Math.random() * HEIGHT), 2000, new Color((int)(Math.random() * 255),(int)(Math.random() * 255),(int)(Math.random() * 255))));
            jumpingBalls.add(new JumpingBall((int) (Math.random() * WIDTH), (int) (Math.random() * HEIGHT), 2000, new Color((int)(Math.random() * 255),(int)(Math.random() * 255),(int)(Math.random() * 255))));
            jumpingBalls.add(new JumpingBall((int) (Math.random() * WIDTH), (int) (Math.random() * HEIGHT), 2000, new Color((int)(Math.random() * 255),(int)(Math.random() * 255),(int)(Math.random() * 255))));
           jumpingBalls.add(new JumpingBall((int) (Math.random() * WIDTH), (int) (Math.random() * HEIGHT), 2000, new Color((int)(Math.random() * 255),(int)(Math.random() * 255),(int)(Math.random() * 255))));

        }
        ball = new Ball((int)(Math.random() * WIDTH),(int)(Math.random() * HEIGHT),500, Color.BLUE);
        ball.setxSpeed(50);
        ball.setySpeed(50);



        //set up and start the Timer
        timer = new Timer(1, new TimerListener());
        timer.start();

    }

    //TimerListener class that is called repeatedly by the timer
    private class TimerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            g.setColor(Color.BLACK);
            g.fillRect(0,0,WIDTH,HEIGHT);

            ball.move(WIDTH,HEIGHT);
            ball.draw(g);



            for(int i = 0; i < jumpingBalls.size(); i++) {
                jumpingBalls.get(i).draw(g);
                if(jumpingBalls.get(i).isMarbleTouchingMango(ball)) {
                    if(jumpingBalls.get(i).getDiameter()< 10) {
                        jumpingBalls.remove(i);
                    } else {
                        jumpingBalls.add(new JumpingBall((int) (Math.random() * WIDTH), (int) (Math.random() * HEIGHT), jumpingBalls.get(i).getRadius(), jumpingBalls.get(i).getColor()));
                        jumpingBalls.add(new JumpingBall((int) (Math.random() * WIDTH), (int) (Math.random() * HEIGHT), jumpingBalls.get(i).getRadius(), jumpingBalls.get(i).getColor()));
                        jumpingBalls.remove(i);
                        hitCount++;
                    }
                }


            }
            g.setColor(Color.WHITE);
            g.drawString("Hits: " + hitCount,10,10);


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
        frame.setContentPane(new HailSidTheSloth());
        frame.setVisible(true);
    }

}