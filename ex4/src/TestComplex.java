/**
 * testing Class- checking the Complex class is working properly.
 */

import java.util.Random;
public class TestComplex {
	
	static Random random= new Random();
	final static int RADIUS= 5,MAX_INT= 3, INFINITY= -1, RUNNING_SEQUENCE=50;
	final static double EPSILON= 0.0000001,BIG_NUM_ONE=2,BIG_NUM_TOW=3;
	
	/**
	 * checking for bugs
	 */
	public static void main(String[] args) {

		for (int i = 0; i < RUNNING_SEQUENCE; i++) {
			checkGetReal();
			checkGetImg();
			checkPlus();
			checkMinus();
			checkMult();
			checkDiv();
			checkSquare();
			checkEqualsOne();
			checkEqualsTow();
			checkEqualsThree();
			checkEqualsFour();
			checkAbsValue();
			checkAngleZero();
			checkAnglePositive();
			checkAngleNegetive();
			checkAngelRealZero();
			checkAngleHalfNegetive();
			checkEscapeGood();
			checkEscapeBad();
			checkEscapeBadTow();
			checkConjugate();
			checkEscapeRunZero();
			checkEscapeRadiousZero();
			checkNulls();
		}
	}

	private static void checkGetReal(){
		
		double real= random.nextDouble()*20 - 10, img= random.nextDouble()*20 - 10;
		Complex tOne= new Complex (real, img);
		
		if (tOne.getReal() != real)
			System.out.println("problem with getReal");
	}

	private static void checkGetImg(){
		
		double realOne= random.nextDouble()*20 - 10, imgOne= random.nextDouble()*20 - 10;
		Complex tOne= new Complex (realOne, imgOne);
		
		if (tOne.getImg() != imgOne)
			System.out.println("problem with getImg");
	}

	private static void checkPlus(){

		double realOne= random.nextDouble()*20 - 10, imgOne= random.nextDouble()*20 - 10;
		double realOther= random.nextDouble()*20 - 10, imgOther= random.nextDouble()*20 - 10;
		Complex tOne= new Complex(realOne, imgOne);
		Complex otherComp= new Complex (realOther, imgOther);

		tOne= tOne.plus(otherComp);
		if ((tOne.getReal()!= realOne + realOther)
				|| (tOne.getImg()!= imgOne + imgOther))
			System.out.println("problem with plus");
	}

	private static void checkMinus(){

		double realOne= random.nextDouble()*20 - 10, imgOne= random.nextDouble()*20 - 10;
		double realOther= random.nextDouble()*20 - 10, imgOther= random.nextDouble()*20 - 10;
		Complex tOne= new Complex(realOne, imgOne);
		Complex otherComp= new Complex (realOther, imgOther);

		tOne= tOne.minus(otherComp);
		if ((tOne.getReal()!= realOne - realOther)
				|| (tOne.getImg()!= imgOne - imgOther))
			System.out.println("problem with minus");
	}

	private static void checkMult(){

		double realOne= random.nextDouble()*20 - 10, imgOne= random.nextDouble()*20 - 10;
		double realOther= random.nextDouble()*20 - 10, imgOther= random.nextDouble()*20 - 10;
		Complex tOne= new Complex(realOne, imgOne);
		Complex otherComp= new Complex (realOther, imgOther);

		tOne= tOne.mult(otherComp);
		if ((tOne.getReal()!= (realOne * realOther)- (imgOne * imgOther))
				|| (tOne.getImg()!= (imgOne * realOther)+ (realOne * imgOther)))
			System.out.println("problem with multy");
	}

	private static void checkDiv(){

		double realOne= random.nextDouble()*20 - 10, imgOne= random.nextDouble()*20 - 10;
		double realOther= random.nextDouble()*20 - 10, imgOther= random.nextDouble()*20 - 10;
		Complex tOne= new Complex(realOne, imgOne);
		Complex otherComp= new Complex (realOther, imgOther);

		tOne= tOne.div(otherComp);
		if ((tOne.getReal()!= (realOne * realOther + imgOne * imgOther)
				/ (imgOther * imgOther + realOther * realOther))
				|| (tOne.getImg()!= (imgOne * realOther - realOne * imgOther)/(imgOther * imgOther + realOther * realOther)))
			System.out.println("problem with dividing");
	}

	private static void checkSquare(){

		double realOne= random.nextDouble()*20 - 10, imgOne= random.nextDouble()*20 - 10;
		Complex tOne= new Complex(realOne, imgOne);
		tOne= tOne.square();
		if ((tOne.getReal()!= (realOne * realOne)- (imgOne * imgOne))
				|| (tOne.getImg()!= (imgOne * realOne)+ (realOne* imgOne)))
			System.out.println("problem with multy");
	}

	private static void checkConjugate(){
		double realOne= random.nextDouble()*20 - 10, imgOne= random.nextDouble()*20 - 10;
		Complex tOne= new Complex(realOne, imgOne);

		tOne.conjugate();
		if((tOne.conjugate().getReal() != realOne) || (tOne.conjugate().getImg() != -imgOne)){
			System.out.println("problem with conjugate");
		}
	}

	private static void checkEqualsOne(){
		double realOne= random.nextDouble()*20 - 10, imgOne= random.nextDouble()*20 - 10;
		double realOther= random.nextDouble()*20 - 10, imgOther= imgOne+1;
		Complex tOne= new Complex(realOne, imgOne);
		Complex otherComp= new Complex (realOther, imgOther);

		if (tOne.equals(otherComp))
			System.out.println("problem with equals");
	}

