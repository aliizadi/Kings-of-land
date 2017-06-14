package Other;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Music {
	private String soundsName [];
	private Clip  [] clips;
	public Music() {
		// TODO Auto-generated constructor stub
		soundsName = new String[36];
		clips = new Clip[36];
		//mouse entered the menu button
		soundsName[1] = "Music\\clicked.wav";
		//clicked menu button
		soundsName[2] = "Music\\mouse_click.wav";
		//clicked on quarry farm
		soundsName[3] = "Music\\FarmHouse nice.wav";
		//clicked on quarry gold
		soundsName[4] = "Music\\golding.wav";
		//clicked on quarry iron
		soundsName[5] = "Music\\quarry iron clicked.wav";
		//clicked on quarry wood
		soundsName[6] = "Music\\quarry wood clicked.wav";
		//clicked on barracks
		soundsName[7] = "Music\\barrackes clicked nice.wav";
		//clicked on seaPort
		soundsName[8] = "Music\\sea port clicked.wav";
		//clicked on worker
		soundsName[9] = "Music\\Clicked on worker.wav";
		//clicked on soldier
		soundsName[10] = "Music\\Soldierd clicked.wav";
		//fishing ship clicked
		soundsName[11] = "Music\\Fishing2.wav";
		//gold mine selected
		soundsName[12] = "Music\\gold mine.wav";
		//iron mine selected
		soundsName[13] = "Music\\mining (2).wav";
		//fisinig source selected
		soundsName[14] = "Music\\fishing.wav";
		//farm source selected and worker farming
		soundsName[15] = "Music\\Farming.wav";
		//clicked on castle 
		soundsName[16] = "Music\\Clicked on worker.wav";
		//worker golding
		soundsName[17] = "Music\\golding.wav";
		//worker ironing
		soundsName[18] = "Music\\mining.wav";
		//worker wooding
		soundsName[19] = "Music\\Soldier Attacked.wav";
		//soldier attacked
		soundsName[20] = "Music\\attack sword l50.wav";
		//soldier die
		soundsName[21] = "Music\\uuh.wav";
		//worker die
		soundsName[22] = "Music\\uuaaah.wav";
		//worker bulding
		soundsName[23] = "Music\\bulding.wav";
		//no passible
		soundsName[24] = "Music\\notPassible.wav";
		//button clicked
		soundsName[25] = "Music\\SInglePlayer Clicked.wav";
		//pause game
		soundsName[26] = "Music\\pausengong_m.wav";
		//rebulding house
		soundsName[27] = "Music\\rebulding.wav";
		//ship clicked
		soundsName[28] = "Music\\switch_acitvated.wav";
		//tree selected 
		soundsName[29] = "Music\\buttonklick l40.wav";
		//clicked on exit
		soundsName[0] = "Music\\game_over.wav";
		//open pause
		soundsName[30] = "Music\\pause opened.wav";
		//PAUSE
		soundsName[31] = "Music\\pause.wav";
		//Menu music
		soundsName[32] = "Music\\Menu\\Menu.wav";
		//Game Music
		soundsName[33] = "Music\\Menu\\Game.wav";
		//MapEditor Music
		soundsName[34] = "Music\\Menu\\MapEditor.wav";
		//PreView Music
		soundsName[35] = "Music\\Menu\\Preview.wav";
		for(int i=0 ; i<36 ; i++){
			AudioInputStream audioInputStream = null;
			try {
				audioInputStream = AudioSystem.getAudioInputStream(new File(soundsName[i]).getAbsoluteFile());
			} catch (UnsupportedAudioFileException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				clips[i] = AudioSystem.getClip();
			} catch (LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				clips[i].open(audioInputStream);
			} catch (LineUnavailableException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}	

	public void playsound(int i ,boolean pause){    
		if(pause==false){
			clips[i].setFramePosition(0);
			clips[i].start();
		}
		if(pause==true)
		{
			clips[i].stop();
		}
	}

	public void playSoundloop(int i ,boolean pause){
		if(pause==false){
			clips[i].setFramePosition(0);
			clips[i].loop(Clip.LOOP_CONTINUOUSLY);
		}
		if(pause==true)
		{
			clips[i].stop();
		}
	}

}