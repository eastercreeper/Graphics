package other;

import java.awt.*;

public class JumpingBall extends Ball {
    public JumpingBall(int x, int y, double diameter, Color color) {
        super(x, y, diameter, color);
    }
    public double DistanceFromMarble(double x2,double y2) {
        double x1 = getX();
        double y1 = getY();
        return Math.sqrt(Math.pow((x1 - x2),2) + Math.pow((y1 - y2),2));
    }
    public boolean isMarbleTouchingMango(Ball balls) {
        //getRadius() = jumping ball radius
        //ball.getRadius() = ball radius
        return DistanceFromMarble(balls.getX(), balls.getY()) <= balls.getRadius() + getRadius();
    }

    public void MoveTheCatFromTheBasket(int width, int height) {
        setX((int)(Math.random() * width));
        setY((int)(Math.random() * height));
    }
}
