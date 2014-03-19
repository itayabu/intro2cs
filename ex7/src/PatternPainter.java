import intro.ex7.*;

/**
 * Contains a method that draws the (2^n)x(2^n) left corner
 *  of the (2^(n+1))x(2^(n+1)) pattern defined in ex7 on a BlackWhiteGrid.
 */
public class PatternPainter {
	private static final int half=2;
	private static BlackWhiteGrid g;

	/**
	 *empty constructor 
	 */
	public PatternPainter() {
	}

	/**
	 * Given the parameter n, creates an instance of BlackWhiteGrid 
	 * and draws on it the (2^n)x(2^n) left corner of the (2^(n+1))x(2^(n+1)) pattern defined in ex7
	 * @param n log of the PatternPainter pattern size.

	 * @return The created grid.
	 */
	public static BlackWhiteGrid paintPattern(int n) {

		g= new BlackWhiteGrid();
		boolean color= false;

		// calling the nXn topleft corner of the 2^n+1X2^n+1 square
		topLeft(0, 0, g.getWidth(), g.getHeight(),n, color);
		return g;
	}

	/**
	 * handeling the top left corner
	 * flip its bottom right square
	 */
	private static void topLeft(int topWidth, int topHeight, int width, int height, int n, boolean color){
		if (n==0){
			g.paintSquare(topWidth, topHeight, (int) (Math.sqrt((width)*(height))), color);
			return;
		}
		topLeft (topWidth,topHeight,width/half,height/half,n-1, color);// top left square
		topRight (topWidth+(width/half),topHeight,width/half,height/half,n-1, color);//top right square
		bottomLeft (topWidth,topHeight+(height/half),width/half,height/half,n-1,color);//bottom left square
		bottomRight (topWidth+(width/half), topHeight+(height/half),
				width/2,height/half,n-1, !color);//bottom right square
		return;
	}

	/**
	 * handeling the top right corner
	 * flip its bottom left square
	 */
	private static void topRight(int topWidth, int topHeight, int width, int height, int n, boolean color){
		if (n==0){
			g.paintSquare(topWidth, topHeight, (int) (Math.sqrt((width)*(height))), color);
			return;
		}
		topLeft (topWidth,topHeight,width/half,height/half,n-1, color);// top left square
		topRight (topWidth+(width/half),topHeight,width/half,height/half,n-1, color);//top right square
		bottomLeft (topWidth,topHeight+(height/half),width/half,height/half,n-1,!color);//bottom left square
		bottomRight (topWidth+(width/half), topHeight+(height/half),
				width/half,height/half,n-1, color);//bottom right square
		return;
	}

	/**
	 * handeling the bottom left corner
	 * flip its upper right square
	 */
	private static void bottomLeft(int topWidth, int topHeight, int width, int height, int n, boolean color){
		if (n==0){
			g.paintSquare(topWidth, topHeight, (int) (Math.sqrt((width)*(height))), color);
			return;
		}
		topLeft (topWidth,topHeight,width/half,height/half,n-1, color);// top left square
		topRight (topWidth+(width/half),topHeight,width/half,height/half,n-1, !color);//top right square
		bottomLeft (topWidth,topHeight+(height/half),width/half,height/half,n-1,color);//bottom left square
		bottomRight (topWidth+(width/half), topHeight+(height/half),
				width/half,height/half,n-1, color);//bottom right square
		return;
	}

	/**
	 * handeling the bottom right corner
	 * flip its upper left square
	 */
	private static void bottomRight(int topWidth, int topHeight, int width, int height, int n, boolean color){
		if (n==0){
			g.paintSquare(topWidth, topHeight, (int) (Math.sqrt((width)*(height))), color);
			return;
		}
		topLeft (topWidth,topHeight,width/half,height/half,n-1, !color);// top left square
		topRight (topWidth+(width/half),topHeight,width/half,height/half,n-1, color);//top right square
		bottomLeft (topWidth,topHeight+(height/half),width/half,height/half,n-1,color);//bottom left square
		bottomRight (topWidth+(width/half), topHeight+(height/half),
				width/half,height/half,n-1, color);//bottom right square
		return;
	}
}
