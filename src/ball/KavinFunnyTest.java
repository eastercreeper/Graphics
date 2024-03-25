package other;//Kavin Muralikrishnan ITCS Block 5


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.Timer;

//make sure the class extends jPanel
@SuppressWarnings("serial")
public class KavinFunnyTest extends JPanel {
    //TODO: set the initial width and height of your image
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 800;
    private static final Color FONTCOLOR = GetRandomColor.randomColor();
    private static final Color BACKGROUND = GetRandomColor.randomColor();

    //required global variables
    private BufferedImage image;
    private Graphics2D g;
    private long hitcount = 0;

    private Timer timer;
    private Ball b;
    private ArrayList<JumpingBall> j = new ArrayList<JumpingBall>();
//TODO: change this to whatever object(s) you are animating

    //Constructor required by BufferedImage
    public KavinFunnyTest() {
//set up Buffered Image and Graphics objects
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        g = (Graphics2D) image.getGraphics();

        b = new Ball(GetRandomColor.randomInt(0, WIDTH), GetRandomColor.randomInt(0, HEIGHT), 750, GetRandomColor.randomColor());
        b.setRandomSpeed(10);
        while(Math.sqrt(Math.pow(b.getySpeed(), 2)+Math.pow(b.getxSpeed(), 2))>=10||Math.sqrt(Math.pow(b.getySpeed(), 2)+Math.pow(b.getxSpeed(), 2))<=1) {
            b.setRandomSpeed(10);
        }
        for(int i=0; i<214748; i++) {
            j.add(new JumpingBall(GetRandomColor.randomInt(0, WIDTH), GetRandomColor.randomInt(0, HEIGHT), GetRandomColor.randomInt(50, 100), GetRandomColor.randomColor()));
            j.get(i).move(WIDTH, HEIGHT);
        }

//set up and start the Timer
        timer = new Timer(10, new TimerListener());
        timer.start();

    }

    //TimerListener class that is called repeatedly by the timer
    private class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            drawBackground(g, BACKGROUND);
            b.draw(g);
            b.move(WIDTH, HEIGHT);
            for(int i=0; i<j.size(); i++) {
                if(j.get(i).isMarbleTouchingMango(b)) {
                    hitcount++;
                    while(j.size()>i && j.get(i).isMarbleTouchingMango(b)) {

                        if(!(j.get(i).getDiameter()/2<10)) {
                            j.get(i).setDiameter(j.get(i).getDiameter()/Math.sqrt(2));
                            j.add(new JumpingBall((int) j.get(i).getX(), (int) j.get(i).getY(), j.get(i).getDiameter(), j.get(i).getColor()));
                            j.get(i).move(WIDTH, HEIGHT);
                            j.get(j.size()-1).move(WIDTH, HEIGHT);
                        }
                        else {
                            j.remove(i);
                        }
                    }
                }
            }
            for (JumpingBall i:j) {
                i.draw(g);
            }
            g.setFont(new Font("Comic Sans MS",Font.BOLD, 25));
            g.setColor(FONTCOLOR);
            g.drawString("Hits: " +hitcount, 10, 20);
            g.drawString("Jumping Balls: " + j.size(), 10, 110);
            repaint(); //leave this alone, it MUST  be the last thing in this method
            System.out.println("hits lmao " + hitcount);
        }

    }

    //do not modify this
    public void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
    }

    public void drawBackground(Graphics g, Color c) {
        g.setColor(c);
        g.fillRect(0, 0, WIDTH, HEIGHT);
    }

    //main method with standard graphics code
    public static void main(String[] args) {
        JFrame frame = new JFrame("HailHydra");
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocation(0, 0);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new KavinFunnyTest()); //TODO: Change this to the name of your class!
        frame.setVisible(true);
    }
}