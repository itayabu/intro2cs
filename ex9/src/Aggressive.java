import java.awt.Image;

import intro.ex9.GameGUI;
import intro.ex9.SpaceShipPhysics;


public class Aggressive extends SpaceShip {

	private double angleToShip,angleFromShip;
	private final static int CAN_SHOOT=8;
	private int isCool=0;

	/**
	 * construct the spaceShip
	 * @param position- a spaceshipPhysics to defy where should it be constructed.
	 */
	public Aggressive(SpaceShipPhysics position) {
		super(position);
		accel=true;
	}
	
	/**
	 * check if able to fire
	 * @param game
	 */
	private void isFire(SpaceWars game){
		isCool++;
		if (isCool>=CAN_SHOOT) {
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
		angleToShip= pos.angleTo(game.getClosestShipTo(this).pos);
		angleFromShip= game.getClosestShipTo(this).pos.distanceFrom(pos);

		if(angleFromShip<=MIN_PARAMETER)
			isFire(game);
		pos.move(accel, moveTo());
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
