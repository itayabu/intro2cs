
/**
* 
The class Number for ex. 10. Represents a number that has a double value.

*/

public class Number implements Expression{
	
	private Double value;
    /**
    * Constructor that builds a Number object. Gets and stores the value of the number.

    * @param value the value of the number.
    */
    public Number(double value) {
    	this.value=new Double(value);
    }
    /**
    * Returns the value of the number. The Map parameter is for uniformity purposes and is not used here.

    * @param env a Map used to evaluate unknown expressions (unused).

    * @return the value of the number.
    */
    public double eval(java.util.Map<String,java.lang.Double> env) {
		return value.doubleValue();

    }
    /**
    * String representation of the number.

    * @param order the operator order used to build the String.

    * @return the number as String (regardless of the order).
    */
    public String toString(OpOrder order) {
		return value.toString(); 

    }
}