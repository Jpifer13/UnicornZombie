/**
 * 
 */
package com.blp.unicorn.objects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import com.blp.unicorn.core.Controller;
import com.blp.unicorn.core.coreObject;
import com.blp.unicorn.entity.Player;
import com.blp.unicorn.gfx.Texture;
import com.blp.unicorn.libs.Identities;

/**
 * @author Jake
 *
 */
public class movingBlock extends coreObject{
	private BufferedImage image;
	private double gravity = 0.05;
	private boolean falling = true;
	private  static ArrayList<coreObject> players = Controller.getObjects();
	private Player player;
	private  static ArrayList<coreObject> mblocks = Controller.getObjects();
	private movingBlock mblock;
	private boolean collides = true;
	
	/**
	 * constructor class for moving blocks
	 * @param x
	 * @param y
	 * @param id
	 * @param tex
	 * @param image
	 */
	public movingBlock(int x, int y, int id, Texture tex, BufferedImage image){
		super(x, y, id, tex);
		this.image = image;
		this.setSize(16, 16);
		
	}

	@Override
	/**
	 * each tick checks if moving block is colliding with anything
	 * moves block right while increasing velocity each tick
	 * 
	 */
	public void tick() {
		if(collides){
		x += velX;
		fallRight();
		}
		checkCollision();
	
		
	}
	
	/**
	 * checks collision between moving block and player
	 */
	public void checkCollision(){
		for(coreObject obj: players){
			if(obj.getId() == Identities.PLAYER){
				player = (Player) obj;
				if(getBottomBounds().intersects(player.getTopBounds())){
					//velY = 0;
					//y = mblock.getY() - height;
					
				}
				if(getTopBounds().intersects(player.getBottomBounds())){
					velX= 0;
					
					collides = false;
				}
				if(getRightBounds().intersects(player.getLeftBounds())){
					velX= 0;
					x = player.getX() - width;
					collides = false;
				}
				if(getLeftBounds().intersects(player.getRightBounds())){
					velX = 0;
					x = player.getX() + player.getWidth();
					collides = false;
				}
				}
		}
		
	}
	
	/**
	 * creates gravity to make block fall left
	 */
	public void fallLeft(){
		if(falling)
		velX -= gravity;
	}
	
	/**
	 * creates gravity to make block fall right
	 */
	public void fallRight(){
		if(falling)
			velX += gravity;
	}

	@Override
	/**
	 * renders block with texture
	 */
	public void render(Graphics g) {
		g.drawImage(image,  x,  y,  null);
	
		
	}
	
	

}