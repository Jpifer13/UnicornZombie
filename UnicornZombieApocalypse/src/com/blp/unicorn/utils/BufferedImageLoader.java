/**
 * 
 */
package com.blp.unicorn.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * @author Jake
 *
 */
public class BufferedImageLoader {

	private BufferedImage image;
	
	/**
	 * loads image
	 * @param imagePath
	 * @return
	 * @throws IOException
	 */
	public BufferedImage loadImage(String imagePath) throws IOException{
		image = ImageIO.read(new File(imagePath));
		return image;
	}
	
}
