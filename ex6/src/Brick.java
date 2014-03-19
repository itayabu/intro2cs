import java.awt.Color;
import java.awt.Graphics;


/**
 * 
	This class implements a Brick in the Breakout game.
	 It's also used to represent the walls of room in the game.

 */
public class Brick {

	private int topX, topY, height, width;
	Color color;
	boolean isActive;

	/**
	 * Constructs a new brick

	 * @param x the X coordinate of the top left corner of the brick
	 * @param y the Y coordinate of the top left corner of the brick
	 * @param height the height of the brick
	 * @param width the width of the brick
	 * @param color the color of the brick
	 * @param isActive does the brick start as active or not.
	 */
	public Brick(int x, int y, int height, int width, java.awt.Color color, boolean isActive) {
		topX= x;
		topY=y;
		this.height= height;
		this.width= width;
		this. color= color;
		setActive (isActive);
	}

	/**
	 * Constructs a new brick that's active upon construction.
	
	 * @param x the X coordinate of the top left corner of the brick
	 * @param y the Y coordinate of the top left corner of the brick
	 * @param height the height of the brick
	 * @param width the width of the brick
	 * @param color the color of the brick
	 */
	public Brick(int x, int y, int height, int width, Color color) {
		
		topX= x;
		topY=y;
		this.height= height;
		this.width= width;
		this. color= color;
		setActive (true);
	}

	/**
	 * Draws the brick

	 * @param g the graphics object associated with the window in which
	 the brick draws itself
	 */
	public void paint(Graphics g) {
	
		if (! isActive)
			return;
		
		g.setColor(color);
		g.fillRect(topX, topY, width, height);
	}

	/**
	 * returns this Brick's height.

	 * @return this Brick's height.
	 */
	public int getHeight() {
	
		return height;
	}

	/**
	 * returns this Brick's width.

	 * @return this Brick's width.
	 */
	public int getWidth() {
		
		return width;
	}

	/**
	 * returns the X coordinate of this brick's top-left corner.

	 * @return X coordinate of this brick's top-left corner.
	 */
	public int getX() {
		
		return topX;
	}

	/**
	 * returns the Y coordinate of this brick's top-left corner.

	 * @return Y coordinate of this brick's top-left corner.
	 */
	public int getY() {
		
		return topY;
	}

	/**
	 * Returns whether this Brick is active or not.

	 * @return true iff this Brick is active.
	 */
	public boolean getActive() {
	
		return isActive;
	}

	/**
	 * Sets brick's activity to the given value.

	 * @param isActive true if setting the brick to active false for inactive.
	 */
	public void setActive(boolean isActive) {
	
		this.isActive=isActive;
	}

	/**
	 * Bounces the ball if it hit one of this Brick's regions.
	 * @param ball the ball object

	 * @return true if the ball hit one of the brick's regions and false otherwise.
	 */
	public boolean bounceBall(Ball ball) {
		
		final int radius= ball.getRadius(), fullRound=360, halfRound=180;
		
		if ((ball.getX()>=topX && ball.getX()<= topX+width)// in the X's "small" radius
				&& (ball.getY()<= topY+ height+radius && ball.getY()>=topY-radius)){// in the Y's "large" radius
			
			ball.setDirection(fullRound-ball.getDirection());
			setActive(false);
			ball.timeTick();//push the ball away
			return true;
		}
		if ((ball.getX()>=topX-radius && ball.getX()<=topX+width+radius)// in the X's "large" radius
				&& (ball.getY()<=topY+height && ball.getY()>topY)){// the Y's "small" radius
			
			ball.setDirection(halfRound- ball.getDirection());
			setActive(false);
			ball.timeTick();// push the ball away
			return true;
		}
		else// not in the brick's area
			return false;

	}

}