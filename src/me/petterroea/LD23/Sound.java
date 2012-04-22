package me.petterroea.LD23;

import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound {
	private Clip clip;
	public static boolean soundAccepted = true;
	public static boolean soundEnabled = true;
	
	public Sound(String name)
	{
		try {
			AudioInputStream stream = AudioSystem.getAudioInputStream(Sound.class.getResourceAsStream(name));
			clip = AudioSystem.getClip();
			clip.open(stream);
		} catch (Exception e) {
			System.out.println("ERROR: Failed to load sound: " + name + ". Sound is disabled");
			System.out.println(e);
			soundAccepted = false;
		}
	}
	public void play()
	{
		if(soundAccepted && soundEnabled)
		{
			try{
				new Thread(){
					public void run()
					{
						synchronized(clip)
						{
							clip.stop();
							clip.setFramePosition(0);
							clip.start();
						}
					}
				}.start();
			} catch(Exception e){
				System.out.println("Failed to play sound. Sound deactivated.");
				System.out.println(e);
				soundAccepted = false;
			}
		}
	}
}
