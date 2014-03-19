
/**
 * written by Itay abulafia
 * itayabu 303033286
 * class Complex- This class implements a Complex numbers and basic operations on them.
 */
public class Complex {
	/**
	 * constant EPSILON used for comparing numbers.
	2 double variables are considered equal if the distance between them is
	less than EPSILON.
	 */
	public static final double EPSILON= 0.0000001;
	private double REAL, IMG;

	/**
	 * Constructs a complex number.
	 * @param realNum- real part at complex
	 * @param imgNum- imaginary part at complex
	 */
	public Complex (double realNum, double imgNum){
		REAL= realNum;
		IMG= imgNum;
	}

	/**
	 *  Finds the conjugate of this complex number.
	 * @return The conjugate of this complex number.
	 */
	public Complex conjugate(){
		Complex conComp = new Complex (REAL, -IMG);
		return (conComp);
	}

	/**
	 * Returns the real part of the complex number.
	 * @return The real part of the complex number.
	 */
	public double getReal(){
		return REAL;
	}

	/**
	 * Returns the imaginary part of the complex number.
	 * @return The imaginary part of the complex number.
	 */
	public double getImg (){
		return IMG;
	}

	/**
	 * Adds the other complex number to this complex number.
	 * @param other- The complex number to add.
	 * @return The resulted complex number, null in case of null input.
	 */
	public Complex plus (Complex other){
		Complex plusComplex= new Complex(0,0);
		if (other== null)
			return null;
		plusComplex.REAL= (REAL+other.getReal());
		plusComplex.IMG= (IMG+other.getImg());
		return plusComplex;

	}


	/**
	 * Subtracts the given complex number from this complex number.
	 * @param other-  The complex number to subtract.
	 * @return The resulted complex number, null in case of null input
	 */
	public Complex minus (Complex other){
		if (other==null)
			return null;
		Complex minusComplex= new Complex(REAL, IMG);
		minusComplex.REAL= (REAL-other.getReal());
		minusComplex.IMG= (IMG - other.IMG);
		return minusComplex;

	}

	/**
	 * Performs multiplication with the given complex number. The result is returned as a new complex num.
	 * @param other-The complex number to perform the multiplication with.
	 * @returnThe multiplication result (complex number), null in case of null input.
	 * 	 */
	public Complex mult (Complex other){
		Complex multyComplex = new Complex(REAL,IMG);
		if (other == null)
			return null;
		multyComplex.REAL= ((this.getReal() * other.getReal())//ac
				- this.getImg() * other.getImg());			// -bd
		multyComplex.IMG= ((this.getImg() * other.getReal()) //bc
				+ (this.getReal() * other.getImg()));		 //+ad

		return multyComplex;

	}

	/**
	 * Perform division with the given complex number. The result is returned in a new complex num.
	 * @param other- The divisor (complex number).
	 * @return The division result (complex number), null in case of null input.
	 * 	 */
	public Complex div (Complex other){
		if (other==null)
			return null;
		double divReal= ((REAL * other.getReal() + IMG * other.getImg())
				/(other.getReal() * other.getReal() + other.getImg() * other.getImg()));
		double divImg= ((IMG * other.getReal() - REAL * other.getImg())
				/(other.getReal() * other.getReal() + other.getImg() * other.getImg()));
		Complex divComplex= new Complex(divReal, divImg);
		return divComplex;
	}

	/**
	 * Finds the square of this complex number.
	 * @return The square of this complex number.
	 */
	public Complex square (){
		if (this== null)
			return null;
		Complex sqareComplex = new Complex(REAL,IMG);
		sqareComplex.REAL= ((REAL * REAL)//ac
				- (IMG * IMG));			// -bd
		sqareComplex.IMG= ((IMG * REAL) //bc
				+ (REAL * IMG));		//+ad

		return sqareComplex;	
	}

	/**
	 * Compares this complex number to other and check if they are equal.
	 * @param other- The other complex number to compare.	
	 * @return True if this equals to other, false otherwise (false for null input as well).
	 */
	public boolean equals (Complex other){
		if (other == null) 
			return false;
		if (((REAL > other.REAL+EPSILON) || (REAL < other.REAL - EPSILON)
				|| ((IMG > other.IMG+EPSILON) || (IMG < other.IMG - EPSILON))))
			return false;
		else
			return true;
	}

	/**
	 * Returns the absolute value of the complex number.
	 * @return The absolute value of the complex number.
	 */
	public double getAbsValue(){
		return Math.sqrt((REAL * REAL)+(IMG * IMG));
	}

	/**
	 * Returns the absolute value of the complex number.
	 * @return
	 * The absolute value of the complex number.
	 */
	public double getAngle(){
		if ((REAL==0) && (IMG==0))
			return 0;
		if (REAL>0)
			return Math.atan(IMG/REAL);
		if (REAL<0){
			if (IMG<0)
				return (Math.atan(IMG/REAL)-(Math.PI));
			else
				return (Math.atan(IMG/REAL)+(Math.PI));
		}
		else{
			if (IMG > 0)
				return Math.PI /2;
			else
				return -(Math.PI /2);
		}
	}

	/**
	 * Finds the escape time of this complex number from the given Mandelbrot radius
	 * @param radious- The Mandelbrot radius.
	 * @param maxInteractios-The maximum escape time to check.
	 * @return The escape time of this complex number,
	  If this complex number did not escape in maxIteration return -1.
	 * 	 */
	public int escapeTime(int radious, int maxInteractios){
		int NOT_ESCAPING=-1;
		Complex runningAway= new Complex(REAL, IMG);
		for (int i = 1; i <= maxInteractios; i++) {
			if (runningAway.getAbsValue()>= radious)
				return i;
			runningAway= runningAway.square().plus(this);
		}
		return NOT_ESCAPING;
	}

	
}
