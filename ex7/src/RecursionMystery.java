
/**
 *a class of tow recursion methods- the fibonacci code and a number binari code.
 */
public class RecursionMystery{
	private static final int half=2;
	/**
	 * return the fibonacci series value of the n's number
	 * @param n
	 * @return the fibonacci series value of the n's number
	 */
	public static int mystery1(int n){
		if (n==0 || n==1)
			return n;
		return mysteryOneHelper(0,1,2,n);	
	}

	/**
	 * recusive method of the fibonacci series
	 * @param fMinusTow starts as a 0
	 * @param fMinusOne starts as a 1
	 * @param i the index of the current fibonacci number
	 * @param n the original number input by the user
	 * @return the fibonacci number of the n' number
	 */
	private static int mysteryOneHelper(int fMinusTow,int fMinusOne, int i, int n){
		int f= fMinusTow+ fMinusOne;
		if (i==n)
			return f;
		return mysteryOneHelper (fMinusOne, f, i+1, n);

	}

	/**
	 * return array filled with the binari code of a given number 
	 * @param N- the number to be displayed
	 * @param res- the array.
	 */
	public static void mystery2(int N, int[] res){
		int i= res.length-1;
		res[i]= N%2;
		if (N>1)
			mysteryTowHelper(N/half, res, i-1);
	}

	/**
	 * recursive helping method- dividing the number to 2 and filling the array's place with its modulue.
	 * @param n
	 * @param res
	 * @param i
	 */
	private static void mysteryTowHelper(int n, int[] res, int i) {
		res[i]= n%half;
		if (n>1)
			mysteryTowHelper(n/half, res,i-1);
	}


}
