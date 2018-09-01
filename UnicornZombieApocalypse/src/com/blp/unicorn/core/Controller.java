/**
 * 
 */
package com.blp.unicorn.core;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 * @author Jake
 *
 */
public class Controller {
	
	private static ArrayList<coreObject> objects = new ArrayList<coreObject>();
	
	/**
	 * ticks through objects
	 */
	public void tick(){
		for(coreObject obj : objects){
			obj.tick();
		}
	}
	/**
	 * reders graphics using controller
	 * @param g
	 */
	public void render(Graphics g){
		for(coreObject obj : objects){
			obj.render(g);
		}
	}
	/**
	 * adds object 
	 * @param instance
	 */
	public static void addObject(coreObject instance){
		objects.add(instance);
	}
	/**
	 * removes object
	 * @param instance
	 */
	public static void removeObject(coreObject instance){
		objects.remove(instance);
	}
	/**
	 * creates an arraylist of objects
	 * @return
	 */
	public static ArrayList<coreObject> getObjects(){
		return objects;
	}

}
