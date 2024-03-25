package other;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {

	// 1. Declaration of Variables
	
	private double x;			//x-coordinate of the center of the ball
	private double y;			//y-coordinate of the center of the ball
	private double diameter;	//diameter of the ball
	private double radius;		//radius of the ball
	private Color color;		//color of the ball
	private double xSpeed;		//x-speed = change in x-position
	private double ySpeed;		//y-speed = change in y-position

	
	// 2. Create a default constructor

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void setDiameter(double diameter) {
		this.diameter = diameter;
		radius = diameter/2;
	}

	public void setRadius(double radius) {
		this.radius = radius;
		diameter = radius*2;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void setxSpeed(double xSpeed) {
		this.xSpeed = xSpeed;
	}

	public void setySpeed(double ySpeed) {
		this.ySpeed = ySpeed;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getDiameter() {
		return diameter;
	}

	public double getRadius() {
		return radius;
	}

	public Color getColor() {
		return color;
	}

	public double getxSpeed() {
		return xSpeed;
	}

	public double getySpeed() {
		return ySpeed;
	}

	/**
	 * Default Constructor
	 * Creates a red ball at (0, 0) with a diameter of 25.  
	 * The default speed is 0.
	 */
	public Ball() {
		color = new Color(255,0,0);
		x = 0;
		y = 0;
		diameter = 25;
		radius = diameter/2;
		xSpeed = 0;
		ySpeed = 0;
	}

	public Ball(int x, int y, double diameter, Color color) {
		this.x = x;
		this.y = y;
		this.diameter = diameter;
		radius = diameter/2;
		this.color = color;
		xSpeed = 0;
		ySpeed = 0;
	}

	// 3. Write a constructor that allows the user to input the parameters (x, y, diameter, Color)
	// and sets the x and y-speed = 0.





	// 4. Create getters and setters for all private variables
	
	
	
	// 5. Finish the following methods
	// 6. Test using BouncingBallTester.java
	
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval((int)x-(int)radius,(int)y-(int)radius,(int)diameter,(int)diameter);
		
	}
	
	
	
	// 7. Sets the center location of the ball
	//    This "teleports" the ball to the given x/y location
	
	public void setLocation(double xLoc, double yLoc) {
		x = xLoc;
		y = yLoc;
	}
	
	

	// 8. Sets the xSpeed and ySpeed to a value between
	// negative maxSpeed and positive maxSpeed
	public void setRandomSpeed(double maxSpeed) {
		int negative = (int) (Math.random() * 1);
		int ninja;
		if(negative == 0) {
			ninja = -1;
		} else {
			ninja = 1;
			
		}
		xSpeed = (Math.random() * maxSpeed) * ninja;
		ySpeed = (Math.random() * maxSpeed) * ninja;
	}

	// 9. Write the move method to make the ball move around the screen
	// and bounce of the edges.
	public void move(int rightEdge, int bottomEdge) {
		if(x+(radius) >= rightEdge) {
			xSpeed = xSpeed * -1;
			x=rightEdge-radius;
		} else if(x-(radius) <= 0) {
			xSpeed = xSpeed * -1;
			x=0+radius;
		}
		x = x + xSpeed;

		if(y+(radius) >= bottomEdge||y-(radius) <= 0) {
			ySpeed = ySpeed * -1;
		}
		y = y + ySpeed;


	}
}