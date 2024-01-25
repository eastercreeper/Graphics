import java.awt.*;

public class JumpingBall extends Ball {
    public JumpingBall(int x, int y, double diameter, Color color) {
        super(x, y, diameter, color);
    }
    public double DistanceFromMarble(double x1,double x2, double y1,double y2) {

        return Math.sqrt(Math.pow((x1 - x2),2) + Math.pow((y1 + y2),2));
    }
    public boolean isMarbleTouchingMango(Ball ball) {
        //getRadius() = jumping ball radius
        //ball.getRadius() = ball radius
        if(DistanceFromMarble(getX(),ball.getX(),getY(),ball.getY()) <= getRadius() + ball.getRadius()) {
            return true;
        } else {
            return false;
        }
    }

    public void MoveTheCatFromTheBasket(int width, int height) {
        setX((int)Math.random() * width);
        setX((int)Math.random() * height);
    }
}
