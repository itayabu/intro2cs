import java.awt.Image;

import intro.ex9.GameGUI;
import intro.ex9.SpaceShipPhysics;


public class Basher extends SpaceShip {

	private double angleToShip,distanceFromShip;

	/**
	 * construct the spaceShip
	 * @param position- a spaceshipPhysics to defy where should it be constructed.
	 */
	public Basher(SpaceShipPhysics position) {
		super(position);
		accel=true;
	}


	/**
	 *  Does the actions of this ship for this round. 
 	This method is called once per round by the SpaceWars game driver.

	 * @param game the game object to which this ship belongs.
	 */
	@Override
	public void doAction(SpaceWars game) {
		angleToShip= pos.angleTo(game.getClosestShipTo(this).pos);
		distanceFromShip= pos.distanceFrom(game.getClosestShipTo(this).pos);
		
		if(angleToShip<MIN_PARAMETER && distanceFromShip<MIN_PARAMETER)
			turnShieldOn();
		
		pos.move(accel, moveTo());
		if (isShieldOn)
			energy -= SHIELD_ENERGY_COST;
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
			return GameGUI.ENEMY_SPACESHIP_IMAGE_SHIELD;
		return GameGUI.ENEMY_SPACESHIP_IMAGE;
	}
	
	/**
	 * controlling where ship moves to
	 * @return -1 to right, 1 to left, 0 straight
	 */
	private int moveTo(){
		if (angleToShip<0)
			return RIGHT;
		if(angleToShip>0)
			return LEFT;
		return 0;
	}
}
