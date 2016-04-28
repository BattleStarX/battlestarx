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
	private boolean showFinalBoss;
	private boolean position;
	private boolean levelOver = false;//TODO
	private long asteroidsDestroyed = 0;
	private int shipsLeft;
	private int scorePoints = 0;
	private long enemyShipsDestroyed = 0;
	private boolean finalBossDestroyed = false;
	private int currentLevel = 1;//TODO
	
	// target variables
	private long asteroidToDestroyValue = 5;//TODO
	
	public GameStatus(){

	}
	//---------------------------------------------------------------------------------
	/**
	 * Indicates if the final boss is destroyed.
	 * @return if the final boss is destroyed or not
	 */
	public synchronized boolean isFinalBossDestroyed() {
		return finalBossDestroyed;
	}
	public synchronized void setFinalBossDestroyed(boolean finalBossDestroyed) {
		this.finalBossDestroyed = finalBossDestroyed;
	}
	//----------------------------------------------------------------------------------

	/**
	 * Indicates if the game has already started or not.
	 * @return if the game has already started or not
	 */
	public synchronized boolean isGameStarted() {
		return gameStarted;
	}

	public synchronized void setGameStarted(boolean gameStarted) {
		this.gameStarted = gameStarted;
	}

	/**
	 * Indicates if the game is starting ("Get Ready" message is displaying) or not.
	 * @return if the game is starting or not.
	 */
	public synchronized boolean isGameStarting() {
		return gameStarting;
	}

	public synchronized void setGameStarting(boolean gameStarting) {
		this.gameStarting = gameStarting;
	}

	/**
	 * Indicates if the game has ended and the "Game Over" message is displaying.
	 * @return if the game has ended and the "Game Over" message is displaying.
	 */
	public synchronized boolean isGameOver() {
		return gameOver;
	}

	public synchronized void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}
	//------------------------------------------------------------------------------------------
	/**
	 * Indicates if the game has ended and the "You Win" message is displaying.
	 * @return if the game has ended and the "You Win" message is displaying.
	 */
	public synchronized boolean isGameWin() {
		return gameWin;
	}

	public synchronized void setGameWin(boolean gameWin) {
		this.gameWin = gameWin;
	}
	//------------------------------------------------------------------------------------------

	/**
	 * Indicates if a new ship should be created/drawn.
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
	 * @return if a new enemy ship should be created/drawn
	 */
	public synchronized boolean isNewEnemyShip() {//TODO
		return newEnemyShip;
	}

	public synchronized void setNewEnemyShip(boolean newEnemyShip) {
		this.newEnemyShip = newEnemyShip;
	}

	/**
	 * Returns the number of enemy ship destroyed. 
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
	 * @return the number ships left
	 */
	public synchronized int getShipsLeft() {
		return shipsLeft;
	}

	public synchronized void setShipsLeft(int shipsLeft) {
		this.shipsLeft = shipsLeft;
	}

	public synchronized boolean isLevelOver(){//TODO
		//TODO other conditions
		if((this.getAsteroidsDestroyed() > 1) && (this.getAsteroidsDestroyed() == this.getAsteroidsValue())){
			levelOver = true;
		}
		return levelOver;
	}
	
	public synchronized void setLevelOver(boolean levelOver){//TODO
		this.levelOver = levelOver;
	}
	
	public synchronized int getCurrentLevel() {//TODO
		return currentLevel;
	}
	
	public synchronized void setCurrentLevel(int level){//TODO
		this.currentLevel = level;
	}
	
	public synchronized void updateCurrentLevel(){//TODO
		setCurrentLevel(this.getCurrentLevel() + 1);
		this.setLevelOver(false);
	}

	/**
	 * Returns the score points obtained.
	 * @return the score points
	 */
	public synchronized int getScorePoints() {
		return scorePoints;
	}

	/**
	 * Set score points
	 * @param scorePoints
	 */
	public synchronized void setScorePoints(int scorePoints) {
		this.scorePoints = scorePoints;
	}

	
	public void setAsteroidValue(long asteroidValue) {//TODO
		this.asteroidToDestroyValue = asteroidValue;
	}

	public long getAsteroidsValue() {//TODO
		return asteroidToDestroyValue;
	}
	
	//----------------------------------
	
	public synchronized boolean isNewFinalBoss() {
		return newFinalBoss;
	}

	public synchronized void setNewFinalBoss(boolean newFinalBoss) {
		this.newFinalBoss = newFinalBoss;
	}
	
	public synchronized boolean showFinalBoss() {
		return showFinalBoss;
	}

	public synchronized void setShowFinalBoss(boolean showFinalBoss) {
		this.showFinalBoss = showFinalBoss;
	}
	
	public void setGoRight(boolean position) {
		this.position = position;
	}
	public boolean goRight() {
		return position;	
	}
	//----------------------------------
	
	
	
	public void setLevelVariables() {//TODO
		switch(this.currentLevel){
			case 1:
				setAsteroidValue(5);
				break;
			case 2:
				setAsteroidValue(6);
				break;
			case 3:
				setAsteroidValue(7);
				break;
			default:
				setAsteroidValue(5);
				break;
		}
	}
}
