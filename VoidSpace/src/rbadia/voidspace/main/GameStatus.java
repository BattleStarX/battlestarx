package rbadia.voidspace.main;

/**
 * Container for game flags and/or status variables.
 */
public class GameStatus {
	// game flags
	private boolean gameStarted = false;
	private boolean gameStarting = false;
	private boolean gameOver = false;
	private boolean gameWin = false;

	// status variables
	private boolean newShip;
	private boolean newAsteroid;
	private boolean newEnemyShip;
	private boolean newFinalBoss;
	private boolean position;
	private boolean levelOver = false;
	private long asteroidsDestroyed = 0;
	private int shipsLeft;
	private int bossLife;
	private int scorePoints = 0;
	private long enemyShipsDestroyed = 0;
	private int currentLevel = 1;

	// target variables
	private long asteroidToDestroyValue = 5;

	public GameStatus() {

	}

	/**
	 * Indicates if the game has already started or not.
	 * 
	 * @return if the game has already started or not
	 */
	public synchronized boolean isGameStarted() {
		return gameStarted;
	}

	public synchronized void setGameStarted(boolean gameStarted) {
		this.gameStarted = gameStarted;
	}

	/**
	 * Indicates if the game is starting ("Get Ready" message is displaying) or
	 * not.
	 * 
	 * @return if the game is starting or not.
	 */
	public synchronized boolean isGameStarting() {
		return gameStarting;
	}

	public synchronized void setGameStarting(boolean gameStarting) {
		this.gameStarting = gameStarting;
	}

	/**
	 * Indicates if the game has ended and the "Game Over" message is
	 * displaying.
	 * 
	 * @return if the game has ended and the "Game Over" message is displaying.
	 */
	public synchronized boolean isGameOver() {
		return gameOver;
	}

	public synchronized void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}

	/**
	 * Indicates if the game has ended and the "You Win" message is displaying.
	 * 
	 * @return if the game has ended and the "You Win" message is displaying.
	 */
	public synchronized boolean isGameWin() {
		return gameWin;
	}

	public synchronized void setGameWin(boolean gameWin) {
		this.gameWin = gameWin;
	}

	/**
	 * Returns the number of boss life.
	 * 
	 * @return the number of boss life
	 */
	public synchronized int getBossLife() {
		return bossLife;
	}

	public synchronized void setBossLife(int bossLife) {
		this.bossLife = bossLife;
	}

	/**
	 * Indicates if a new ship should be created/drawn.
	 * 
	 * @return if a new ship should be created/drawn
	 */
	public synchronized boolean isNewShip() {
		return newShip;
	}

	public synchronized void setNewShip(boolean newShip) {
		this.newShip = newShip;
	}

	/**
	 * Indicates if a new asteroid should be created/drawn.
	 * 
	 * @return if a new asteroid should be created/drawn
	 */
	public synchronized boolean isNewAsteroid() {
		return newAsteroid;
	}

	public synchronized void setNewAsteroid(boolean newAsteroid) {
		this.newAsteroid = newAsteroid;
	}

	/**
	 * Returns the number of asteroid destroyed.
	 * 
	 * @return the number of asteroid destroyed
	 */
	public synchronized long getAsteroidsDestroyed() {
		return asteroidsDestroyed;
	}

	public synchronized void setAsteroidsDestroyed(long asteroidsDestroyed) {
		this.asteroidsDestroyed = asteroidsDestroyed;
	}

	/**
	 * Indicates if a new enemy ship should be created/drawn.
	 * 
	 * @return if a new enemy ship should be created/drawn
	 */
	public synchronized boolean isNewEnemyShip() {
		return newEnemyShip;
	}

	public synchronized void setNewEnemyShip(boolean newEnemyShip) {
		this.newEnemyShip = newEnemyShip;
	}

	/**
	 * Returns the number of enemy ship destroyed.
	 * 
	 * @return the number of enemy ship destroyed
	 */
	public synchronized long getEnemyShipsDestroyed() {
		return enemyShipsDestroyed;
	}

	public synchronized void setEnemyShipsDestroyed(long enemyShipsDestroyed) {
		this.enemyShipsDestroyed = enemyShipsDestroyed;
	}

	/**
	 * Returns the number ships/lives left.
	 * 
	 * @return the number ships left
	 */
	public synchronized int getShipsLeft() {
		return shipsLeft;
	}

	public synchronized void setShipsLeft(int shipsLeft) {
		this.shipsLeft = shipsLeft;
	}

	/**
	 * Indicates if the level is over
	 * 
	 * @return if the level is over
	 */
	public synchronized boolean isLevelOver() {
		// check conditions
		if ((this.getAsteroidsDestroyed() > 1) && (this.getAsteroidsDestroyed() == this.getAsteroidsValue())
			 && !(this.getCurrentLevel()==9)) {
			levelOver = true;
		}
		return levelOver;
	}

	public synchronized void setLevelOver(boolean levelOver) {
		this.levelOver = levelOver;
	}

	public synchronized int getCurrentLevel() {
		return currentLevel;
	}

	public synchronized void setCurrentLevel(int level) {
		this.currentLevel = level;
	}

	/**
	 * Increases the level and sets new goals
	 */
	public synchronized void updateCurrentLevel() {
		setCurrentLevel(this.getCurrentLevel() + 1);
		setShipsLeft(this.getShipsLeft() + 1);
		setAsteroidValue(this.getAsteroidsValue() + 5*this.getCurrentLevel());
		this.setLevelOver(false);
	}

	/**
	 * Returns the score points obtained.
	 * 
	 * @return the score points
	 */
	public synchronized int getScorePoints() {
		return scorePoints;
	}

	/**
	 * Set score points
	 * 
	 * @param scorePoints
	 */
	public synchronized void setScorePoints(int scorePoints) {
		this.scorePoints = scorePoints;
	}

	public void setAsteroidValue(long asteroidValue) {
		this.asteroidToDestroyValue = asteroidValue;
	}

	public long getAsteroidsValue() {
		return asteroidToDestroyValue;
	}

	public synchronized boolean isNewFinalBoss() {
		return newFinalBoss;
	}

	public synchronized void setNewFinalBoss(boolean newFinalBoss) {
		this.newFinalBoss = newFinalBoss;
	}

	public void setGoRight(boolean position) {
		this.position = position;
	}

	public boolean goRight() {
		return position;
	}
}
