/**
 * 
 */
package com.blp.unicorn.screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.blp.unicorn.Game;
import com.blp.unicorn.entity.Player;
import com.blp.unicorn.libs.Images;
import com.blp.unicorn.utils.Button;

/**
 * @author Jake
 *
 */
public class HighScores {
	
	/**
	 * creates buttons
	 */
public Button quit, score, prevhigh;
	
	/**
	 * construcotr class for highscore screen
	 */
	public HighScores(){
		
		
		
		quit = new Button(175, 750, 250, 50).setText("Quit");
		
		
		
	
	}
	
	
	/**
	 * Draws the buttons and highscore and title image for highscore screen
	 * @param g
	 */
	public void render(Graphics g){
		
		score = new Button(175, 650, 250, 50).setText(Player.endScore);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
		g.drawImage(Images.title, 0, 20, null);
		
		Font tempFont = new Font("Arial", Font.BOLD, 45);
		g.setFont(tempFont);
		
		
		quit.drawButton(g, 2);
		
		score.drawButton(g, 75);
		
	
	
		
		
		
		
		
	}

}
