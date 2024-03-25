package other;

import sun.java2d.loops.GraphicsPrimitive;

import javax.swing.*;
import java.awt.*;

public class House {

    private int x;
    private int y;
    private int height;
    private int width;
    

    public House(int x, int y,int height, int width) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }

    public void drawHouse(Graphics g) {
        g.setColor(new Color(59, 27, 2));
        g.fillRect(x,y,width,height);

        int[] xRoof = {x-50,x+width/2,x+width+50};
        int[] yRoof = {y,y-50,y};
        g.setColor(new Color(255, 0, 0));
        g.fillPolygon(xRoof,yRoof,3);

        g.setColor(new Color(0, 0, 0));
        g.drawRect(x+width/2-10,y+height/2,width/4,height/2-1);
        g.setColor(new Color(255,255,255));
        g.drawOval(x+width/2+10,y+height/2+20,5,5);

        g.setColor(new Color(0,0,0));
        g.drawOval(x+width-30,y+height-75,20,20);
        g.drawOval(x+width-80,y+height-75,20,20);

    }




}
