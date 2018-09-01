/**
 * 
 */
package com.blp.unicorn.objects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.blp.unicorn.core.coreObject;
import com.blp.unicorn.gfx.Texture;

/**
 * @author Jake
 *
 */
public class Block extends coreObject {
	
	private BufferedImage image;
	private int gravity = 1;
	private boolean falling = true;
	
	/**
	 * constructo class for a block
	 * @param x
	 * @param y
	 * @param id
	 * @param tex
	 * @param image
	 */
	public Block(int x, int y, int id, Texture tex, BufferedImage image){
		super(x, y, id, tex);
		this.image = image;
		this.setSize(16, 16);
	}

	@Override
	public void tick() {
		
	
		
	}


	@Override
	/**
	 * renders the block with texture
	 */
	public void render(Graphics g) {
		g.drawImage(image,  x,  y,  null);
	
		
	}
	
	

}
