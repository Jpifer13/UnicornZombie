/**
 * 
 */
package com.blp.unicorn.utils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import com.blp.unicorn.input.MouseInput;

/**
 * @author Jake
 *
 */
@SuppressWarnings("serial")
public class Button extends Rectangle {
	
	private String text;

	/**
	 * creates different buttons
	 */
	public Button() {
		super();
	}

	/**
	 * @param r
	 */
	public Button(Rectangle r) {
		super(r);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param p
	 */
	public Button(Point p) {
		super(p);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param d
	 */
	public Button(Dimension d) {
		super(d);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param width
	 * @param height
	 */
	public Button(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param p
	 * @param d
	 */
	public Button(Point p, Dimension d) {
		super(p, d);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public Button(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * sets button text
	 * @param text
	 * @return
	 */
	public Button setText(String text){
		this.text = text;
		return this;
	}
	
	/**
	 * draws a button that is white when mouse isnt colliding and red when mouse is on button
	 * @param g
	 * @param offset
	 */
	public void drawButton(Graphics g, int offset){
		int xx = x + offset;
		int yy = y + 38;
		if(MouseInput.MOUSE.intersects(this)){
			g.setColor(Color.RED);
		}else
			g.setColor(Color.WHITE);
		
		/*if(!MouseInput.pressed && MouseInput.MOUSE.intersects(this))
				g.drawRect(x, y, width, height);
		else if(MouseInput.pressed && MouseInput.MOUSE.intersects(this))
			g.fillRect(xx,  y,  width,  height);
		else
			g.drawRect(x,  y,  width,  height);
		*/
		g.drawRect(x,  y,  width,  height);
		g.setColor(Color.RED);
		g.drawString(text,  xx,  yy);
		
	}

}
