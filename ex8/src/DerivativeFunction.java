/**
* 
This class represents a RealFunction that is the derivative
 of the other real function.

*/

public class DerivativeFunction implements RealFunction{
  
	private RealFunction f;
	private double epsilon;
	/**
    * Constructs a new DerivativeFunction object.
 Numerical computation of the derivative is performed at each point,
 epsilon is used to approximate the
 lim (f(x+t/2) - f(x-t/2))/t.

    * @param f the function whose derivative is to be approximated
    * @param epsilon the value used instead of t-->0
 in the derivative formula.
    */
    public DerivativeFunction(RealFunction f, double epsilon) {
    	this.f= f;
    	this.epsilon= epsilon;
    }
    /**
    * returns the value of f'(x).

    * @param x the x value given.

    * @return the value f'(x) of this function i.e (f(x+epsilon/2)-f(x-epsilon/2))/epsilon.
    */
    public double valueAt(double x) {
    	return ((f.valueAt(x+epsilon)/2- f.valueAt(x-epsilon)/2)/epsilon);
    }
    /**
    * returns a String representation of the Derivative function.

    * @return a String representation of the Derivative function.
    */
    public String toString() {
    	return "("+f.toString()+")'";
    }
}