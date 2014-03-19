/**
 * 
The class graphically plots objects that implement the RealFunction interface.

 */

//import java.util.Arrays;
//import javax.swing.JFrame.*;

public class FunctionGraphics extends java.lang.Object{
	private final int dimension, minX, maxX, minY, maxY;
	private boolean isX= true;
	/**
	 * Instantiates a new function graphics object.

	 * @param dimension the number of pixels (width and height) of the frame that instantiates this graph
	 * @param minX the left boundary of the plot region
	 * @param maxX the right boundary of the plot region
	 * @param minY the bottom boundary of the plot region
	 * @param maxY the top boundary of the plot region
	 */
	public FunctionGraphics(int dimension, int minX, int maxX, int minY, int maxY) {
		this.dimension= dimension;
		this.minX= minX;
		this.maxX= maxX;
		this.minY= minY;
		this.maxY= maxY;
	}
	/**
	 * Draws a graph of a given RealFunction object.
	 * @param function the function to draw
	 * @param g the Graphics object (of the calling Jframe)
	 */
	public void drawGraph(RealFunction function, java.awt.Graphics g) {
		
		int realToPix= dimension/ (maxY-minY);
		int n= dimension;
		//tow arrays for the X line and Y line
		int[] xLine= new int[n];
		int[] yLine= new int [n];
		
		for (int i=0; i<n; i++){
			xLine[i]= i;
			yLine[i]=  (int)((function.valueAt(pixToReal(i, !isX))-minY)*realToPix);
		}
		g.drawPolyline (xLine, yLine, n);
	}
	
	/**
	 * Draws a graph of a parametric function defined by two RealFunction objects.
 The first function f1 generates the x coordinates of the plot, while the second
 function f2 generates the y coordinates. Both functions should be evaluated
 for each X value represented in the pixel grid, thus producing a set of (X, Y)
 coordinates. Note that these coordinates should be converted to integer pixel
 coordinates.

	 * @param f1 the x(t) function of the parametric function
	 * @param f2 the y(t) function of the parametric function
	 * @param g the Graphics object (of the calling Jframe)
	 */
	public void drawGraph(RealFunction f1, RealFunction f2, java.awt.Graphics g) {
	
		int XrealToPix= (dimension-1)/ (maxY-minX);
		int YrealToPix= (dimension-1)/ (maxY-minY);
		int n= dimension;
		//tow arrays for the X line and Y line
		int[] xLine= new int [n];
		int[] yLine= new int [n];
		
		for (int i=0; i<n; i++){
			xLine[i]=  (int)((f1.valueAt(pixToReal(i, isX))-minX)*XrealToPix);
			yLine[i]=  (int)((f2.valueAt(pixToReal(i, !isX))-minY)*YrealToPix);
		}
		g.drawPolyline (xLine, yLine, n);
	}
	
	/**
	 * turn a number in the pixel world to a real number
	 * @param pix - a number in the pixels area
	 * @param onX- define if on X line or Y line
	 * @return - double number in the "real" area
	 */
	private double pixToReal (int pix, boolean onX){
		return onX?(minY+(double) pix*(maxX-minX)/(dimension-1)):(minY+(double) pix*(maxY-minY)/(dimension-1));
		
	}
	
	
	
	
}