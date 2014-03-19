/**
* 
The class Variable for ex. 10. A Variable is represented by its name.
The values of all the variables are held in a Map.

*/

public class Variable implements Expression{
	private String var;
    /**
    * Constructor that builds a Variable object. Variable name is given in variable name.

    * @param variableName the name of the variable.
    */
    public Variable(String variableName) {
    	var=variableName;
    }
    /**
    * String representation of the variable name.

    * @param order the operator order used to build the String.

    * @return the variable name (regardless of the order).
    */
    public String toString(OpOrder order) {
    	return var;
    }
    /**
    * Returns the value of the variable. Variables' values are as given in env.

    * @param env The Map giving for each variable name its value.

    * @return the value of the variable if it has a value assigned in env, Double.NaN otherwise.
    */
    public double eval(java.util.Map<String,java.lang.Double> env) {
    	if (env.containsKey(var))
    		return env.get(var);
    	return Double.NaN;
    }
}