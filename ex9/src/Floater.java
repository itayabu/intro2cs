import java.awt.Image;

import intro.ex9.GameGUI;
import intro.ex9.SpaceShipPhysics;


public class Floater extends SpaceShip {
	
	/**
	 * construct the spaceShip
	 * @param position- a spaceshipPhysics to defy where should it be constructed.
	 */
	public Floater(SpaceShipPhysics position) {
		super(position);
		accel=false;
	}

	/**
	 *  Does the actions of this ship for this round. 
 	This method is called once per round by the SpaceWars game driver.

	 * @param game the game object to which this ship belongs.
	 */
	@Override
	public void doAction(SpaceWars game) {
		pos.move(accel, 0);
	}

	/**
	 *  Gets the image of this ship. This method return the image of the
 	ship with or without the shield. This will be displayed on the GUI at
 	the end of the round.

	 * @return the image of the ship.
	 */
	@Override
	public Image getImage() {
		return 	GameGUI.ENEMY_SPACESHIP_IMAGE;
	}

}
