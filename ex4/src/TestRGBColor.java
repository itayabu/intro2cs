/**
 * testing Class- checking the RGBColor is working properly.
 */
import java.util.Random;
public class TestRGBColor {
	//using random numbers to check randomly.
	static Random random= new Random();
	//RUNNING_SEQUENCE- as many run tries as we want.
	final static int COLOR_RANGE=256, COLOR_NUM=255, RUNNING_SEQUENCE=50;

	/**
	 * checking for bugs
	 */
	public static void main(String[] args) {
		for (int i = 0; i < RUNNING_SEQUENCE; i++) {	
		checkConstructor();
		checkCopy();
		checkGetRed();
		checkGetGreen();
		checkGetBlue();
		checkSetRed();
		checkSetGreen();
		checkSetBlue();
		checkInvert();
		checkMix();
		checkConvertToGreyscale();
		checkEquals();
		checkEqualsTow();
		checkConstructorColor();
		}
	}

	private static void checkConstructor(){
		RGBColor tOne= new RGBColor();
		RGBColor tTow= new RGBColor(0, 0, 0);
		
		if ((tOne.getRed() != tTow.getRed()) 
				|| (tOne.getGreen() != tTow.getGreen()) 
				|| (tOne.getBlue() != tTow.getBlue()))
			System.out.println("problem at basic constructors");

	}

	private static void checkCopy(){
		int red= random.nextInt(COLOR_RANGE), green= random.nextInt(COLOR_RANGE), blue=random.nextInt(COLOR_RANGE);
		RGBColor tOne= new RGBColor(red, green, blue);
		RGBColor tTow= new RGBColor(tOne);
		
		if ((tOne.getRed() != tTow.getRed()) 
				|| (tOne.getGreen() != tTow.getGreen()) 
				|| (tOne.getBlue() != tTow.getBlue()))
			System.out.println("problem at basic constructors");
	}

	private static void checkConstructorColor(){
		int red= random.nextInt(COLOR_RANGE), green= random.nextInt(COLOR_RANGE), blue=random.nextInt(COLOR_RANGE);
		RGBColor tOne= new RGBColor(red, green, blue);
	
		if((tOne.getRed() != red)|| (tOne.getGreen()!= green) || (tOne.getBlue() != blue))
			System.out.println("problem with color constructor");
	}
	
	private static void checkGetRed(){
		int rnd= random.nextInt(COLOR_RANGE);
		RGBColor tOne= new RGBColor(rnd, 0, 0);
		
		if (rnd != tOne.getRed())
			System.out.println("problem with getRed");
	}

	private static void checkGetGreen(){
		int rnd= random.nextInt(COLOR_RANGE);
		RGBColor tOne= new RGBColor( 0, rnd, 0);
	
		if (rnd != tOne.getGreen())
			System.out.println("problem with getGreen");
	}

	private static void checkGetBlue(){
		int rnd= random.nextInt(COLOR_RANGE);
		RGBColor tOne= new RGBColor(0, 0, rnd);
	
		if (rnd != tOne.getBlue())
			System.out.println("problem with getBlue");

	}

	private static void checkSetRed(){
		int rnd= random.nextInt(COLOR_RANGE);
		RGBColor tOne= new RGBColor();
		tOne.setRed(rnd);
	
		if (rnd != tOne.getRed())
			System.out.println("problem with setRed");
	}

	private static void checkSetGreen(){
		int rnd= random.nextInt(COLOR_RANGE);
		RGBColor tOne= new RGBColor();
		tOne.setGreen(rnd);
	
		if (rnd != tOne.getGreen())
			System.out.println("problem with setGreen");
	}

	private static void checkSetBlue(){
		int rnd= random.nextInt(COLOR_RANGE);
		RGBColor tOne= new RGBColor();
		tOne.setBlue(rnd);
	
		if (rnd != tOne.getBlue());
	}

	private static void checkInvert(){
		int red= random.nextInt(COLOR_RANGE), green= random.nextInt(COLOR_RANGE), blue=random.nextInt(COLOR_RANGE);
		RGBColor tOne= new RGBColor(red, green, blue);
		tOne.invert();
		red= COLOR_NUM-red;
		green= COLOR_NUM-green;
		blue= COLOR_NUM-blue;
	
		if (tOne.getRed()!=red
				|| tOne.getGreen()!=green 
				|| tOne.getBlue()!=blue)
			System.out.println("problem with invert");
	}

	private static void checkMix(){
		int red= random.nextInt(COLOR_RANGE), green= random.nextInt(COLOR_RANGE), blue=random.nextInt(COLOR_RANGE);
		int redt= random.nextInt(COLOR_RANGE), greent= random.nextInt(COLOR_RANGE), bluet=random.nextInt(COLOR_RANGE);
		RGBColor tOne= new RGBColor(red, green, blue);
		RGBColor tTow= new RGBColor(redt, greent, bluet);
		
		tOne.mix(tTow);
	
		red= (red+redt)/2;
		green= (green+greent)/2;
		blue= (blue+bluet)/2;
	
		if (tOne.getRed() != red || tOne.getGreen() != green || tOne.getBlue() != blue)
			System.out.println("problem with mix");
	}

	private static void checkConvertToGreyscale(){
		int RED_GREY=30, GREEN_GREY=59, BLUE_GREY=11, PERCENT=100;
		int red= random.nextInt(COLOR_RANGE), green= random.nextInt(COLOR_RANGE), blue=random.nextInt(COLOR_RANGE);
		RGBColor tOne= new RGBColor(red, green, blue);
		
		float grey= (float)(red*RED_GREY + green* GREEN_GREY + blue*BLUE_GREY)/PERCENT;
		
		if (tOne.convertToGrayscale()!= grey)
			System.out.println("problem with convert");
	}

	private static void checkEquals(){
		int red= random.nextInt(COLOR_RANGE), green= random.nextInt(COLOR_RANGE), blue=random.nextInt(COLOR_RANGE);
		RGBColor tOne= new RGBColor(red, green, blue);
		RGBColor tTow= new RGBColor(red, green, blue);
		
		if (!tOne.equals(tTow))
			System.out.println("problem with equals");
	}

	private static void checkEqualsTow(){
	
		int red= random.nextInt(COLOR_RANGE), green= random.nextInt(COLOR_RANGE), blue=random.nextInt(COLOR_RANGE);
		int redt= random.nextInt(COLOR_RANGE), greent= random.nextInt(COLOR_RANGE), bluet=random.nextInt(COLOR_RANGE);
		RGBColor tOne= new RGBColor(red, green, blue);
		RGBColor tTow= new RGBColor(redt, greent, bluet);
		
		if (tOne.equals(tTow))
			System.out.println("problem with equals");
	}
}



