/**
 * 
 */
package com.blp.unicorn.input;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * @author Jake
 *
 */
public class HSWriter {
	
	/**
	 * writes highscore to file
	 * @param score
	 * @throws FileNotFoundException
	 */
	public static void fileWriter(int score) throws FileNotFoundException{
		PrintWriter writer = new PrintWriter("HighScores.csv");
		String sc = Integer.toString(score);
		
		writer.write(sc);
		writer.append("\n");
		
		writer.close();
		
	}

}
