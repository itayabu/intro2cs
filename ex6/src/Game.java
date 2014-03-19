import java.awt.Color;
public class Game {
	/**
	 * LEFT- paddle move left
	 * RIGHT- paddle move right
	 * UP- ball speed up
	 * DOWN- ball slow down
	 * WINDOW_WIDTH, WINDOW_HEIGHT- limits of the window
	 */
	public final static int WINDOW_WIDTH=501, WINDOW_HEIGHT=400,
			LEFT=0, RIGHT=1, DOWN=2, UP=3;
	
	/**
	 * some integers im  using more than once
	 */
	private static final int brickRows=6, brickCols=7, wallThick=15;
	
	Color color;
	Brick[][] brickArray;
	Brick top, left, right;
	Paddle paddle;
	Ball ball;
	/**
	 * Creates a new game object.
	 * @param ballX ball's staring x position.
	 * @param ballDir ball's starting direction.
	 */
	public Game(int ballX, int ballDir) {
		
		final int brickWidth=65, brickHeight=25, paddleHeight=10, paddleWidth=75, padding=2, ballRadius=10;
		brickArray= new Brick[brickRows][brickCols];
		int currHeight, currWidth, ballSpeed=6;
		
		top= new Brick(0, 0, wallThick, WINDOW_WIDTH, Color.blue);
		left= new Brick(0, 0, WINDOW_HEIGHT, wallThick, Color.blue);
		right= new Brick(WINDOW_WIDTH-wallThick, 0, WINDOW_HEIGHT, wallThick, Color.blue);
		
		currHeight=wallThick+padding;
		for (int i=0; i<brickRows; i++){
			currWidth= wallThick+padding;
			for (int j=0; j<brickCols; j++){
				brickArray [i][j]= new Brick(currWidth, currHeight, brickHeight, brickWidth, Color.green);
				currWidth= currWidth +brickWidth+padding;
			}
			currHeight+= (brickHeight+padding);
		}
		paddle= new Paddle(WINDOW_WIDTH/2-paddleWidth/2, WINDOW_HEIGHT-paddleHeight, paddleHeight, paddleWidth, Color.black);
		ball= new Ball(ballX, WINDOW_HEIGHT-paddleHeight-ballRadius, ballSpeed, ballDir, ballRadius, Color.red);
	}
	/**
	 * Draws all the components of the game in the window.
	 * @param g The graphics object associated with this game.
	 */
	public void paint(java.awt.Graphics g) {
		
		top.paint(g);
		left.paint(g);
		right.paint(g);
		
		for (int i=0; i<brickRows; i++){
			for (int j=0; j<brickCols; j++){
				brickArray[i][j].paint(g);
			}
		}
		ball.paint(g);
		paddle.paint(g);
	}

	/**
	 * Invoked by external scheduler each time quantum.
	 */
	public void handleTimeEvent() {

		int halfRound=180, fullRound=360;

		ball.timeTick();
		top.bounceBall(ball);
		top.setActive(true);// resumes the wall
		left.bounceBall(ball);
		left.setActive(true);// resumes the wall
		right.bounceBall(ball);
		right.setActive(true);// resumes the wall
	
		for (int i=0; i<brickRows; i++){
			for (int j=0; j<brickCols; j++){
				if (brickArray[i][j].isActive){
					if (brickArray[i][j].bounceBall(ball))
						break;// will not "clean" tow bricks at a time.
				}
			}
		}
		if (ball.getDirection()<fullRound && ball.getDirection()>halfRound)// only if ball goes downwards
			paddle.bounceBall(ball);
	}

	/**
	 * Invoked when user presses left, right, up and down arrows of the keyboard.
	 * @param direction LEFT or RIGHT or UP or DOWN (according to which key the user pressed).
	 */
	public void handleMoveEvent(int direction) {

		switch (direction){

		case LEFT:
			if (paddle.getX()>wallThick)
				paddle.moveLeft();
			break;

		case RIGHT:
			if (paddle.getX()+paddle.getWidth()<WINDOW_WIDTH-wallThick)
				paddle.moveRight();
			break;

		case DOWN:
			ball.setSpeed(ball.getSpeed()-1);
			break;

		case UP:
			ball.setSpeed(ball.getSpeed()+1);
			break;
		}
	}
	/**
	 * Returns whether the game is over or not.
		 The game ends after the last brick was hit, or if the ball's Y coordinate is larger or equal
	 * @return Whether the game is over or not.
	 */
	public boolean isGameOver() {

		boolean check;

		if (ball.getY()<WINDOW_HEIGHT && checkBricks()){
			check=false;
		}
		else
			check= true;

		return check;
	}

	/**
	 * check if there are active bricks
	 * @return true iff active bricks
	 */
	private boolean checkBricks(){

		boolean check= false;

		for (int i=0; i<brickRows; i++){
			for (int j=0; j<brickCols; j++){
				if (brickArray[i][j].isActive)
					check=true;
			}
		}
		return check;
	}
}
