package rbadia.voidspace.sounds;

import java.applet.Applet;
import java.applet.AudioClip;

import rbadia.voidspace.main.GameScreen;

/**
 * Manages and plays the game's sounds.
 */
public class SoundManager {
	private static final boolean SOUND_ON = true;

	private AudioClip shipExplosionSound = Applet.newAudioClip(GameScreen.class.getResource(
			"/rbadia/voidspace/sounds/shipExplosion.wav"));
	private AudioClip bulletSound = Applet.newAudioClip(GameScreen.class.getResource(
			"/rbadia/voidspace/sounds/laser.wav"));
	private AudioClip introMusic = Applet.newAudioClip(GameScreen.class.getResource(
			"/rbadia/voidspace/sounds/LoLArcade.wav"));
	private AudioClip duringMusic = Applet.newAudioClip(GameScreen.class.getResource(
			"/rbadia/voidspace/sounds/duringPlayX.wav"));
	private AudioClip gameOver = Applet.newAudioClip(GameScreen.class.getResource(
			"/rbadia/voidspace/sounds/gameOver.wav"));
	private AudioClip bossBulletSound = Applet.newAudioClip(GameScreen.class.getResource(
			"/rbadia/voidspace/sounds/bossShotSound.wav"));
	private AudioClip victorySound = Applet.newAudioClip(GameScreen.class.getResource(
			"/rbadia/voidspace/sounds/victorySound.wav"));
	private AudioClip tensionMusic = Applet.newAudioClip(GameScreen.class.getResource(
			"/rbadia/voidspace/sounds/tensionMusic.wav"));

	
	
	/**
	 * Plays sound for victory.
	 */
	public void playVictorySound(){
		if(SOUND_ON){
			new Thread(new Runnable(){
				public void run() {
					victorySound.play();
				}
			}).start();
		}
	}
	/**
	 * Stops sound for victory.
	 */
	public void stopVictorySound(){
		if(SOUND_ON){
			new Thread(new Runnable(){
				public void run() {
					victorySound.stop();
				}
			}).start();
		}
	}
	/**
	 * Plays sound for Tension.
	 */
	public void playTensionMusic(){
		if(SOUND_ON){
			new Thread(new Runnable(){
				public void run() {
					tensionMusic.play();
				}
			}).start();
		}
	}
	/**
	 * Stops sound for Tension.
	 */
	public void stopTensionMusic(){
		if(SOUND_ON){
			new Thread(new Runnable(){
				public void run() {
					tensionMusic.stop();
				}
			}).start();
		}
	}
	
	
	
	
	
	/**
	 * Plays sound for bullets fired by the ship.
	 */
	public void playBulletSound(){
		if(SOUND_ON){
			new Thread(new Runnable(){
				public void run() {
					bulletSound.play();
				}
			}).start();
		}
	}

	/**
	 * Plays sound for boss bullets fired by the final boss.
	 */
	public void playBossBulletSound(){
		if(SOUND_ON){
			new Thread(new Runnable(){
				public void run() {
					bossBulletSound.play();
				}
			}).start();
		}
	}
	/**
	 * Stops sound for boss bullets fired by the final boss.
	 */
	public void stopBossBulletSound(){
		if(SOUND_ON){
			new Thread(new Runnable(){
				public void run() {
					bossBulletSound.stop();
				}
			}).start();
		}
	}
	/**
	 * Plays sound for ship explosions.
	 */
	public void playShipExplosionSound(){
		if(SOUND_ON){
			new Thread(new Runnable(){
				public void run() {
					shipExplosionSound.play();
				}
			}).start();
		}
	}

	/**
	 * Plays sound for asteroid explosions.
	 */
	public void playAsteroidExplosionSound(){
		// play sound for asteroid explosions
		if(SOUND_ON){
			new Thread(new Runnable(){
				public void run() {
					shipExplosionSound.play();
				}
			}).start();
		}
	}


	public void playIntroMusic(){
		if(SOUND_ON){
			new Thread(new Runnable(){
				public void run() {
					introMusic.play();
				}
			}).start();

		}
	}
	public void stopIntroMusic(){
		if(SOUND_ON){
			new Thread(new Runnable(){
				public void run() {
					introMusic.stop();
				}
			}).start();

		}
	}


	public void playDuringMusic(){
		if(SOUND_ON){
			new Thread(new Runnable(){
				public void run() {
					duringMusic.play();
				}
			}).start();

		}
	}
	public void stopDuringMusic(){
		if(SOUND_ON){
			new Thread(new Runnable(){
				public void run() {
					duringMusic.stop();
				}
			}).start();
		}
	}

	public void playGameOverSound(){
		if(SOUND_ON){
			new Thread(new Runnable(){
				public void run() {
					gameOver.play();
				}
			}).start();

		}
	}


}
