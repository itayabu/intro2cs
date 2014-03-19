
/**
* written by Itay Abulafia
* 303033286 itayabu
* Class RGBColors-represent a color, defined by its red, green and blue components.
*/

public class RGBColor {
	
	private int RED=0, BLUE=0, GREEN=0;

	/**
	 *Construct a new RGBColor with the given color component values. 
	 *Assumes the given values are legal (in the range 0-255).
	 */
	public RGBColor (int red, int green, int blue){
		RED=red;
		GREEN=green;
		BLUE=blue;
	}

	/**
	 *Construct a black RGBColor (red = green = blue = 0).
	 */
	public RGBColor (){
		RED=0;
		GREEN=0;
		BLUE=0;
	}

	/**
	 * Construct a new RGBColor which is a copy of the given color.
	 * Assumes the given color is not null.
	 */
	public RGBColor (RGBColor other){
		RED= other.getRed();
		BLUE= other.getBlue();
		GREEN= other.getGreen();
	}

	/**
	 * Returns the blue color component value of this RGBColor.
	 */
	public int getBlue(){
		return BLUE;
	}

	/**
	 * Returns the red color component value of this RGBColor.
	 */
	public int getRed(){
		return RED;
	}

	/**
	 * Returns the green color component value of this RGBColor.
	 */
	public int getGreen(){
		return GREEN;
	}

	/**
	 * Sets the red color component value of this RGBColor. 
	 * Assumes the given value is legal (in the range 0-255).
	 */
	public void setRed (int red){
		RED= red;
	}

	/**
	 * Sets the blue color component value of this RGBColor.
	 * Assumes the given value is legal (in the range 0-255).
	 */
	public void setBlue (int blue){
		BLUE= blue;
	}

	/**
	 * Sets the green color component value of this RGBColor.
	 * Assumes the given value is legal (in the range 0-255).
	 */
	public void setGreen (int green){
		GREEN= green;
	}

	/**
	 * Inverts the color of this RGBColor,
	 * by replacing each component value with its complement relative to 255.
	 */
	public void invert (){
		int maxColor=255;
		RED= maxColor-RED;
		BLUE= maxColor-BLUE;
		GREEN=maxColor-GREEN;
	}

	/**
	 * Changes this color to be a mix of this and other RGBColors.
	 */
	public void mix (RGBColor other){
		RED= (this.getRed() + other.getRed())/2;
		BLUE= (this.getBlue() + other.getBlue())/2;
		GREEN= (this.getGreen() + other.getGreen())/2;	
	}

	/**
	 * Returns the grayscale value of this RGBColor.
	 */
	public float convertToGrayscale(){
		int RED_GREY=30, GREEN_GREY=59, BLUE_GREY=11, PERCENT=100;
		return (float)(RED*RED_GREY + GREEN* GREEN_GREY + BLUE*BLUE_GREY)/PERCENT;
	}

	/**
	 * Compares this and other color.
	 * Returns true if this and other are the same RGBcolor
	 */
	public boolean equals (RGBColor other){
		if ((RED == other.getRed())//checking red
				&& (BLUE == other.getBlue()) &&//checking blue
				(GREEN == other.getGreen()))// checking green
			return true;
		else
			return false;
		
	}

}
