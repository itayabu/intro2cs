import java.util.Scanner;
import java.util.ArrayList;
/**
 * An application for drawing graphs of Real functions.
 */
public class FunctionParser {

    public FunctionParser() {
	list=new ArrayList<RealFunction>();
    }

    public void clear() {
	list.clear();
    }

    private static enum Types {
	CMP,COS,DRV,LNR,QUD,SIN,SUM,SAV;
    }
    
    public RealFunction parse(String str) {
	return parse(new Scanner(str));
    }

    private ArrayList<RealFunction> list;

    public RealFunction parse(Scanner in) {
	RealFunction f=read(in);
	System.err.println(f);
	list.add(f);
	return f;
    }

    public RealFunction read(Scanner in) {
	switch (Types.valueOf(in.next())) {
	case CMP: return new CompositeFunction(read(in),read(in));
	case COS: return new CosineFunction();
	case DRV: return new DerivativeFunction(read(in),in.nextDouble());
	case LNR: return new LinearFunction(in.nextDouble(),in.nextDouble());
	case QUD: return new QuadraticFunction(in.nextDouble());
	case SIN: return new SineFunction();
	case SUM: return new SumFunctions(read(in),read(in));
	case SAV: return list.get(in.nextInt());
	default: return null;
	}
    }


}
