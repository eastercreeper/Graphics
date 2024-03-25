package other;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class WinterWonderland extends JPanel implements ActionListener {

    private BufferedImage bufferedImage;

    private final int x = 0;
    private int y = 0;
    private final int xSpeed = 20;

    public void paintComponent(Graphics g) {
        drawBackground(g);
        drawHorizon(g);
        drawSun(g);
        drawTree(g);
        Timer timer = new Timer(500, this);
        timer.start();
        drawSnowflake(g);
        g.setFont(new Font("LEMONMILK-Regular", Font.BOLD, 20));
        g.drawString("Animating isnt fun", 20, 20);
        drawHouse(g);

    }


    public void drawBackground(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;


        GradientPaint ronenGradiant = new GradientPaint(0, 0, new Color(255, 195, 0), 0, 500, new Color(194, 0, 255));

        //draw a rectangle filling the frame (background)
        //that uses the gradient we just created
        g2D.setPaint(ronenGradiant);
        g2D.fillRect(0, 0, 1000, 800);
        g.setColor(Color.WHITE);
        g.fillRect(0,400,1000,400);
    }
    public void drawSun(Graphics g) {

        g.setColor(new Color(211, 206, 23));

        g.fillOval(0,0,100,100);

    }
    public void drawTree(Graphics g) {
        Tree tree = new Tree(500, 700);
        tree.drawTree(g);
        Tree tree2 = new Tree(600, 600);
        tree2.drawTree(g);
        Tree tree3 = new Tree(150, 550);
        tree3.drawTree(g);

    }
    public void drawHouse(Graphics g) {
        House house = new House(750, 600,100,100);
        House house2 = new House(200, 575,100,100);

        House house3 = new House(400, 450,100,100);

        house.drawHouse(g);
        house2.drawHouse(g);
        house3.drawHouse(g);
    }


    public void drawHorizon(Graphics g) {
        g.setColor(new Color(0, 0, 0));
        g.drawLine(0,400,1000,400);
    }
    public void drawSnowflake(Graphics g) {
        int[] snowFlakes = new int[100];
        Timer _timer = new Timer(100, this);
        for (int i = 0; i < snowFlakes.length; i++) {
            g.setColor(new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255)));
            Snowflake snowflake = new Snowflake((int) (Math.random() * 1000),y + (int) (Math.random() * 800),(int) (Math.random() * 10),(int) (Math.random() * 10));
            snowflake.drawSnowflake(g);
        }
        _timer.start();


        }
    public static void main(String[] args) {
        JFrame frame = new JFrame("test");
        frame.setSize(1000, 800);
        frame.setLocation(0, 0);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new WinterWonderland());
        frame.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(y<200) {
            y=0;
        }
        int ySpeed = 1;
        y = y + ySpeed;
        repaint();
    }
}

