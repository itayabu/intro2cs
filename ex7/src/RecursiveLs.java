import intro.ex7.*;

/**
 * 	class Contains a single static method that iterates recursively over folders 
 *  beginning at a certain root and prints the contents using an instance of FileDisplay.
 *
 */
public class RecursiveLs {

	public RecursiveLs() {
	}

	/**
	 * Recursively prints the contents of root up to depth using an instance of FileDisplay.
	 * If depth is 0, just prints root. An increase of 1 in depth means printing another level down.

	 * @param depth The depth of the recursion.
	 * @param root The file or folder whos contents this method will display.
	 * @param gui The FileDisplay instance this method will use in order to print the output.
	 */
	public static void displayFileTree(int depth, IntroFile root, FileDisplay gui) {
		printList (0, depth, root, gui);
	}

	/**
	 * helper recursion method
	 */
	private static void printList(int indentation,int depth, IntroFile root, FileDisplay gui){

		gui.addLine(indentation, root.isDirectory(), root.getName());
		if (root.isFile()|| depth<=0)
			return;
		
		// if root is a directory, and the recursion is not over
		for (int i=0; i<root.listFiles().length; i++){
			printList (indentation+1, depth-1,root.listFiles()[i],gui);
		}
		return;

	}
}