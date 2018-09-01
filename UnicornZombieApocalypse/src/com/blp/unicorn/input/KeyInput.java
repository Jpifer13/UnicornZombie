/**
 * 
 */
package com.blp.unicorn.input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.blp.unicorn.Game;
import com.blp.unicorn.core.Controller;
import com.blp.unicorn.core.coreObject;
import com.blp.unicorn.entity.Player;
import com.blp.unicorn.libs.Identities;

/**
 * @author Jake
 *
 */
public class KeyInput extends KeyAdapter{
	
	private Player player;
	
	private boolean[] keyDown = new boolean[2];
	
	/**
	 * contructor class
	 */
	public KeyInput(){
		for(int k = 0; k < Controller.getObjects().size(); k++){
			if(Controller.getObjects().get(k).getId() == Identities.PLAYER)
				player = (Player) Controller.getObjects().get(k);
				
		}
	}
	
	/**
	 * checks if key is pressed
	 */
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		switch(Game.state){
		case GAME:
			if(key == KeyEvent.VK_W && !player.isJumping()){
			//	player.setVelY(-5);
				player.setVelY(-20);
				player.setJumping(true);}
			
			//if(key == KeyEvent.VK_S)
			//	player.setVelY(5);
			if(key == KeyEvent.VK_A){
				player.setVelX(-5);
				keyDown[0] = true;
			}
			if(key == KeyEvent.VK_D){
				player.setVelX(5);
				keyDown[1] = true;
			}
			break;
		case MENU:
			break;
		case OPTIONS:
			break;
		case PAUSE:
			break;
		default:
			break;
		
		}
	}
	
	/**
	 * checks if key is released
	 */
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		
		switch(Game.state){
		case GAME:
			if(key == KeyEvent.VK_W)
				player.setVelY(0);
			//if(key == KeyEvent.VK_S)
			//	player.setVelY(0);
			if(key == KeyEvent.VK_A)
				keyDown[0] = false;
			if(key == KeyEvent.VK_D)
				keyDown[1] = false;
			
			if(keyDown[0] && !keyDown[1])
				player.setVelX(-5);
			if(!keyDown[0] && keyDown[1])
				player.setVelX(5);
			if(!keyDown[0] && !keyDown[1])
				player.setVelX(0);
			break;
		case MENU:
			break;
		case OPTIONS:
			break;
		case PAUSE:
			break;
		default:
			break;
		
		}
	}

}
