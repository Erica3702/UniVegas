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


    public void playSound(String name) {
        Clip clip = sounds.get(name);
        if (clip != null) {
            clip.setFramePosition(0); // Riavvolgi il suono all'inizio
            clip.start();
        }
    }

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