	private static void checkEqualsTow(){

		double realOne= random.nextDouble()*20 - 10, imgOne= random.nextDouble()*20 - 10;
		Complex tOne= new Complex(realOne, imgOne);
		Complex otherComp= new Complex (realOne, imgOne);

		if (! tOne.equals(otherComp))
			System.out.println("problem with equals");

	}

	private static void checkEqualsThree(){
		double realOne= random.nextDouble()*20 - 10, imgOne= random.nextDouble()*20 - 10;
		double realOther= realOne+1, imgOther= random.nextDouble()*20 - 10;
		Complex tOne= new Complex(realOne, imgOne);
		Complex otherComp= new Complex (realOther, imgOther);
	
		if (tOne.equals(otherComp))
			System.out.println("problem with equals");
	}

	private static void checkEqualsFour(){
		double realOne= random.nextDouble()*20 - 10, imgOne= random.nextDouble()*20 - 10;
		double realOther= realOne+EPSILON, imgOther=imgOne;
		Complex tOne= new Complex(realOne, imgOne);
		Complex otherComp= new Complex (realOther, imgOther);
	
		if (!tOne.equals(otherComp))
			System.out.println("problem with equals");
	}

	private static void checkAbsValue(){
		double realOne= random.nextDouble()*20 - 10, imgOne= random.nextDouble()*20 - 10;
		Complex tOne= new Complex(realOne, imgOne);

		tOne.getAbsValue();
		if (tOne.getAbsValue()!= Math.sqrt((realOne * realOne)+(imgOne * imgOne)))
			System.out.println("problem with absValue");
	}

	private static void checkAngleZero(){

		Complex tOne = new Complex(0,0);
		if (tOne.getAngle() != 0)
			System.out.println("problem with angle at zero, zero");
	}

	private static void checkAnglePositive(){
		double realOne= random.nextDouble()*20 + 21, imgOne= random.nextDouble()*20 + 21;//positive numbers
		Complex tOne= new Complex(realOne, imgOne);

		if (tOne.getAngle() <= 0)
			System.out.println("problem with positive angles");
	}

	private static void checkAngleNegetive(){
		double realOne= random.nextDouble()*20 - 21, imgOne= random.nextDouble()*20 - 21;// negetive numbers
		Complex tOne= new Complex(realOne, imgOne);
		
		if (tOne.getAngle() != Math.atan(imgOne/realOne)-Math.PI)
			System.out.println("problem with negetive angle");
	}

	private static void checkAngleHalfNegetive(){
		double realOne= random.nextDouble()*20 - 21, imgOne= random.nextDouble()*20 + 21;//half negetive
		Complex tOne= new Complex(realOne, imgOne);
		
		if (tOne.getAngle() != Math.atan(imgOne/realOne)+Math.PI)
			System.out.println("problem with negetive angle");
	}

	private static void checkAngelRealZero(){
		double realOne= random.nextDouble()*20+21;
		double realTow= random.nextDouble()*20 -21;
		Complex tOne= new Complex(0, realOne);
		Complex tTow= new Complex(0, realTow);
		
		if (tOne.getAngle() != (Math.PI/2))
			System.out.println("problem with zero at real and positive img");
		if (tTow.getAngle()!= (-Math.PI/2))
			System.out.println("problem with zero at real and negetive img");
	}

	private static void checkEscapeGood(){
		Complex tOne= new Complex (0,1);
		
		if (tOne.escapeTime(RADIUS, MAX_INT)>INFINITY)
			System.out.println("problem with good sets at escape time");
	}

	private static void checkEscapeBad(){
		Complex tOne= new Complex (1,0);
		int ROUNDS=3;
		int ESCAPE_ROUNDS=tOne.escapeTime(RADIUS, MAX_INT);
		
		if (ESCAPE_ROUNDS!=ROUNDS)
			System.out.println("problem with bad sets at escape time");
	}
	
	private static void checkEscapeBadTow(){
		Complex tOne= new Complex (1,0);
		int ROUNDS=3;
		int ESCAPE_ROUNDS=tOne.escapeTime(RADIUS+1, MAX_INT);
	
		if (ESCAPE_ROUNDS==ROUNDS)
			System.out.println("problem with bad sets at escape time");
	}

	private static void checkEscapeRunZero(){
		double realOne= random.nextDouble()*20 - 10, imgOne= random.nextDouble()*20 - 10;
		Complex tOne= new Complex(realOne,imgOne);
		
		if (tOne.escapeTime(1, 0)> INFINITY)
			System.out.println("problem with run at zero");
	}

	private static void checkEscapeRadiousZero(){
		double realOne= random.nextDouble()*20 - 10, imgOne= random.nextDouble()*20 - 10;
		Complex tOne= new Complex(realOne,imgOne);
		
		if (tOne.escapeTime(0, MAX_INT) !=1)
			System.out.println("problem at Radious Zero");
	}

	private static void checkNulls(){
		double realOne= random.nextDouble()*20 - 10, imgOne= random.nextDouble()*20 - 10;
		Complex tOne= new Complex(realOne, imgOne);
		Complex nullComp= null;
		
		if (tOne.plus(nullComp)!= null)
			System.out.println("problem with null");
		if (tOne.minus(nullComp)!= null)
			System.out.println("problem with null");
		if (tOne.div(nullComp)!= null)
			System.out.println("problem with null");
		if (tOne.mult(nullComp)!= null)
			System.out.println("problem with null");
		if (tOne.equals(nullComp))
			System.out.println("problem with null");
	}
	















}
