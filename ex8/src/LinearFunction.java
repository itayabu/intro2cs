/**
* 
This class implements a linear function.

*/

public class LinearFunction implements RealFunction{
	
	private double a, b;
    /**
    * Constructs a new LinearFunction. Receives two integers that are the coefficients of
 the linear function.

    * @param a the coefficient of x int the linear equation.
    * @param b the linear function's free coefficient.
    */
    public LinearFunction(double a, double b) {
    	this.a =a;
    	this.b =b;
    }
    /**
    * returns the f(x) value of the RealFunction.

    * @param x the x value given.

    * @return the f(x) value of this function i.e. a*x + b
    */
    public double valueAt(double x) {
    	return a*x+b;
    }
    /**
    * returns a String representation of the Linear function.

    * @return a String representation of the Linear function.
    */
    public String toString() {
    	return a+"*x+"+b;
    }
}