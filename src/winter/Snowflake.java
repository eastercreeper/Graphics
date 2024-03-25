package other;

import java.awt.*;

public class Snowflake {

    private int x;
    private int y;
    private int w;
    private int h;

    public Snowflake(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }



    public void drawSnowflake(Graphics g) {
        g.fillOval(x,y,w,h);
        g.drawLine(x-5,y-5,x+10,y+10);
    }
}
