import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

public class Sound {

	public static void main(String[] args) {
		try {
			Clip audioClip = AudioSystem.getClip();
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File("sample.wav"));
			
			audioClip.open(audioStream);
			audioClip.start();
			
			JOptionPane.showMessageDialog(null, "Close to stop sound.");

			audioClip.stop();
	        audioClip.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
