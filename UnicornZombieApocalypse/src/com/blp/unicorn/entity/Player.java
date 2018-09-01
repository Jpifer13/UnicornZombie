/**
 * 
 */
package com.blp.unicorn.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import com.blp.unicorn.Game;
import com.blp.unicorn.core.Controller;
import com.blp.unicorn.core.coreObject;
import com.blp.unicorn.enums.GameState;
import com.blp.unicorn.gfx.Texture;
import com.blp.unicorn.input.HSWriter;
import com.blp.unicorn.libs.Identities;
import com.blp.unicorn.objects.Block;
import com.blp.unicorn.objects.movingBlock;

/**
 * @author Jake
 *
 */
public class Player extends coreObject{
	
	private  static ArrayList<coreObject> blocks = Controller.getObjects();
	private  static ArrayList<coreObject> mblocks = Controller.getObjects();
	private movingBlock mblock;
	
	private Block block;
	public int life = 3;
	private int gravity = 1;
	private boolean falling = true;
	private boolean jumping = false;
	public static String endScore;
	
	/**
	 * player constructor class
	 * @param x
	 * @param y
	 * @param id
	 * @param tex
	 */
	public Player(int x, int y, int id, Texture tex) {
		super(x, y, id, tex);
		this.setSize(32,  50);
		
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
		
		fall();
		checkCollision();
		// TODO Auto-generated method stub
		
	}

	@Override
	/**
	 * renders graphics of playert
	 */
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(x,  y,  width,  height);
		// TODO Auto-generated method stub
		
	}
	/**
	 * checks collision between player and ground
	 */
	private void checkCollision(){
		
		for(coreObject obj: blocks){
			if(obj.getId() == Identities.BLOCK_METAL){
				block = (Block) obj;
				if(getBottomBounds().intersects(block.getTopBounds())){
					velY = 0;
					y = block.getY() - height;
					jumping = false;
					//Game.changeLoseStatus();
				}
				if(getTopBounds().intersects(block.getBottomBounds())){
					fall();
					y = block.getY() + block.getHeight();
				}
				if(getRightBounds().intersects(block.getLeftBounds())){
					velX= 0;
					x = block.getX() - width;
				}
				if(getLeftBounds().intersects(block.getRightBounds())){
					velX = 0;
					x = block.getX() + block.getWidth();
				}
				
				
			}
		}
		/**
		 * checks collision between player and win block
		 */
		for(coreObject obj: blocks){
			if(obj.getId() == Identities.BLOCK_STONE){
				block = (Block) obj;
				if(getBottomBounds().intersects(block.getTopBounds())){
					//velY = 0;
					//y = block.getY() - height;
					//jumping = false;
					//Game.changeLoseStatus();
					Game.state = GameState.HIGHSCORES;
					endScore = Integer.toString(Game.score);
					try {
						HSWriter.fileWriter(Game.score);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
					
				if(getTopBounds().intersects(block.getBottomBounds())){
					//fall();
					//y = block.getY() + block.getHeight();
					Game.state = GameState.HIGHSCORES;
					endScore = Integer.toString(Game.score);
				}
				if(getRightBounds().intersects(block.getLeftBounds())){
					//velX= 0;
					//x = block.getX() - width;
					Game.state = GameState.HIGHSCORES;
					endScore = Integer.toString(Game.score);
				}
				if(getLeftBounds().intersects(block.getRightBounds())){
					//velX = 0;
					//x = block.getX() + block.getWidth();
					Game.state = GameState.HIGHSCORES;
					endScore = Integer.toString(Game.score);
					
				}
				
				
			}
		}
		/**
		 * checks collision between player and moving blocks
		 */
		for(coreObject obj: mblocks){
			if(obj.getId() == Identities.MOVING_BLOCK){
				mblock = (movingBlock) obj;
				if(getBottomBounds().intersects(mblock.getTopBounds())){
					velY = 0;
					y = mblock.getY() - height;
					jumping = false;
					
					
				}
				if(getTopBounds().intersects(mblock.getBottomBounds())){
					fall();
					y = mblock.getY() + mblock.getHeight();
				}
				if(getRightBounds().intersects(mblock.getLeftBounds())){
					velX= 0;
					x = mblock.getX() - width;
					
				}
				if(getLeftBounds().intersects(mblock.getRightBounds())){
					velX = 0;
					x = mblock.getX() + mblock.getWidth();
					
				}
				}
		}
		
			}
		
		
	
	/**
	 * creates gravity so the player falls after jumping
	 */
	public void fall(){
		if(falling)
		velY += gravity;
	}
	
	

	/**
	 * checks if player is jumping
	 * @return true if jumping
	 */
	public boolean isJumping() {
		return jumping;
	}

	/**
	 * sets jumping
	 * @param  boolean to set jumping state
	 */
	public void setJumping(boolean jumping) {
		this.jumping = jumping;
	}
	
	

}
