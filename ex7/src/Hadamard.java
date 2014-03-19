import intro.ex7.*;
public class Hadamard {

	private static BlackWhiteGrid g;//the grid
	private final static int half=2;
	public Hadamard() {
	}

	/**
	 * Given the parameter n, creates an instance of BlackWhiteGrid and draws the (2^n)x(2^n) Hadamard pattern on it
	 * @param n log of the Hadamard pattern size.

	 * @return The created grid.
	 */
	public static BlackWhiteGrid paintPattern(int n) {
		g= new BlackWhiteGrid();
		boolean color= false;// makes the original color black
		recHada(0,0,g.getWidth(),g.getHeight(),n,color);// call to helper recursion method
		return g;
	}

	/**
	 * recursivly paint the pattern in to out
	 * @param n- how many loops are left (counting down)
	 * @param color- what is the current color (true for white, false for black)
	 */
	private static void recHada(int topWidth, int topHeight, int width, int height, int n, boolean color){

		/**
		 * base case- if recursion reach zero, paint it with the given color 
		 */
		if (n==0){
			g.paintSquare(topWidth, topHeight, (int) (Math.sqrt((width)*(height))), color);
			return;
		}

		recHada (topWidth,topHeight,width/half,height/half,n-1, color);// top left square
		recHada (topWidth+(width/half),topHeight,width/half,height/half,n-1, color);//top right square
		recHada (topWidth,topHeight+(height/half),width/half,height/half,n-1,color);//bottom left square
		recHada (topWidth+(width/half), topHeight+(height/half),width/2,height/half,n-1, !color);//bottom right square
		return;
	}
}
