/**
 * 
 */
package com.blp.unicorn.utils;


import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;

import java.io.File;
import java.util.ArrayList;

public class AudioPlayer implements Runnable {
    
    private ArrayList<String> musicFiles;
    private int currentSongIndex;
    
    /**
     * loads songs into an arraylist
     * @param files
     */
    public AudioPlayer(String... files){
        musicFiles = new ArrayList<String>();
        for(String file : files)
            musicFiles.add("./resources/sounds/" + file + ".wav");
    }
    
    /**
     * decides what song to play
     * @param fileName
     */
    private void playSound(String fileName){
        try{
            File soundFile = new File(fileName);
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);
            AudioFormat format = ais.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            Clip clip = (Clip) AudioSystem.getLine(info);
            clip.open(ais);
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-10);
            clip.start();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    /**
     * plays current song in arraylist
     */
    public void run() {
        playSound(musicFiles.get(currentSongIndex));
    }

}