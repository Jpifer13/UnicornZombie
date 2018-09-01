/**
 * 
 */
package com.blp.unicorn.utils;

import java.io.IOException;




import com.blp.unicorn.libs.Audio;
import com.blp.unicorn.libs.Images;
import com.blp.unicorn.libs.Reference;

/**
 * @author Jake
 *
 */
public class ResourceLoader {

	private static BufferedImageLoader imageLoader = new BufferedImageLoader();
	
	/*
	 * loads all images and sprites
	 */
	public static void loadImages(){
		
		try{
			Images.title = imageLoader.loadImage(Reference.SPRITE_LOCATION + "UnicornTitle.png");
			Images.spritesheetTest = imageLoader.loadImage(Reference.SPRITE_LOCATION + "textures.png");
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
	//public static void loadSounds(){
		//AudioPlayer.addSound(Audio.SOUND_LASER, "laser");
		//AudioPlayer.addMusic(Audio.MUSIC_BORGORE, "UnicornZombie.ogg");
	
	
}
