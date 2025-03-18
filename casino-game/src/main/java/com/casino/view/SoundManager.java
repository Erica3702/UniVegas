package com.casino.view;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundManager {
    private Map<String, Clip> sounds;

    public SoundManager() {
        sounds = new HashMap<>();
    }

    /**
     * Dato un suono, lo avvia
     * @param nome suono da avviare
     */
    public void playSound(String name) {
        Clip clip = sounds.get(name);
        if (clip != null) {
            clip.setFramePosition(0); // dall'inizio
            clip.start();
        }
    }
   
    /**
     * Serve per caricare il suono in modo che sia pronto per essere utilizzato
     * @param path del suono
     * @param nome del suono
     */
	public void loadSound(String path, String name) {
		try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(path));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            sounds.put(name, clip);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}