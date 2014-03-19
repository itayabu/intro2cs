import intro.ex9.SpaceShipPhysics;

/**
 * crazy human spaceShip acts like a human spaceship only with a possibility to randomly teleport.
 * press up to accelerate, left or right to move, t to teleport, s to rise on or off the shield and f to fire. 
 *
 */
public class CrazyHuman extends Human {
	
	private final static double TELEPORT_PERCENT=0.2;

	/**
	 * construct the spaceShip
	 * @param position- a spaceshipPhysics to defy where should it be constructed.
	 */
	public CrazyHuman(SpaceShipPhysics position) {
		super(position);
	}
	
	/**
	 *  Does the actions of this ship for this round. 
 	This method is called once per round by the SpaceWars game driver.

	 * @param game the game object to which this ship belongs.
	 */
	public void doAction(SpaceWars game){
		/** extend the Human do action and adding the randomize teleporting*/
		super.doAction(game);
		if (Math.random()<TELEPORT_PERCENT){
			teleport();
		}
	}
}
