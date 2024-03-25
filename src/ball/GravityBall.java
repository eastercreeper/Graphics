package other;

import java.awt.*;

public class GravityBall extends Ball{


    private double xAcceleration, yAcceleration;
private double elasticity;

    public void setxAcceleration(double xAcceleration) {
        this.xAcceleration = xAcceleration;
    }

    public void setyAcceleration(double yAcceleration) {
        this.yAcceleration = yAcceleration;
    }

    public double getxAcceleration() {
        return xAcceleration;
    }

    public double getyAcceleration() {
        return yAcceleration;
    }
    public GravityBall(int x, int y, double diameter, Color color, double elasticity) {
        super(x, y, diameter, color);
        xAcceleration = 0;
        yAcceleration = 9.8;
        this.elasticity = elasticity;
    }

    public void setInitialVelocity(int speed, int angleDegrees) {
        setxSpeed(speed * Math.cos(Math.toRadians(angleDegrees)));
        setySpeed(speed * Math.sin(Math.toRadians(angleDegrees)));
    }
    public void move(int rightEdge, int bottomEdge, double deltaTime) {

        setxSpeed(getxSpeed() + xAcceleration * (deltaTime/1000));
        setySpeed(getySpeed() + yAcceleration * (deltaTime/1000));
        setX(getX() + getxSpeed());
        if(getX()+(getRadius()) >= rightEdge) {
            setxSpeed(getxSpeed() * -elasticity);
            setX(rightEdge-getRadius());
        } else if(getX()+(getRadius()) <= 0) {
            setxSpeed(getxSpeed() * -elasticity);
            setX(0+getRadius());

        }
        setY(getY() + getySpeed());
        if(getY()+(getRadius()) >= bottomEdge) {
            setySpeed(getySpeed() * -elasticity);
            setY(bottomEdge-getRadius());

        } else if(getY()+(getRadius()) <= 0) {
            setySpeed(getySpeed() * -elasticity);
            setY(0+getRadius());
        }

    }
}
