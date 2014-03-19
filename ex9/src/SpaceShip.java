import intro.ex9.*;

import java.awt.Image;
/**
 *  Abstract class spaceship contain the methods and fields for every spaceship.
 */

public abstract class SpaceShip{

	// think to delete setHealth and setEnergy. so only subclasses can change them.
	// must delete isShieldOn, made the boolean protected
	/**
	 * The position and physics of the ship. 
	 */
	
	protected SpaceShipPhysics pos; /**the physic body of the spaceShip*/
	protected int health, energy;
	protected final static double MIN_PARAMETER=0.2;
	protected static final int START_HEALTH=10,  FIRE_ENERGY=25,
			SHIELD_ENERGY_COST=3, TELEPORT_ENERGY_COST=150,START_ENERGY=200,RIGHT=-1, LEFT=1;
	protected boolean isShieldOn=false, accel;

	/**
	 * construct a new space ship
	 * @param position- a physics body for the ship
	 */
	public SpaceShip (SpaceShipPhysics position){
		pos= position;
		health=START_HEALTH;
		energy=START_ENERGY;
		isShieldOn=false;
	}
	/**
	 *  This method is called every time a collision with this ship occurs.
	 */
	public void collidedWithAnotherShip() {
		gotHit();
	}
	
	/**
	 *  Does the actions of this ship for this round. 
 	This method is called once per round by the SpaceWars game driver.

	 * @param game the game object to which this ship belongs.
	 */
	public abstract void doAction(SpaceWars game);

	/**
	 *  Gets the image of this ship. This method return the image of the
 	ship with or without the shield. This will be displayed on the GUI at
 	the end of the round.

	 * @return the image of the ship.
	 */
	public abstract Image getImage();
	
	/**
	 *  Gets the physics object that controls this ship.
	 * @return the physics object that controls the ship.
	 */
	public SpaceShipPhysics getPhysics() {
		return pos;
	}
	
	/**
	 *  This method is called by the SpaceWars game object when ever this ship
 	gets hit by a shot.

	 */
	public void gotHit() {
		if (!isShieldOn)
			health--;
	}

	/**
	 *  Checks if this ship is dead.
	 * @return true if the ship is dead. false otherwise.
	 */
	public boolean isDead() {
		if (health<=0)
			return true;
		return false;
	}

	/**
	 *  This method is called whenever a ship has died. It resets the ship's 
 		attributes, and starts it at a new random position.

	 */
	public void reset() {
		health=START_HEALTH;
		energy=START_ENERGY;
		pos= new SpaceShipPhysics();

	}

	/**
	 * fire a shot when called
	 */
	public void fire(SpaceWars game) {
		if (energy>=FIRE_ENERGY){
			energy-=FIRE_ENERGY;
			game.addShot(pos);
		}
	}
	
	
	/**
	 * return health left for this ship
	 * @return ship's health
	 */
	public int getHealth(){
		return health;
	}
	
	
	/**
	 * get the energy left for this ship
	 * @return ship's energy
	 */
	public int getEnergy(){
		return energy;
	} 
	
	/**
	 * turns ship's shield on
	 */
	public void turnShieldOn(){
		if(energy>=SHIELD_ENERGY_COST){
			isShieldOn=true;
		}
	}
	
	/**
	 * turns ship's shield off
	 */
	public void turnShieldOff(){
		isShieldOn=false;
	}
	
	/**
	 * answer the question is the shield on?
	 * @return true if the shield is on, false if not
	 */
	public boolean isShieldOn(){
		return isShieldOn;
	}
	
	/**
	 * copy the ship to a new location and a new direction
	 */
	public void teleport(){
		if (energy>= TELEPORT_ENERGY_COST){
			pos= new SpaceShipPhysics();
			energy-=TELEPORT_ENERGY_COST;
		}
	}
	public void regeneretedEnergy(){
		if (energy<START_ENERGY)
			energy++;
	}
}