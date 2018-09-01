/**
 * 
 */
package com.blp.unicorn;

import java.awt.Canvas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.io.FileNotFoundException;
import java.util.Random;

import javax.swing.JFrame;

import com.blp.unicorn.core.Controller;
import com.blp.unicorn.entity.Player;
import com.blp.unicorn.enums.GameState;
import com.blp.unicorn.gfx.Renderer;
import com.blp.unicorn.gfx.Texture;
import com.blp.unicorn.input.KeyInput;
import com.blp.unicorn.input.MouseInput;
import com.blp.unicorn.libs.Identities;
import com.blp.unicorn.libs.Reference;
import com.blp.unicorn.objects.Block;
import com.blp.unicorn.objects.movingBlock;
import com.blp.unicorn.screens.HighScores;
import com.blp.unicorn.screens.Menu;
import com.blp.unicorn.screens.Options;
import com.blp.unicorn.utils.AudioPlayer;
import com.blp.unicorn.utils.ResourceLoader;
import com.blp.unicorn.utils.ThreadPool;


/**
 * @author Jake
 *
 */
public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 1142481021120145140L;
	private static JFrame frame = new JFrame();
	public static final int WIDTH = 640;
	public static final int HEIGHT = 1000;
	public static final String TITLE = "Unicorn Zombie Apocalypse";
	public static int score = 10000;
	private static Game game = new Game();
	public static GameState state = GameState.MENU;
	
	private boolean running = false;
	private Thread thread;
	
	private Renderer gfx;
	public Menu menu;
	public Options options;
	public HighScores highscores;
	
	private Controller controller = new Controller(); //control all of game objects
	
	private Texture tex;
	private static boolean lose = true;
	private int ticker = 0;
	
	
	/**
	 * gets game
	 * @return game
	 */
	public static Game getInstance(){
		return game;
	}
	/**
	 * gets menu instance
	 * @return menu
	 */
	public Menu getMenu(){
		return menu;
	}
	
	
	/**
	 * gets controller instance
	 * @return controller
	 */
	public Controller getController(){
		return controller;
	}
	
	
	/**
	 * Games Contructor, initializes objects, resources, sounds
	 */
	public void init(){
		ResourceLoader.loadImages();
		//ResourceLoader.loadSounds();
		tex = new Texture();
		menu = new Menu();
		options = new Options();
		highscores = new HighScores();
		gfx = new Renderer();
		
		MouseInput mouse = new MouseInput();
		this.addMouseListener(mouse);
		this.addMouseMotionListener(mouse);
		
		int x = 0;
		for(int k = 1; k <= 40; k++){
			Controller.addObject(new Block(x, HEIGHT - 64, Identities.BLOCK_METAL, tex, tex.blockMetal));
			//Controller.addObject(new Block(x, HEIGHT - 250, Identities.BLOCK_METAL, tex, tex.blockStone));
			x+=16;
		}
		Controller.addObject(new Player(300, HEIGHT - 220, Identities.PLAYER, tex));
		Controller.addObject(new Block(320, HEIGHT - 950, Identities.BLOCK_STONE, tex, tex.blockStone));
		
		
		
		
		this.addKeyListener(new KeyInput());
		
		
		//AudioPlayer.playMusic(Audio.MUSIC_BORGORE);
	}
	
	
	
	/**
	 * renders game foreground and background
	 */
	public void render(){
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		/////////////////////////////////////////
		
		gfx.renderBackground(g);
		gfx.renderForeground(g);
		
		g.dispose();
		bs.show();
		
	}
	/**
	 * ticks controller while gamestate = GAME
	 */
	public void tick(){
		if(state ==GameState.GAME)
			controller.tick();
		
		
		
			
	}
	

	
	
	@Override
	/**
	 * initializes game
	 */
	public void run() {
		init();
		
		long lastTime = System.nanoTime();
		final double numTicks = 60.0;
		double n = 1000000000 / numTicks;
		double delta = 0;
		int frames = 0;
		int ticks = 0;
		long timer = System.currentTimeMillis();
		
		while(running){
			long currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / n;
			lastTime = currentTime;
			
			if(delta >= 1){
				tick();
				ticks++;
				delta--;
				
			}
			
			render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println("FPS: " + frames);
				//frame.setTitle(TITLE + "FPS: " + frames);
				ticks = 0;
				frames = 0;
			}
			ticks = ticks + 1;
			if(ticks/2 == 30){
				Random rand = new Random();

				int  f = rand.nextInt(HEIGHT) + 1;
				Controller.addObject(new movingBlock(-15, HEIGHT - f, Identities.MOVING_BLOCK, tex, tex.blockDeath));
				
			}
			else if(ticks/2 ==15 && state == GameState.GAME){
				score = score - 5;
				System.out.println(score);
			}
				
		}
		stop();
		
	}
	/**
	 * starts game with frame and state at MENU
	 * @param args
	 */
	public static void main(String args[]){
		ThreadPool pool = new ThreadPool(2);
		Image icon = Toolkit.getDefaultToolkit().getImage(Reference.RESOURCE_LOCATION + "UnicornIcon.png");
		frame.add(game);
		frame.setTitle(TITLE);
		frame.setIconImage(icon);
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setFocusable(true);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		AudioPlayer player = new AudioPlayer("UnicornZombie", "Autoerotique");
		pool.runTask(player);
		pool.runTask(game);
		pool.join();
		frame.pack();
		game.start();
		
		
}
	
	
	/**
	 * starts game and music
	 */
	private synchronized void start(){
		if(running)
			return;
		else
			running =true;
		thread = new Thread(this);
		thread.start();
	}
	/**
	 * stops game and music
	 */
	private synchronized void stop(){
		if(!running)
			return;
		else
			running = false;
		
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.exit(1);
	}

	

}
