import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

/**
 * An application for drawing graphs of Real functions.
 */
public class FunctionDrawing extends JFrame {

    /** The Constant DIMENSION. */
    private static final int DIMENSION = 400;

    /** Array of functions. */
    private RealFunction [] funcs;

    private static FunctionGraphics graphics;
	
    /**
     * The main method. 
     * Initialized the FunctionDrawing frame and creates 
     * the functions to draw.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
	FunctionDrawing fd = new FunctionDrawing();
	fd.createFunctions();
	fd.setTitle("Drawing real functions");
	fd.setBounds(0,0,DIMENSION,DIMENSION);
	fd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	fd.setVisible(true);
	graphics = new FunctionGraphics(DIMENSION,-4,4,-4,4);
    }
	
    /**
     * Creates real functions to later paint them.
     */
    public void createFunctions() {
	FunctionParser parser=new FunctionParser();
	funcs = new RealFunction[10];
	funcs[0] = parser.parse("CMP SIN LNR 5 0");
	funcs[1] = parser.parse("CMP LNR 3 0 SAV 0");
	funcs[2] = parser.parse("CMP COS LNR 3 0");
	funcs[3] = parser.parse("CMP LNR 3 0 SAV 2");
	funcs[4] = parser.parse("CMP LNR 2 0 COS");
	funcs[5] = parser.parse("CMP COS LNR 8 0");
	funcs[6] = parser.parse("CMP LNR 2 0 SIN");
	funcs[7] = parser.parse("CMP SIN LNR 8 0");
	funcs[8] = parser.parse("SUM SAV 4 SAV 5");
	funcs[9] = parser.parse("SUM SAV 6 SAV 7");
    }
	
    /**
     * Paints the functions
     */
    public void paint(Graphics g) {
	g.setColor(Color.red);
	graphics.drawGraph(funcs[1],funcs[3],g);
	g.setColor(Color.blue);
	graphics.drawGraph(funcs[8], funcs[9],g);
    }

}
