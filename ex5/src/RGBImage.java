import intro.ex5.*;
/**
 * 
This class represents a 2D color image, composed of RGB pixels.
 The row and column numbering start from the upper-left corner.
 The image is represented by a 2D array of RGBColor objects.
 */
public class RGBImage {

	private int imageRow, imageCol, lastRow, lastCol;
	private static final int RED=0, GREEN=1, BLUE=2;
	private RGBColor[][] image;

	/**
	 * fill the input bounds on a given array with black RGBColors
	 * @param table
	 * @param startRow
	 * @param endRow
	 * @param startCol
	 * @param endCol
	 */
	private RGBColor[][] makeBlack (int startRow, int endRow, int startCol, int endCol){
	
		RGBColor[][] table= new RGBColor[imageRow][imageCol];
		
		for (int i = startRow; i < endRow; i++) {
			for (int j = startCol; j < endCol; j++) {
				table[i][j]= new RGBColor();
			}
		}
		return table;
	}

	/**
	 * Construct a new black RGBImage with the given number of rows and columns.
	 All pixels in the image should be black (red = green = blue = 0).
	 Raises an error if the given rows or cols are not positive.

	 * @param rows The height of the new image.
	 * @param cols The width of the new image.
	 */
	public RGBImage (int rows, int cols){
		
		if (rows<=0 || cols<=0)
			ErrorPrinter.error("input must be positive!");
		imageRow=rows;
		imageCol=cols;
		lastRow=imageRow-1;
		lastCol=imageCol-1;
		image= new RGBColor[imageRow][imageCol];		
		
		image= makeBlack (0, imageRow, 0, imageCol);
	}

	/**
	 * Construct a new RGBImage identical to the given array of pixels.
	 Assumes the given array is legal.

	 * @param pixels The pixels of the new image.
	 */
	public RGBImage (RGBColor[][] pixels){
	
		imageRow=pixels.length;
		imageCol=pixels[0].length;
		lastRow=imageRow-1;
		lastCol=imageCol-1;
		RGBColor[][] table= new RGBColor[imageRow][imageCol];
		image= new RGBColor[imageRow][imageCol];
		
		for (int i = 0; i < imageRow; i++) {
			for (int j = 0; j < imageCol; j++) {
				table[i][j]=new RGBColor(pixels[i][j]);
			}
		}
		image= table;
	}

	/**
	 * Construct a new RGBImage which is a copy of the given image.
	 Assumes the given image is not null.

	 * @param other The image to copy.
	 */
	public RGBImage (RGBImage other){
		
		imageRow= other.getHeight();
		imageCol= other.getWidth();
		lastRow=imageRow-1;
		lastCol=imageCol-1;
		RGBColor[][] table= new RGBColor[imageRow][imageCol];
		image = new RGBColor[imageRow][imageCol];
		
		for (int i = 0; i < imageRow; i++) {
			for (int j = 0; j < imageCol; j++) {
				table[i][j]=new RGBColor(other.getPixel(i,j));
			}
		}
		image= table;
	}

	/**
	 * Gets the height of the image in pixels.

	 * @return The height of the image.
	 */
	public int getHeight(){
	
		return imageRow;
	}

	/**
	 * Gets the width of the image in pixels.
	 The width is the number of columns.

	 * @return The width of the image.
	 */
	public int getWidth(){
	
		return imageCol;
	}

	/**
	 * Gets the pixel at the given coordinates.
	 Returns a black RGBColor if the given coordinates are outside the image

	 * @param row The row of the pixel to get.
	 * @param col The column of the pixel to get.

	 * @return The pixel at the given coordinates.
	 */
	public RGBColor getPixel(int row, int col) {
	
		return new RGBColor (image[row][col]);
	}

