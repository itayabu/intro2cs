import intro.ex5.*;

/**
 * 
The Mandelbrot class represents a rectangular region of the complex plane 
 as a color image, where the color of each pixel (corresponding to a point 
 in the complex plane) is determined according to the escape time of the 
 complex point from the Mandelbrot radius (in ex5 this radius is set to 2).
 The complex numbers contained in each Mandelbrot object are determined 
 according to the size of the rectangular region, its resolution and the 
 complex number in its top left corner.
 The color in the corresponding image is determined according to the escape 
 time of each complex number and a palette of colors. This palette is an 
 array of RGBColors where the color in index 0 represents the color of numbers
 in the Mandelbrot radius and the colors of the other entries are the colors
 of complex numbers that "escaped" from the Mandelbrot set -
 where in entry i lies the color of complex numbers with escape time i.

 */
public class Mandelbrot {
	/**
	 * The radius used for calculating the escape time, for ex5 this radius should be 2.

	 */
	public static final int RADIUS= 2;
	private final int imageRow, imageCol, maxInteractions;
	private double xStep, tStep;
	private Complex topLeft;
	private Complex[][] compTable;
	private RGBColor[] colorPallete;


	/**
	 * Creates a new Mandelbrot instance - 
	 * a plane of complex numbers and a color image represnting it by the escape time from Mandelbrot set of each point in the plane. 
	 * @param rows The height of this Mandelbrot plane (number of complex nubmers).
	 * @param cols The width of this Mandelbrot plane (number of complex nubmers).
	 * @param topLeftCorner The complex number at the top left corner of the plane.
	 * @param xStepSize The size of the change along the x (real) line.
	 * @param yStepSize The size of the change along the y (imaginery) line.
	 * @param maxIterations Max number of iterations to use when computing the
	  escape from the Mandelbrot set.
	 * @param palette The color assigned for each escape time: an array 
	  of size maxIterations+1, where the color in entry i (palette[i]) is the 
	  color for a complex number with escape time i and the color in the first
	  entry (palette[0]) is the color of complex numbers that didn't "escape" from 
	  the Mandelbrot radius.
	 */
	public Mandelbrot(int rows, int cols, Complex topLeftCorner, double xStepSize, double yStepSize,
			int maxIterations, RGBColor[] palette) {
		imageRow=rows;
		imageCol=cols;
		xStep= xStepSize;
		tStep= yStepSize;
		topLeft=topLeftCorner;
		maxInteractions=maxIterations;
		colorPallete= palette;
		compTable=  makeComplexTable();
	

	}
	
	/**
	 * bulid a 2d complex array
	 * @return
	 */
	private Complex[][] makeComplexTable(){
		double startReal=topLeft.getReal(), startImg=topLeft.getImg();
		Complex[][] ComplexTable= new Complex[imageRow][imageCol];
		
		for (int i = 0; i < ComplexTable.length; i++) {
			for (int j = 0; j < ComplexTable[i].length; j++) {
				ComplexTable[i][j]= new Complex (startReal+j*(xStep), startImg-i*(tStep));
			}
		}
		return ComplexTable;
	}

	/**
	 * Returns a color image representing this Mandelbrot plane.	
	 * @return The image representing this Mandelbrot plane.
	 */
	public RGBImage getImage() {
		RGBColor[][] table= new RGBColor[imageRow][imageCol];
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[i].length; j++) {
				if(compTable[i][j].escapeTime(RADIUS, maxInteractions)==-1){
					table[i][j]= new RGBColor (colorPallete[0]);				}
				else
					table[i][j]= new RGBColor (colorPallete[compTable[i][j].escapeTime(RADIUS, maxInteractions)]);					
			}
		}
		return new RGBImage(table);  
	}
	
	/**
	 * Enlarge the resolution of this Mandelbrot object (maginfy)
	    and sets the center of the plane to be the complex number at the given
	    row at column.
	    The total number of complex numbers in this plane 
	    (and thus the dimensions of the image) are not changed, 
	    only the resolution and range of covered numbers.

	 * @param newCenterRow The row of the new center.
	 * @param newCenterCol The column of the new center.
	 * @param magnificationFactor The factor to enlarge the resolution by.
	 */
	public void magnify(int newCenterRow,int newCenterCol, int magnificationFactor) {
		shift(newCenterRow, newCenterCol, 0, 0);
		
		xStep= xStep/magnificationFactor;
		tStep=tStep/magnificationFactor;
		
		shift(0,0,imageRow/2, imageCol/2);
		compTable= makeComplexTable();
	}

	/**
	 * Shift this Mandelbrot palne such the source point (srcRow,srcCol) will 
	     move to (destRow,destCol).

	 * @param srcRow Row of the origin point.
	 * @param srcCol Column of the origin point.
	 * @param destRow Row of the destination point.
	 * @param destCol Column of the destination point.
	 */
	public void shift(int srcRow, int srcCol, int destRow, int destCol) {
		int netRows= destRow- srcRow;
		int netCols= destCol- srcCol;
		
		topLeft=new Complex ((topLeft.getReal()-xStep*netCols),topLeft.getImg()+tStep*netRows );
		compTable= makeComplexTable();

	}
}
