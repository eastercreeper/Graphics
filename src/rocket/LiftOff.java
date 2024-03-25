package rocket;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class LiftOff extends JPanel {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 800;

    //required global variables
    private BufferedImage image;
    private Graphics g;
    private Timer timer;
    private Rocket rocket;
    private Falcon9 falcon9;

    //Constructor required by BufferedImage
    public LiftOff() {
        //set up Buffered Image and Graphics objects
        image =  new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        g = image.getGraphics();
        rocket = new Rocket((WIDTH/2)-100,HEIGHT-200,100,200);
        falcon9 = new Falcon9(0,0,100,100);
        //set up and start the Timer
        timer = new Timer(1 , new TimerListener());
        timer.start();


    }

    //TimerListener class that is called repeatedly by the timer
    private class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            g.fillRect(0, 0, WIDTH, HEIGHT);
            rocket.drawRocket(g);
            rocket.moveRocket(600, 500);
            falcon9.moveRocket(600,600);
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
        frame.setContentPane(new LiftOff());
        frame.setVisible(true);
    }

}