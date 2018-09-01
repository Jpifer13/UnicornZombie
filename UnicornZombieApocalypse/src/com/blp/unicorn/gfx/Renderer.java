/**
 * 
 */
package com.blp.unicorn.gfx;

import java.awt.Color;
import java.awt.Graphics;

import com.blp.unicorn.Game;
import com.blp.unicorn.screens.Options;



/**
 * @author Jake
 *
 */
public class Renderer {
	

	
	/**
	 * renders the background
	 * @param g
	 */
	public void renderBackground(Graphics g){
		switch(Game.state){
		case GAME:
			break;
		case MENU:
			Game.getInstance().menu.render(g);;
			break;
		case OPTIONS:
			break;
		case HIGHSCORES:
			break;
		case PAUSE:
			break;
		default:
			g.setColor(Color.RED);
			g.drawString("UNKNOWN GAMESTATE", 150, 150);
			break;
		
		}
		
	}
	/**
	 * renders the foreground
	 * @param g
	 */
	public void renderForeground(Graphics g){
		switch(Game.state){
		case GAME:
			Game.getInstance().getController().render(g);
			break;
		case MENU:
			break;
		case OPTIONS:
			Game.getInstance().options.render(g);
			break;
		case HIGHSCORES:
			Game.getInstance().highscores.render(g);
			break;
		case PAUSE:
			break;
		default:
			break;
		
		}
	}

}
