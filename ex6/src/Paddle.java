import java.awt.Color;
//import java.awt.Graphics;

public class Paddle {
	
	private int topX, topY, height, width;
	
	Color color;
	/**
	 * Creates a new paddle

	 * @param x the X coordinate of upper left corner of the paddle
	 * @param y the Y coordinate of upper left corner of the paddle
	 * @param color the color of the paddle
	 * @param height the height of the paddle
	 * @param width the width of the paddle
	 */
	public Paddle(int x, int y, int height, int width, java.awt.Color color) {
		
		topX=x;
		topY=y;
		this.height=height;
		this.width=width;
		this.color= color;
	}

	/**
	 * Changes the paddle position by 10 to the left (down the X axis).

	 */
	public void moveLeft() {
		
		int leftSteps=10;
			topX-= leftSteps;
	}

	/**
	 * Changes the paddle position by 10 to the right (up the X axis).

	 */
	public void moveRight() {
	
		int rightSteps=10;
			topX+= rightSteps;
	}

	/**
	 * Draws the paddle

	 * @param g the graphics object associated with the window in which
	     the paddle draws itself
	 */
	public void paint(java.awt.Graphics g) {
		
		g.setColor(color);
		g.fillRect(topX, topY, width, height);
	}

	/**
	 * Bounces the ball (if appropriate according to the exercise description).
	      If the ball is in such a position relative to the paddle that it should
	      be bounced the method updates the ball so that its speed and direction reflect
	      the effect of the bounce.

	 * @param ball the ball object

	 * @return true if the ball hit the paddle.
	 */
	public boolean bounceBall(Ball ball) {
		
		int radius= ball.getRadius(), fullRound= 360;
		
		if ((ball.getX()>topX-radius && ball.getX()< topX+width+radius)// in X radius
				&& ball.getY()>= topY-radius && ball.getY()< topY){// in Y radius
			ball.setDirection(fullRound-ball.getDirection());
			return true;
		}
		
		return false;
	}

	/**
	 * returns the height of the paddle

	 * @return the height of the paddle
	 */
	public int getHeight() {
		
		return height;
	}

	/**
	 * returns the width of the paddle

	 * @return the width of the paddle
	 */
	public int getWidth() {
		
		return width;
	}

	/**
	 * returns the X position of the paddles' top-left corner.

	 * @return the X position of the paddles' top-left corner.
	 */
	public int getX() {
		
		return topX;
	}

	/**
	 * returns the Y position of the paddles' top-left corner.

	 * @return the Y position of the paddles' top-left corner.
	 */
	public int getY() {
		
		return topY;
	}
}
