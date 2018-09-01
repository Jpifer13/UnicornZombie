/**
 * 
 */
package com.blp.unicorn.screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.blp.unicorn.Game;
import com.blp.unicorn.input.MouseInput;
import com.blp.unicorn.libs.Images;
import com.blp.unicorn.libs.Reference;
import com.blp.unicorn.utils.Button;

/**
 * @author Jake
 *
 */
public class Menu {

	
	/**
	 * creates buttons
	 */
	public Button play, options, quit;
//	private int centerX = Game.WIDTH / 2;
//	private static int cneterY = Game.HEIGHT / 2;
	
	/**
	 * creates menu with play, options, and quit buttons
	 */
	public Menu() {
		play = new Button(15, 850, 200, 50).setText("Play");
		options = new Button(215, 850, 200, 50).setText("Options");
		quit = new Button(415, 850, 200, 50).setText("Quit");
	}
	
	/**
	 * Draws the menu
	 * @param g
	 */
	public void render(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
		g.drawImage(Images.title, 0, 20, null);
		
		Font tempFont = new Font("Arial", Font.BOLD, 45);
		g.setFont(tempFont);
		
		play.drawButton(g, 55);
		options.drawButton(g, 15);
		quit.drawButton(g, 55);
		
		
	}

}
