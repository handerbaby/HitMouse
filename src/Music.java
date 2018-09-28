import java.applet.AudioClip;
import java.net.URL;

import javax.swing.JApplet;

public class Music{
	private URL sound;
	private AudioClip music;
	
	public Music(String ad){
		sound = this.getClass().getResource(ad);
		music = JApplet.newAudioClip(sound);
	}

	public void play(){
		music.play();
	}

	public void loopPlay(){
		music.loop();
	}

	public void stop(){
		music.stop();
	}
}
