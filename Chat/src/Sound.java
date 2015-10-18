import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound {
	
	private class Segment {
		String s;
		int i, f;
		
		public Segment(String s, int i, int f) {
			this.s = s;
			this.i = i;
			this.f = f;
		}
	}
	
	private int speed = 1;
	private int skip = 0;
	private ArrayList<Segment> as = new ArrayList<Segment>();
	
	/**
	 *  Adds the contents of a sound file to the end of this sound.
	 *  
	 *  @param s the path or URL to the file to be played
	 */
	public void add(String s) {
		add(s, 0, -1);
	}
	
	/**
	 * Adds a section of a sound file starting from the i seconds up to the end.
	 * 
	 * @param s the name of the file to be played
	 * @param i the second to start playing from 	
	 */
	public void add(String s, int i) {
		add(s, i, -1);
	}

	/**
	 * Adds a section of a sound file starting from the i seconds up to f seconds.
	 * 
	 * @param s the name of the file to be played
	 * @param i the second to start playing from
	 * @param f the second to play up to 	
	 */
	public void add(String s, int i, int f) {
		as.add(new Segment(s,i,f));
	}
	
	/**
	 * Plays this sound for a certain amount of time.
	 * 
	 * @param t the time in seconds
	 */
	public void play(int t) {
		int i = 0;
		int eskip = 0;
		if (t > 0) eskip += t;
		
		for ( ; i < as.size(); i++) {
			Segment seg = as.get(i);
			int segi = seg.i / speed;
			if (t == 0) return;
			
			try {
				AudioInputStream ais;
				if (seg.s.startsWith("http://")) {
		        	ais = AudioSystem.getAudioInputStream(new URL(seg.s));
				} else if (seg.s.endsWith(".mp3")) {
					AudioInputStream in = AudioSystem.getAudioInputStream(new File(seg.s));
					AudioFormat baseFormat = in.getFormat();
					AudioFormat decodedFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 
					                                            baseFormat.getSampleRate(),
					                                            16,
					                                            baseFormat.getChannels(),
					                                            baseFormat.getChannels() * 2,
					                                            baseFormat.getSampleRate(),
					                                            false);
					ais = AudioSystem.getAudioInputStream(decodedFormat, in);
				} else {
		        	ais = AudioSystem.getAudioInputStream(new File(seg.s));
				}
				
				int segf = seg.f / speed;
				if (seg.f < 0) {
					segf = (int) (ais.getFrameLength() / ais.getFormat().getFrameRate());
				}
				if (skip > segf - segi) {
					skip -= segf - segi;
					continue;
				} else {
					segi = skip;
					skip -= segf - segi;
				}
				if (skip < 0) skip = 0;
				
		    	byte[] b1 = getAis(ais);
				int frameSize;
		        AudioFormat af = ais.getFormat();
		        frameSize = af.getFrameSize();
		        ais.close();
		        
		        byte[] b2 = new byte[b1.length / speed];
		        for (int ii = 0; ii < b2.length / frameSize; ii++) {
		            for (int jj = 0; jj < frameSize; jj ++) {
		            	int v = ii * frameSize * speed + jj;
		            	if(v > b1.length - 1) v = b1.length - 1;
		            	byte n = b1[v];
		                b2[ii * frameSize + jj] = n;
		            }
		        }
		        
		        ByteArrayInputStream bais = new ByteArrayInputStream(b2);
		        AudioInputStream aisAccelerated = new AudioInputStream(bais, af, b2.length);
		        Clip clip = AudioSystem.getClip();
		        clip.open(aisAccelerated);
		        clip.setMicrosecondPosition(segi * 1000000);
		        clip.start();
		        
		        if (segf - segi > t && t > 0) {
			        while (clip.getMicrosecondPosition() <= (t + segi) * 1000000) {}
		        } else {
		        	while (clip.getMicrosecondPosition() <= segf * 1000000) {}
		        }
		        
		        clip.stop();
		        clip.close();
		        aisAccelerated.close();
		        bais.close();
		        
		        if (t > 0) {
		        	t -= segf - segi;
		        } else {
					eskip += segf - segi;
		        }
				
				if (skip < 0) skip = 0;
			} catch (IOException e) {
				e.printStackTrace();
			} catch (UnsupportedAudioFileException e) {
				e.printStackTrace();
			} catch (LineUnavailableException e) {
				e.printStackTrace();
			}
		}
		
		skip += eskip;
	}
	
	/**
	 * Plays this sound until the end.
	 */
	public void play() {
		play(-1);
	}
	
	/**
	 * Skips to the given position in the sound.
	 *
	 * @param skip the time in seconds to skip to
	 */
	public void skipTo(int skip) {
		this.skip = skip;
	}
	
	/**
	 * Changes the playing speed of the sound. Should be called before calling play().
	 * 
	 * @param speed the factor to multiply the speed by
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
    private byte[] getAis(AudioInputStream ais) throws IOException {
    	ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] b = new byte[ais.available()];
        int read = 1;
        
        while (read > -1) {
            read = ais.read(b);
            if (read > 0) {
                baos.write(b, 0, read);
            }
        }
        
		return baos.toByteArray();
    }
	
}
