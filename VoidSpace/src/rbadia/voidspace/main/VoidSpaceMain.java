/**
 * By:
 * 
 * Albert Morales
 * Roberto Madera
 * 
 * ICOM 4015 030
 * Project 2
 * 
 */

 /** 
 * Music credits:
 * 
 * Login music 	- https://www.youtube.com/watch?v=t32HdcQk78Y
 * Game music 	- https://www.youtube.com/watch?v=hylhcwEU22U
 * Boss music 	- https://www.youtube.com/watch?v=Mso4q1hLx10
 * 
 */

package rbadia.voidspace.main;

import javax.swing.JFrame;

/**
 * Main game class. Starts the game.
 */
public class VoidSpaceMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// init main frame
		MainFrame frame = new MainFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// get game screen
        GameScreen gameScreen = frame.getGameScreen();
		
		// init game logic handler
		GameLogic gameLogic = new GameLogic(gameScreen);
		
		// pass some variables to game screen
        gameScreen.setGameLogic(gameLogic);
        
		// init input handler
        InputHandler inputHandler = new InputHandler(gameLogic);
        frame.addKeyListener(inputHandler);
        
        // show main frame
		frame.setVisible(true);
		
		// init main game loop
		new Thread(new GameLoop(gameScreen, gameLogic, inputHandler)).start();
	}


}
