
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameController extends Frame implements KeyListener {
	

    private static final Color BG_COLOR = Color.lightGray;

	
    /** The height of the window required by the Game class */
    public static final int WINDOW_HEIGHT = 400;
    /** The width of the window required by the Game class */
    public static final int WINDOW_WIDTH = 501;
    
    private static final int RATE = 35;

    private Game game;

    private static Random rand;
    private Image image;
    
    private int insetLeft;
    private int insetTop;

    /** Creates a new game 
     */
    public GameController(int x,int dir) {
	super("Breakout!"); // display the title on the titlebar
	setVisible(true);
	Insets insets = getInsets();
	insetLeft=insets.left;
	insetTop=insets.top;
	game = new Game(x,dir);
	image=new BufferedImage(WINDOW_WIDTH,WINDOW_HEIGHT,BufferedImage.TYPE_INT_RGB);
	setBounds(insets.left, insets.top, WINDOW_WIDTH + insets.left + insets.right,
		  WINDOW_HEIGHT + insets.top + insets.bottom);
	addKeyListener(this);
	rand=new Random();
    }

    public void start(){
	while(!game.isGameOver()) {
	    try {
		Thread.sleep(RATE);
	    } catch (InterruptedException e) {}
	    
	    tick();
	}
    }

    public void tick(){
    	game.handleTimeEvent();
        if(game.isGameOver()){
            System.exit(0);
	}
        paint(getGraphics());
	//repaint();
    }

    public void keyPressed(KeyEvent keyevent){
	switch (keyevent.getKeyCode()) {
	case KeyEvent.VK_LEFT:
	    game.handleMoveEvent(Game.LEFT);
	    break;
	case KeyEvent.VK_RIGHT:
	    game.handleMoveEvent(Game.RIGHT);
	    break;
	    /**/
	case KeyEvent.VK_DOWN:
	    game.handleMoveEvent(Game.DOWN);
	    break;
	case KeyEvent.VK_UP:
	    game.handleMoveEvent(Game.UP);
	    break;
	    /**/
	default:
	    break;		
	}
    }
    
    
    public void paint(Graphics g){
	Graphics gimg=image.getGraphics();
	gimg.setColor(BG_COLOR);
	gimg.fillRect(0,0,WINDOW_WIDTH,WINDOW_HEIGHT);
        if(game != null){
	    game.paint(gimg);
	    //game.paint(g);
	}
	g.drawImage(image,insetLeft,insetTop,null);
    }

    public void keyReleased(KeyEvent keyevent) {
    }

    public void keyTyped(KeyEvent keyevent){
    }

    /** runs a new game
     */
    public static void main(String args[]){
	int x=Integer.parseInt(args[0]);
	int d=Integer.parseInt(args[1]);
        GameController gamecontroller = 
	    new GameController(x,d);
        gamecontroller.start();
	gamecontroller.dispose();
    }
}
