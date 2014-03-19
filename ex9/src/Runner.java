import java.awt.Image;
import intro.ex9.GameGUI;
import intro.ex9.SpaceShipPhysics;

public class Runner extends SpaceShip {
	
	private double angleToShip,distanceFromShip, angleFromShip;
	
	/**
	 * construct the spaceShip
	 * @param position- a spaceshipPhysics to defy where should it be constructed.
	 */
	public Runner(SpaceShipPhysics position) {
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
		angleFromShip= game.getClosestShipTo(this).pos.distanceFrom(pos);
		
		if(angleFromShip<MIN_PARAMETER && distanceFromShip<MIN_PARAMETER)
			teleport();
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
			return LEFT;
		if(angleToShip>0)
			return RIGHT;
			return 0;
	}


}
