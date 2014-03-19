/**
* 
The class Operator for ex. 10. An operator can be one of 4 basic mathematical 
operators (+,-,*,/), and holds the two expressions that it operates on.

*/

public class Operator implements Expression{
	
	private Expression left, right;
	private String op;
	private final String plus="+", minus="-", mult="*", dive="/";//not to use "div"
    /**
    * Constructor that builds an Operator object. Gets the operator symbol (+,-,*,/) and the
 two expressions that it operates on.

    * @param operator String representation of the operation.
    * @param left The left expression.
    * @param right The right expression.
    */
    public Operator(String operator, Expression left, Expression right) {
    	this.left=left;
    	this.right=right;
    	op = operator;
    }
    /**
    * String representation of the expression. This representation can be INFIX,PREFIX or POSTFIX, 
 depending with the requested operator order.

    * @param order the operator order used to build the String.
 If order==OpOrder.INFIX, brackets are added for every operation. 
 If order==OpOrder.POSTFIX or order==OpOrder.PREFIX, space is added between the operands.

    * @return representation of the expression as String.
    */
    public String toString(OpOrder order) {
    // handle three cases of print command
    	if (order.equals(OpOrder.INFIX))
    		return "("+left.toString(order)+op+right.toString(order)+")";
    	if (order.equals(OpOrder.POSTFIX))
    		return left.toString(order)+" "+ right.toString(order)+" "+op;
    	else
    		return op + " "+ left.toString(order)+" "+ right.toString(order);
    }
    /**
    * Evaluates an expression. The value of an Operator is the result of its operation on its operands.
 The Map of variables is passed to the operands to evaluate the value of variables.

    * @param env a Map used to evaluate unknown expressions.

    * @return the value of the expression
    */
    public double eval(java.util.Map<String,java.lang.Double> env) {
    	switch (op){
    		case plus:
    			return left.eval(env)+right.eval(env);
    		case minus:
    			return left.eval(env)-right.eval(env);
    		case mult:
    			return left.eval(env)*right.eval(env);
    		case dive:
    			return left.eval(env)/right.eval(env);
    		default:
    			return left.eval(env)+right.eval(env);
    	}
    }
}