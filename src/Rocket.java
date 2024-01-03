import javax.swing.*;
import java.awt.*;

public class    Rocket extends JPanel {

    public void setxSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setySpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }

    private int x, y, width, height, xSpeed,ySpeed;

    public Rocket( int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        xSpeed = 0;
        ySpeed = 0;
    }


    public void drawRocket(Graphics g) {
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

        if(x - (width*2) > xWall || x<0) {
            xSpeed = xSpeed * -1;
        }
        x = x + xSpeed;

        if(y - (height * 2) > yWall || y<0) {
            ySpeed = ySpeed * -1;
        }
        y = y + ySpeed;

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
