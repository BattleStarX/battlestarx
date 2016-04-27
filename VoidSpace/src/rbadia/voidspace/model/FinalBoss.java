package rbadia.voidspace.model;


import java.awt.Rectangle;

import rbadia.voidspace.main.GameScreen;

/**
 * Represents a Final Boss.
 *
 */
public class FinalBoss extends Rectangle {
	private static final long serialVersionUID = 1L;

	public static final int DEFAULT_SPEED = 300;
	private static final int Y_OFFSET = 300; // initial y distance of the ship from the bottom of the screen 

	private int bossWidth = 45;
	private int bossHeight = 75;
	private int speed = DEFAULT_SPEED;

	/**
	 * Creates a new boss at the default initial location. 
	 * @param screen the game screen
	 */
	public FinalBoss(GameScreen screen){
		this.setLocation((screen.getWidth() - bossWidth)/2,
				screen.getHeight() - bossHeight - Y_OFFSET);
		this.setSize(bossWidth, bossHeight);
	}

	/**
	 * Get the default boss width
	 * @return the default boss width
	 */
	public int getShipWidth() {
		return bossWidth;
	}

	/**
	 * Get the default boss height
	 * @return the default boss height
	 */
	public int getShipHeight() {
		return bossHeight;
	}

	/**
	 * Returns the current boss speed
	 * @return the current boss speed
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * Set the current boss speed
	 * @param speed the speed to set
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	/**
	 * Returns the default boss speed.
	 * @return the default boss speed
	 */
	public int getDefaultSpeed(){
		return DEFAULT_SPEED;
	}

}
