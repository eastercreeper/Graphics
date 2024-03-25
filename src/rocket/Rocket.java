package rocket;

import javax.swing.*;
import java.awt.*;

public class    Rocket extends JPanel {

    public void setxSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    public void setySpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }

    private double x, y, width, height, xSpeed,ySpeed;

    public Rocket( int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        xSpeed = 0;
        ySpeed = 0;
    }


    public void drawRocket(Graphics g) {
        int x =     (int)this.x;
        int y =     (int)this.y;
        int width =     (int)this.width;
        int height =     (int)this.height;


        g.setColor(new Color((int)(Math.random() * 255),(int)(Math.random() * 255),(int)(Math.random() * 255)));
        g.fillRect(x,y,width,height+100);


        int[] xRight ={x+width,x+width+50,x+width};
        int[] yRight = {y+height+20,y+height+100,y+height+100};
        g.setColor(new Color((int)(Math.random() * 255),(int)(Math.random() * 255),(int)(Math.random() * 255)));
        g.fillPolygon(xRight,yRight,3);


        int[] xCone = {x, x+width,x+width/2};
        int[] yCone = {y,y, y-50};
        g.setColor(new Color((int)(Math.random() * 255),(int)(Math.random() * 255),(int)(Math.random() * 255)));
        g.fillPolygon(xCone,yCone,3);


        int[] xLeft ={x,x-50,x};
        int[] yLeft = {y+height+20,y+height+100,y+height+100};
        g.setColor(new Color((int)(Math.random() * 255),(int)(Math.random() * 255),(int)(Math.random() * 255)));
        g.fillPolygon(xLeft,yLeft,3);


        g.setFont(new Font("LEMONMILK-Regular", Font.BOLD, 20));
        g.setColor(new Color((int)(Math.random() * 255),(int)(Math.random() * 255),(int)(Math.random() * 255)));
        g.drawString("R",x+width/2-5,y+height/2);
        g.drawString("O",x+width/2-5,y+height/2 + 15);
        g.drawString("N",x+width/2-5,y+height/2 + 30);
        g.drawString("E",x+width/2-5,y+height/2 + 45);
        g.drawString("N",x+width/2-5,y+height/2 + 60);

    }

    public void moveRocket(int xWall,int yWall) {
        if(!(y >=0)) {
            y = y - ySpeed;

        }

    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("test");
        frame.setSize(1000, 800);
        frame.setLocation(0, 0);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new RocketRonen());
        frame.setVisible(true);

    }
    public void paintComponent(Graphics g) {
        drawRocket(g);
    }
}
