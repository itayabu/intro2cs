import java.awt.Image;
import intro.ex9.*;

/**
 * This class contains a single static method that is used to create spaceships
 * of the requested type in the game. You should implement it accordingly.
 */
public class SpaceShipFactory {
    private static final String FloatShip="f", runner="r", human="h", basher="b", crazy="c", aggressive="a", special="s";
    /**
     * Creates the spaceships in the game according to the passed array of 
     * spaceships names (h,r,f,s,...).
     * See how it is used in SpaceWars.java main method.
     * @param spaceships the command line arguments of SpaceWars 
     * (e.g. spaceships={"h","r","f"}).
     * @return the array of spaceships.
     */
    public static SpaceShip[] createSpaceShips(String[] spaceships) {
    	SpaceShip[] shipArray= new SpaceShip[spaceships.length];
    	if (spaceships==null || spaceships.length<1)
    		return null;
    	for (int i=0;i <shipArray.length;i++ ){
    		switch (spaceships[i]){
    		case FloatShip:
    			shipArray[i]= new Floater(new SpaceShipPhysics());
    			break;
    		case runner:
    			shipArray[i]= new Runner(new SpaceShipPhysics());
    			break;
    		case human:
    			shipArray[i]= new Human(new SpaceShipPhysics());
    			break;
    		case basher:
    			shipArray[i]= new Basher(new SpaceShipPhysics());
    			break;
    		case crazy:
    			shipArray[i]= new CrazyHuman(new SpaceShipPhysics());
    			break;
    		case aggressive:
    			shipArray[i]= new Aggressive(new SpaceShipPhysics());
    			break;
    		case special:
    			shipArray[i]= new Special(new SpaceShipPhysics());
    			break;
    		}
    	}
		return shipArray;
    }
}