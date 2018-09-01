/**
 * 
 */
package com.blp.unicorn.utils;

import java.awt.image.BufferedImage;

/**
 * @author Jake
 *
 */
public class SpriteSheet {
	
	private BufferedImage image;
	private int width;
	private int height;
	
	/**
	 * gets dimensions of spritesheet
	 * @param image
	 * @param width
	 */
	public SpriteSheet(BufferedImage image, int width){
		this.image = image;
		this.width = width;
		this.height = width;
	}
	
	/**
	 * gets dimensions of spritesheet
	 * @param image
	 * @param width
	 * @param height
	 */
	public SpriteSheet(BufferedImage image, int width, int height){
		this.image = image;
		this.width = width;
		this.height = height;
	}
	
	/**
	 * gets specific texture based on height and width coordinate
	 * @param col
	 * @param row
	 * @return
	 */
	public BufferedImage getSprite(int col, int row){
		
		return image.getSubimage((col * width) - width, (row * height) - height, width, height);
	}

}
