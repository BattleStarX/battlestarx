package rbadia.voidspace.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;

import rbadia.voidspace.model.Asteroid;
import rbadia.voidspace.model.Bullet;
import rbadia.voidspace.model.Ship;
import rbadia.voidspace.sounds.SoundManager;
import rbadia.voidspace.model.EnemyShip;

/**
 * Handles general game logic and status.
 */
public class GameLogic {
	private GameScreen gameScreen;
	private GameStatus status;
	private SoundManager soundMan;

	private Ship ship;
	private Asteroid asteroid;
	private List<Bullet> bullets;
	private List<Asteroid> asteroids;
	private EnemyShip enemyShip;

	/**
	 * Create a new game logic handler
	 * @param gameScreen the game screen
	 */
	public GameLogic(GameScreen gameScreen){
		this.gameScreen = gameScreen;

		// initialize game status information
		status = new GameStatus();
		// initialize the sound manager
		soundMan = new SoundManager();

		// init some variables
		bullets = new ArrayList<Bullet>();
		asteroids = new ArrayList<Asteroid>();
		soundMan.playIntroMusic();
	}

	/**
	 * Returns the game status
	 * @return the game status 
	 */
	public GameStatus getStatus() {
		return status;
	}

	public SoundManager getSoundMan() {
		return soundMan;
	}

	public GameScreen getGameScreen() {
		return gameScreen;
	}

	/**
	 * Prepare for a new game.
	 */
	public void newGame(){
		status.setGameStarting(true);
		soundMan.stopIntroMusic();
		soundMan.playDuringMusic();

		// init game variables
		bullets = new ArrayList<Bullet>();
		asteroids = new ArrayList<Asteroid>();

		status.setShipsLeft(3);
		status.setGameOver(false);
		status.setAsteroidsDestroyed(0);
		status.setNewAsteroid(false);
		status.setEnemyShipsDestroyed(0);
		status.setNewEnemyShip(false);
		status.setCurrentLevel(1);
		status.setAsteroidValue(5);
		status.setScorePoints(0);

		// init the ship and the asteroids
		newShip(gameScreen);
		newAsteroid(gameScreen);
		newEnemyShip(gameScreen);
		
		// start with 3 asteroids
		generateAsteroids(4);

		// prepare game screen
		gameScreen.doNewGame();

		// delay to display "Get Ready" message for 1.5 seconds
		Timer timer = new Timer(1500, new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				status.setGameStarting(false);
				status.setGameStarted(true);
			}
		});
		timer.setRepeats(false);
		timer.start();
	}

	/**
	 * Check game or level ending conditions.
	 */
	public void checkConditions(){
		// check game over conditions
		if(!status.isGameOver() && status.isGameStarted()){
			if(status.getShipsLeft() == 0){
				gameOver();
			}
		}
		// check level over conditions
		if(status.isLevelOver()){
			// update level
			status.updateCurrentLevel();
			generateAsteroids(1*(status.getCurrentLevel()-1));
		}
	}

	/**
	 * Actions to take when the game is over.
	 */
	public void gameOver(){
		status.setGameStarted(false);
		status.setGameOver(true);
		soundMan.stopDuringMusic();
		soundMan.playGameOverSound();
		gameScreen.doGameOver();

		// delay to display "Game Over" message for 3 seconds
		Timer timer = new Timer(3000, new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				status.setGameOver(false);
				soundMan.playIntroMusic();
			}
		});
		timer.setRepeats(false);
		timer.start();
	}

	/**
	 * Fire a bullet from ship.
	 */
	public void fireBullet(){
		Bullet bullet = new Bullet(ship);
		bullets.add(bullet);
		soundMan.playBulletSound();
	}

	/**
	 * Move a bullet once fired.
	 * @param bullet the bullet to move
	 * @return if the bullet should be removed from screen
	 */
	public boolean moveBullet(Bullet bullet){
		if(bullet.getY() - bullet.getSpeed() >= 0){
			bullet.translate(0, -bullet.getSpeed());
			return false;
		}
		else{
			return true;
		}
	}

	/**
	 * Create a new ship (and replace current one).
	 */
	public Ship newShip(GameScreen screen){
		this.ship = new Ship(screen);
		return ship;
	}

	/**
	 * Create a new asteroid.
	 */
	public Asteroid newAsteroid(GameScreen screen){
		this.asteroid = new Asteroid(screen);
		return asteroid;
	}

	/**
	 * Create a new enemy ship.
	 */
	public EnemyShip newEnemyShip(GameScreen screen){
		this.enemyShip = new EnemyShip(screen);
		return enemyShip;
	}

	/**
	 * Returns the ship.
	 * @return the ship
	 */
	public Ship getShip() {
		return ship;
	}

	/**
	 * Returns the asteroid.
	 * @return the asteroid
	 */
	public Asteroid getAsteroid() {
		return asteroid;
	}

	/**
	 * Returns the enemy ship.
	 * @return the enemy ship
	 */
	public EnemyShip getEnemyShip () {
		return enemyShip;
	}

	/**
	 * Returns the list of bullets.
	 * @return the list of bullets
	 */
	public List<Bullet> getBullets() {
		return bullets;
	}

	/**
	 * Returns the list of asteroids
	 * @return the list of asteroids
	 */
	public List<Asteroid> getAsteroids() {
		return asteroids;
	}

	/**
	 * Generates the asteroids and puts them in the list
	 * @param number of asteroids to generate
	 */
	public void generateAsteroids(int n){
		for(int i=0; i<n; i++){
			addAsteroid(gameScreen);
		}
	}

	/**
	 * Adds an asteroid to the screen and to the list
	 * @param screen
	 */
	public void addAsteroid(GameScreen screen){
		this.asteroid = newAsteroid(screen);
		asteroids.add(asteroid);
	}
}
