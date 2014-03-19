import java.util.HashMap;
import java.lang.Double;

/**
* 
The class Evaluator for ex. 10. Holds a mathematical expression and
maintains the environment of variable values as a Map.

*/

public class Evaluator{
	
	HashMap<String, Double> varMap;
	String currentExp;
	Tokenizer currExp;
	Expression answer;
    /**
    * Default Constructor that builds an evaluator object.

    */
    public Evaluator() {
    	varMap= new HashMap<>();
    }
    /**
    * Assigns a value to variable. Values are stored in a Map that maps variables to values.

    * @param variable the variable name.
    * @param value the value to assign.
    */
    public void assignValueToVariable(String variable, double value) {
    	varMap.put(variable, (Double) value);
    }
    /**
    * Builds an expression tree from the expression accepted as a parameter and stores it as the current expression.

    * @param expression the string to build an expression tree for.
    */
    public void setCurrentExpression(String expression) {
    	currentExp=expression;
    	currExp= new Tokenizer(currentExp);
    	answer= Parser.parseExpression(currExp);
    }
    
	/**
    * Evaluates the expression while using the Map of variables the the class holds to return its numeric value.

    * @return the value of the expression if all the variables are assigned a value, Double.NaN otherwise.
    */
    public double eval() {
    	return answer.eval(varMap);
    }
    /**
    * Prefix notation of the current expression. Space is added between operands.

    * @return Prefix notation of the expression.
    */
    public String prefix() {
    	return answer.toString(OpOrder.PREFIX);
    }
    /**
    * Postfix notation of the current expression. Space is added between operands.

    * @return Postfix notation of the expression.
    */
    public String postfix() {
    	return answer.toString(OpOrder.POSTFIX);
    }
    /**
    * Infix notation of the current expression.  
 Brackets are added for every operation.

    * @return Infix notation of the expression.
    */
    public String infix() {
    	return answer.toString(OpOrder.INFIX);
    }
}