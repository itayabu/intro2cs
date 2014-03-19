import java.awt.Image;

import intro.ex9.GameGUI;
import intro.ex9.SpaceShipPhysics;

/**
 * human controlled ship
 * press up to accelerate, left or right to move, t to teleport, s to rise on or off the shield and f to fire.
 *
 */
public class Human extends SpaceShip {
	private boolean accel;
	private final int CAN_SHOOT=8;
	private int isCool=0;
	

	/**
	 * construct the spaceShip
	 * @param position- a spaceshipPhysics to defy where should it be constructed.
	 */
	public Human(SpaceShipPhysics position) {
		super(position);
	}
	
	/**
	 * check for teleport
	 * @param game
	 */
	private void tryTeleport(SpaceWars game){
		if (game.getGUI().isTPressed())
			teleport();
	}
	
	/**
	 * check acceleration
	 * @param game
	 */
	private void tryAccel(SpaceWars game){
		if (game.getGUI().isUpPressed())
			accel=true;
		else
			accel=false;
	}
	
	/**
	 * controlling where ship moves to
	 * @return -1 to right, 1 to left, 0 straight
	 */
	private void turn(SpaceWars game){
		if (game.getGUI().isRightPressed())
			pos.move(accel, RIGHT);
		else if (game.getGUI().isLeftPressed())
			pos.move(accel, LEFT);
		else
			pos.move(accel, 0);
	}
	
	/**
	 * check if can turn the shield on
	 * @param game
	 */
	private void shield(SpaceWars game){
		if(game.getGUI().isDPressed() && energy>SHIELD_ENERGY_COST){
				turnShieldOn();
				energy -= SHIELD_ENERGY_COST;
		}
	}
	
	/**
	 * check if able to fire
	 * @param game
	 */
	private void isFire(SpaceWars game){
		isCool++;
		if (isCool>=CAN_SHOOT && game.getGUI().isSPressed()) {
			fire(game);
			isCool=0;
		}
	}

	/**
	 *  Does the actions of this ship for this round. 
 	This method is called once per round by the SpaceWars game driver.

	 * @param game the game object to which this ship belongs.
	 */
	@Override
	public void doAction(SpaceWars game) {
		turnShieldOff();
		tryTeleport (game);
		tryAccel (game);
		turn (game);
		shield(game);
		isFire(game);
		regeneretedEnergy();
	}

	/**
	 *  Gets the image of this ship. This method return the image of the
 	ship with or without the shield. This will be displayed on the GUI at
 	the end of the round.

	 * @return the image of the ship.
	 */
	@Override
	public Image getImage() {
		if (isShieldOn)
			return GameGUI.SPACESHIP_IMAGE_SHIELD;
		return GameGUI.SPACESHIP_IMAGE;
	}	
	
}
