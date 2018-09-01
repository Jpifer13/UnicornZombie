/**
 * 
 */
package com.blp.unicorn.screens;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import com.blp.unicorn.Game;
import com.blp.unicorn.core.Controller;
import com.blp.unicorn.enums.GameState;
import com.blp.unicorn.gfx.Renderer;
import com.blp.unicorn.input.MouseInput;
import com.blp.unicorn.libs.Images;
import com.blp.unicorn.utils.Button;

/**
 * @author Jake
 *
 */
public class Options{
	
	/**
	 * creates buttons
	 */
	public Button highscores, quit;
	
	/**
	 * constructor class for options frame
	 */
	public Options(){
		//gfx = new Renderer();
		highscores = new Button(175, 750, 250, 50).setText("Highscores");
		//quit = new Button(215, 850, 200, 50).setText("Quit");
	
	}
	
	
	/**
	 * Draws the options frame
	 * @param g
	 */
	public void render(Graphics g){
		
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
		g.drawImage(Images.title, 0, 20, null);
		
		Font tempFont = new Font("Arial", Font.BOLD, 45);
		g.setFont(tempFont);
		
		highscores.drawButton(g, 2);
	
	
		
		
		
		
		
	}

}
