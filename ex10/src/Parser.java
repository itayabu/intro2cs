/**
 * class divide an expression to smaller terms, numbers and variables
 */

public class Parser extends java.lang.Object{
	/**
	 * 
	 */
	public Parser() {
	}
	/**
	 * Parses a factor. A Factor can be one of the following: 1) number; 2) variable; 3) expression in brackets.

	 * @param scan the Tokenizer

	 * @return Number object if the next element is number. 
 Variabe object if the next element is variable.  
 In case of expression in brackets it calls parseExpression for the expression in brackets and returns the result. 
 Returns null otherwise.
	 */
	public static Expression parseFactor(Tokenizer scan) { 
		ElementType check= scan.peek();
		
		if (check.equals(ElementType.NUMBER))
			return new Number(new Double (scan.nextElement()));
		
		if (check.equals(ElementType.VARIABLE))
			return new Variable(scan.nextElement());
		
		if (check.equals(ElementType.BRACKET)){
			//skip the bracket, check if there is something after the bracket
			scan.nextElement();
			if (scan.peek()!=null)
				return parseExpression(scan);
		}
		return null;
	}
	/**
	 * Parses an expression. An expression can be Term { [+/-] Term }.
 Calls parseTerm to get the first expression. 
 If operations "+" or "-" are followed, it calls ParseTerm again to get the second expression
 and creates an Operand object with the operand acts on the two obtained expressions. 
 The process is repeated for every addition "+" or "-" operation.

	 * @param scan the Tokenizer

	 * @return the result of parseTerm if only one operand exist. The operation result if more than one operand exist.
	 */
	public static Expression parseExpression(Tokenizer scan) {
		Expression current, right;
		String op;
		
		// has at least one term
		current = parseTerm(scan);
		
		// check if there is a second or more terms
		if (scan.peek().equals(ElementType.PLUS) || scan.peek().equals(ElementType.MINUS)){
			while (scan.peek().equals(ElementType.PLUS) || scan.peek().equals(ElementType.MINUS)){
				op= scan.nextElement();
				right= parseTerm(scan);
				current= new Operator (op, current, right);
			}
		}
		return current;
	}
	/**
	 * Parses a term. A term can be Factor { �\*  Factor }.
 Calls parseFactor to get the first expression.
 If operations "*" or "/" are followed, it calls ParseFactor again to get the second expression 
 and creates an Operand object with the operand acts on the two obtained expressions.
 The process is repeated for every addition "*" or "/" operation.

	 * @param scan the Tokenizer

	 * @return the result of parseFactor if only one operand exist. The operation result if more than one operand exist.
	 */
	public static Expression parseTerm(Tokenizer scan) {
		Expression current,right;
		String op;
		
		// there is at least one factor
		current = parseFactor(scan);
		// check if there is a second or more factors
		
		if (scan.peek().equals(ElementType.DIV) || scan.peek().equals(ElementType.MUL)){
			while (scan.peek().equals(ElementType.DIV) || scan.peek().equals(ElementType.MUL)){
				op= scan.nextElement();
				right= parseFactor(scan);
				current= new Operator (op, current, right);
			}
		}
		return current;
	}
}