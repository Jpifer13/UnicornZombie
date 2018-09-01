/**
 * 
 */
package com.blp.unicorn.core;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.blp.unicorn.gfx.Texture;

/**
 * @author Jake
 *
 */
public abstract class coreObject {
	
	protected int x, y;
	protected double velX, velY;
	protected int id;
	protected int width;
	protected int height;
	protected Texture tex;
	
	
	/**
	 * creates an object with certain size and texture
	 * used for blocks
	 * @param x
	 * @param y
	 * @param id
	 */
	public coreObject(int x, int y, int id, Texture tex){
		this.x = x;
		this.y = y;
		this.id = id;
		this.tex = tex;
		width = 32;
		height = 32;
	}
	/**
	 * creates object with input size and texture
	 * used for player
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param id
	 * @param tex
	 */
	public coreObject(int x, int y,int width, int height, int id, Texture tex){
		this.x = x;
		this.y = y;
		this.id = id;
		this.tex = tex;
		this.width = width;
		this.height = height;
	}
	
	
	
	public abstract void tick();
	public abstract void render(Graphics g);
	/**
	 * gets the top bounds of rectangle object
	 * @return rectangle top bound
	 */
	public Rectangle getTopBounds(){
		return new Rectangle(x, y, width, 12);
	}
	/**
	 * gets bottom bounds of rectangle object
	 * @return rectangle bottom bound
	 */
	public Rectangle getBottomBounds(){
		return new Rectangle(x, y + (height - 6), 30, 12);
	}
	/**
	 * gets rectangle object right bound
	 * @return rectangles right bound
	 */
	public Rectangle getRightBounds(){
		return new Rectangle(x + (width - 6), y, 6, height);
	}
	/**
	 * gets rectangle ojects left bounds
	 * @return rectangles left bound
	 */
	public Rectangle getLeftBounds(){
		return new Rectangle(x, y, 6, height);
	}
	

	/**
	 * gets the x value
	 * @return the x coord
	 */
	public int getX() {
		return x;
	}

	/**
	 * sets x value
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * gets y value
	 * @return the y coord
	 */
	public int getY() {
		return y;
	}

	/**
	 * sets the y calue
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * gets id of boject
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * sets x velocity
	 * @param velX the velX to set
	 */
	public void setVelX(double velX) {
		this.velX = velX;
	}

	/**
	 * sets y velovity
	 * @param velY the velY to set
	 */
	public void setVelY(double velY) {
		this.velY = velY;
	}

	/**
	 * gets width of object
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * sets width of object
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * gets height of object
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * sets height of object
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	/**
	 * sets height and width of object
	 * @param width
	 * @param height
	 */
	public void setSize(int width, int height){
		this.width = width;
		this.height = height;
	}
		
	

}
