/**
 * 
 */
package com.blp.unicorn.gfx;

import java.awt.image.BufferedImage;

import com.blp.unicorn.libs.Images;
import com.blp.unicorn.utils.SpriteSheet;

/**
 * @author Jake
 *
 */
public class Texture {
	
	private SpriteSheet sheetTest;
	
	/*
	 * Game object images
	 */
	public BufferedImage blockMetal;
	public BufferedImage blockStone;
	public BufferedImage blockDeath;
	
	
	/**
	 * loads the spritesheet to select texture of object
	 */
	public Texture(){
		sheetTest = new SpriteSheet(Images.spritesheetTest, 16);
		
		initTextures();
	}
	
	/**
	 * sets the texture of various objects
	 */
	private void initTextures(){
		blockStone = sheetTest.getSprite(9, 2);
		blockMetal = sheetTest.getSprite(4, 1);
		blockDeath = sheetTest.getSprite(6,  3);
	}

}
