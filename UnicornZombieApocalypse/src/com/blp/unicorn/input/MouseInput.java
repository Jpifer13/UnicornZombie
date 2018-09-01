/**
 * 
 */
package com.blp.unicorn.input;

import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.blp.unicorn.Game;
import com.blp.unicorn.enums.GameState;
import com.blp.unicorn.screens.Menu;

/**
 * @author Jake
 *
 */
public class MouseInput extends MouseAdapter {
	/**
	 * if mouse button is pressed then true
	 */
	public static boolean pressed = false;
	/**
	 * x and y coordinates of your mouse
	 */
	public static int MOUSE_X, MOUSE_Y;
	/**
	 * check for intersection in other classes
	 */
	public static Rectangle MOUSE = new Rectangle(1, 1, 1, 1);
	
	
	private Menu menu = Game.getInstance().getMenu();
	
	@Override
	/**
	 * called when mouse button is clicked
	 */
	public void mouseClicked(MouseEvent e) {
		int mouse = e.getButton();
		Rectangle rect = new Rectangle(e.getX(), e.getY(), 1, 1);
		pressed = true;
		
		if(mouse == MouseEvent.BUTTON1){
			
			switch(Game.state){
			case GAME:
				break;
			case MENU:
				if(rect.intersects(menu.play)){
					//AudioPlayer.playSound(Audio.SOUND_LASER);
					Game.state = GameState.GAME;
				}
				else if(rect.intersects(menu.options)){
					Game.state = GameState.OPTIONS;
				}
				else if(rect.intersects(Game.getInstance().menu.quit))
					System.exit(1);
				break;
			case OPTIONS:
				if(rect.intersects(Game.getInstance().options.highscores)){
					Game.state = GameState.HIGHSCORES;
					
				}
				//else if(rect.intersects(Game.getInstance().options.quit))
				//	System.exit(1);
				break;
			case HIGHSCORES:
				if(rect.intersects(Game.getInstance().highscores.quit)){
					System.exit(1);
				}
				break;
			case PAUSE:
				break;
			default:
				break;
			
			}
		}
	}
	
	@Override
	/**
	 * called if mouse if pressed
	 */
	public void mousePressed(MouseEvent e) {
		pressed = true;
		super.mousePressed(e);
	}
	
	@Override
	/**
	 * called if mouse is released
	 */
	public void mouseReleased(MouseEvent e){
		
		pressed = false;
	}
	
	@Override
	/**
	 * gets coordinates of mouse when moved
	 */
	public void mouseMoved(MouseEvent e) {
		MOUSE_X = e.getX();
		MOUSE_Y = e.getY();
		MOUSE = new Rectangle(MOUSE_X, MOUSE_Y, 1, 1);
		
		
	}

}