	/**
	 * Gets an array of the pixels in this image.

	 * @return An array of the pixels in this image.
	 */
	public RGBColor[][] toRGBColorArray() {
		
		RGBColor[][] table= new RGBColor[imageRow][imageCol];
		
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[i].length; j++) {
				table[i][j]= new RGBColor(image[i][j]);
			}
		}
		return table;
	}

	/**
	 * Returns the grayscale representation of the image.
	 The grayscale reperesentation of each pixel is calculated as defined in
	 the API of RGBColor

	 * @return A 2d array of floats representing the image in grayscale values.
	 */
	public float[][] toGrayscaleArray() {
		
		float[][] table= new float[imageRow][imageCol];
		
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[i].length; j++) {
				table[i][j]= image[i][j].convertToGrayscale();
			}
		}
		return table;
	}

	/**
	 * Inverts the color of all pixels in this image, by replacing each 
	  RGB value with its complement to 255. For example, RGB values of [0,1,2] would be
	  changed to [255,254,253].

	 */
	public void invertColors() {
		
		RGBColor[][] table= toRGBColorArray();
		
		for (int i = 0; i < image.length; i++) {
			for (int j = 0; j < image[i].length; j++) {
				table[i][j].invert();
			}
		}
		image= table;
	}	

	/**
	 * Shifts the image down or up, according to the given offset.
	   Row 0 is moved into row offset, row 1 is moved into row offset+1, etc. 
	   offset may be negative (or 0).
	   Any row that is shifted in from outside the image should be all black.

	 * @param offset Offset to shift the image by.
	 */
	public void shiftRow(int offset) {
		
		RGBColor[][] table= makeBlack(0, imageRow, 0, imageCol);
		
		if ((offset>imageRow)|| (offset<-imageRow))
			image=table;
		
		if (offset>0){
			for (int i = 0; i < imageRow-offset; i++) {
				table[i+offset]= image[i];
			}
			image=table;
		}
	
		if (offset<0){
			for (int i = 0; i < imageRow+ offset; i++) {
				table[i]= image[i-offset];
			}
			image= table;
		}

	}

	/**
	 * Shifts the image left or right, according to the given offset.
	 Column 0 is moved into column offset, column 1 is moved into column 
	 offset+1, etc. offset may be negative (or 0).
	 Any column that is shifted in from outside the image should be all black.

	 * @param offset Offset to shift the image by.
	 */
	public void shiftCol(int offset) {
		
		RGBColor[][] table= makeBlack(0, imageRow, 0, imageCol);
		
		if ((offset>imageCol)|| (offset<-imageCol))
			image=table;
		
		if (offset>0){
			for (int i = 0; i < imageRow; i++) {
				for (int j=0; j <(imageCol-offset); j++){
					table[i][j+offset]= image[i][j];
				}
			}
			image= table;
		}
		
		if(offset<0){
			for (int i = 0; i < imageRow; i++) {
				for(int j = 0; j< imageCol+ offset; j++){
					table[i][j]= image[i][j-offset];
				}
			}
			image= table;
		}
	}

	/**
	 * Sets the pixel at the given coordinates.
	 Raises an error if the given coordinates are outside the image.

	 * @param row The row of the pixel to set.
	 * @param col The column of the pixel to set.
	 * @param pixel Contains the RGB values to set at the given coordinates.
	 */
	public void setPixel(int row, int col, intro.ex5.RGBColor pixel) {
	
		if (row<0 || col<0 || row> lastRow || col>lastCol)
			ErrorPrinter.error("pixel is not in the image!");
		image[row][col]=new RGBColor(pixel);
	}

	/**
	 * Gets an array of the color component values of this image's pixels.
	  The first index denotes
	  the row, the second index denotes the column, and the third index
	  denotes the color component (red=0, green=1, blue=2).

	 * @return An array containing the color component values of this image's
	  pixels.
	 */
	public int[][][] toIntArray() {
	
		int colors=3;
		int[][][] table= new int[imageRow][imageCol][colors];
		
		for (int i=0; i<imageRow; i++){
			for(int j=0; j< imageCol; j++){
				table[i][j][RED]= image[i][j].getRed();
				table[i][j][GREEN]= image[i][j].getGreen();
				table[i][j][BLUE]= image[i][j].getBlue();
			}
		}
		return table;
	}

	/**
	 * Return true if the images are equal, that is they have the same height and width, and for each
	   i and j in the legal ranges, the Color in row i column j are equal.

	 * @return true if the images are equal
	 */
	public boolean equals(RGBImage other) {
		
		if ((imageRow != other.getHeight()) || (imageCol != other.getWidth()))
			return false;
	
		for(int i=0; i<imageRow; i++){
			for (int j=0; j<imageCol; j++){
				if ((image[i][j].getRed() != other.getPixel(i,j).getRed())
						|| (image[i][j].getGreen() != other.getPixel(i,j).getGreen())
						||(image[i][j].getBlue() != other.getPixel(i,j).getBlue())){
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Flips the image around the vertical axis.  The first column becomes the
	    last column, The second becomes second to last, etc.

	 */
	public void flipVertical() {
	
		RGBColor[][] table= new RGBColor[imageRow][imageCol];
	
		for(int i=0; i<imageRow; i++){
			for (int j=0; j<imageCol; j++){
				table[i][j]= image[i][lastCol-j];
			}
		}
		image= table;
	}

	/**
	 * Flips the image around the horizontal axis.  The first row becomes the
	 last row, The second becomes second to last, etc.

	 */
	public void flipHorizontal() {
	
		RGBColor[][] table= new RGBColor[imageRow][imageCol];
		
		for(int i=0; i<imageRow; i++){
			for (int j=0; j<imageCol; j++){
				table[i][j]= image[lastRow-i][j];
			}
		}
		image= table;
	}

	/**
	 * Rotates the image 90 degrees clockwise.  
	 */
	public void rotateClockwise() {
	
		RGBColor[][] table= new RGBColor[imageCol][imageRow];
	
		for(int i=0; i<imageRow; i++){
			for (int j=0; j<imageCol; j++){
				table[j][lastRow-i]= image[i][j];
			}
		}
		
		image= table;
		int temp= imageRow;
		imageRow=imageCol;
		imageCol=temp;
		temp= lastRow;
		lastRow=lastCol;
		lastCol=temp;
	}

	/**
	 * Rotates the image 90 degrees counter-clockwise.  
	  Note that this may change the dimensions of the image.

	 */
	public void rotateCounterClockwise() {
	
		RGBColor[][] table= new RGBColor[imageCol][imageRow];
	
		for(int i=0; i<imageRow; i++){
			for (int j=0; j<imageCol; j++){
				table[lastCol-j][i]= image[i][j];
			}
		}
		
		image= table;
		int temp= imageRow;
		imageRow=imageCol;
		imageCol=temp;
		temp= lastRow;
		lastRow=lastCol;
		lastCol=temp;
	}

	/**
	 * Blurs the image.
	 * @param radius Radius of averaging.
	 */
	public void blurImage(int radius) {
	
		intToRGB (blurIt (toIntArray(),radius));
	}

	/**
	 * blurs the integers at an int[][][] array by the radius factor
	 * @param tableOri- original int[][][] table
	 * @param radius- radius of bluring
	 * @return- a blured int[][][]
	 */
	private int[][][] blurIt(int[][][] tableOri, int radius){
	
		int [][][] tableBlur= new int[tableOri.length][tableOri[0].length][tableOri[0][0].length];
		
		for(int i=0; i<tableOri.length; i++){
			for (int j=0; j<tableOri[i].length; j++){
				tableBlur[i][j]= sumNums (tableOri, i, j, radius);
			}
		}
		return tableBlur;
	}
	
	/**
	 * blurs a cell by making an average of the cells around it (with radius factor)
	 * @param table
	 * @param row
	 * @param col
	 * @param radius
	 * @return
	 */
	private int[] sumNums(int[][][] table,int row, int col, int radius){
	
		int sum=0;
		int[] colors= new int[3];
		colors[RED]=0;
		colors[GREEN]=0;
		colors[BLUE]=0;
		
		for (int i = -radius; i <= radius; i++) {
			for(int j=-radius; j<=radius; j++){
				if (cellInBound(row+i, col+j)){
					colors[RED]= colors[RED]+table[row+i][col+j][RED];
					colors[GREEN]= colors[GREEN]+table[row+i][col+j][GREEN];
					colors[BLUE]= colors[BLUE]+table[row+i][col+j][BLUE];
					sum++;
				}
				else
					sum++;
			}
		}

		colors[RED]=(int)((double) colors[RED]/sum );
		colors[GREEN]=(int)((double) colors[GREEN]/sum );
		colors[BLUE]=(int)((double) colors[BLUE]/sum );

		return colors;
	}

	/**
	 * checking if a cell is in the array
	 * @param row
	 * @param col
	 * @return
	 */
	private boolean cellInBound(int row,int  col){
	
		return (row>=0 && row<imageRow && col>=0 && col<imageCol);
	}
	
	/**
	 * transing an int[][][] array to a RGBColor[][] array
	 * @param table
	 */
	private void intToRGB(int[][][] table){
		
		RGBColor[][] colorTable= new RGBColor[imageRow][imageCol];
		for(int i=0; i<imageRow; i++){
			for(int j=0; j<imageCol; j++){
				colorTable[i][j]= new RGBColor( table[i][j][RED], table[i][j][GREEN], table[i][j][BLUE]);
			}
		}
		image= colorTable;
	}
}