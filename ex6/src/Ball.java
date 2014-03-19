import java.awt.Color;
public class Ball {

	int centerX, centerY, speed, direction, radius; 
	Color color;
	
	/**
	 * Constructs a new ball.

	 * @param x the X coordinate of the center of the ball
	 * @param y the Y coordinate of the center of the ball
	 * @param speed the speed of the ball (using the same rules as the setSpeed method)
	 * @param direction the direction in which the ball moves.
	  Direction is represented in degrees,
	  e.g. a ball with direction 0 moves to the right, a ball with
	  direction 270 moves down.
	  direction may be ANY number, e.g 90 = 450 = -270.
	 * @param radius the radius of the ball
	 * @param color the color of the ball
	 */
	public Ball(int x, int y, int speed, int direction, int radius, java.awt.Color color) {
		
		centerX=x;
		centerY=y;
		this.speed=speed;
		setDirection(direction);
		this.radius=radius;
		this.color=color;
	}
	
	/**
	 * returns the X coordinate of the center of the ball

	 * @return the X coordinate of the center of the ball
	 */
	public int getX() {
	
		return centerX;
	}

	/**
	 * returns the Y coordinate of the center of the ball

	 * @return the Y coordinate of the center of the ball
	 */
	public int getY() {
	
		return centerY;
	}

	/**
	 * Draws the ball

	 * @param g the graphics object associated with the window in which
	    the ball draws itself
	 */
	public void paint(java.awt.Graphics g) {
	
		g.setColor(color);
		g.fillOval(centerX-radius, centerY-radius, 2*radius-1, 2*radius-1);
	}

	/**
	 * returns the radius of the ball

	 * @return the radius of the ball
	 */
	public int getRadius() {
		
		return radius;
	}

	/**
	 * Sets a new speed for the ball.
	     If the given speed is larger than the radius, sets it to radius. If it is less than 2, sets it to 2.

	 * @param speed the new speed, you may assume it's non-negative.
	 */
	public void setSpeed(int speed) {
		
		if (speed<2)
			speed=2;
		
		if (speed>radius)
			speed=radius;
		
		this.speed=speed;
	}

	/**
	 * returns the speed of the ball

	 * @return the speed of the ball
	 */
	public int getSpeed() {
	
		return speed;
	}

	/**
	 * returns the direction of the ball

	 * @return The direction returned is in the [0, 360) interval
	 */
	public int getDirection() {
		int toNormalDegrees=360;
		
			while (direction<0)
				direction += toNormalDegrees;
			while (direction>=toNormalDegrees)
				direction -= toNormalDegrees;					
		
			return direction;
	}

	/**
	 * Sets a new direction for the ball

	 * @param direction the new direction
	  Direction is represented in degrees,
	  e.g. a ball with direction 0 moves to the right, a ball with
	  direction 270 moves down.
	  direction may be ANY number, e.g. 90 = 450 = -270.
	 */
	public void setDirection(int direction) {
				
		this.direction= direction;
	}

	/**
	 * A method used to inform the ball that a quantum of time has passed.
	   The ball calculates its new position (based on its speed,
	   direction and old position).
	   To calculate the new position, first calculate the accurate position of the ball as a double and then
	   round it to an int using the Math.round method.
	   Notice that because of the rounding, some game scenarios will look a bit odd.
	   For example: try starting the ball with direction 3 and then increase the speed after a bit.
	   or start with direction 89, the ball will always move in a straight line.

	 */
	public void timeTick() {
		long xPos=centerX, yPos=centerY;
		xPos += Math.round((double)	speed*(Math.cos(((double)direction/180)*Math.PI)));
		yPos +=  Math.round(-(double)speed*(Math.sin(((double)direction/180)*Math.PI)));

		centerX=(int) xPos;
		centerY= (int) yPos;
	}
}