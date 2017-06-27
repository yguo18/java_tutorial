package HeadFirst;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.management.loading.MLet;
import javax.sound.midi.ControllerEventListener;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MiniMusicPlayer3 {
	static JFrame f= new JFrame("My Head First Music Video");
	static MyDrawPanel ml;
	public static void main(String[] args){
		MiniMusicPlayer3 mini = new MiniMusicPlayer3();
		mini.go();
	}
	public void go(){
		setGui();
		try {
			Sequencer sequencer = MidiSystem.getSequencer();
			sequencer.open();
			
			int[] eventsIwant = {127};
			sequencer.addControllerEventListener(ml, eventsIwant);
			
			Sequence seq = new Sequence(Sequence.PPQ, 4);
			Track track = seq.createTrack();
			
			int r = 0;
			for(int i = 5; i < 60; i += 4){
				r = (int)((Math.random() * 50)+1);
				track.add(makeEvent(144, 1, r, 100, i));//类型、频道、音符、音道、音长
				track.add(makeEvent(176, 1, 127, 0, i));
				track.add(makeEvent(128, 1, r, 100, i+2));
			}
			sequencer.setSequence(seq);
			sequencer.setTempoInBPM(20);
			sequencer.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public MidiEvent makeEvent(int comd, int chan, int one, int two, int tick){
		MidiEvent event = null;
		try{
			ShortMessage a = new ShortMessage();
			a.setMessage(comd, chan, one, two);
			event = new MidiEvent(a, tick);
		}catch(Exception ex){}
		return event;
	}
	
	public void setGui(){
		ml = new MyDrawPanel();
		f.setContentPane(ml);
		f.setBounds(30,30,300,300);
		f.setVisible(true);
	}
	
	class MyDrawPanel extends JPanel implements ControllerEventListener{
		boolean msg = false;
		public void controlChange(ShortMessage event){
			msg = true;
			repaint();
		}
		public void paintComponent(Graphics g){
			if(msg){
				Graphics2D g2 = (Graphics2D) g;
				int r = (int) (Math.random() * 250);
				int gr = (int)(Math.random() * 250);
				int b =(int) (Math.random() * 250);
				
				g.setColor(new Color(r, gr, b));
				
				int ht = (int) ((Math.random() * 120) +10);
				int width = (int) ((Math.random() * 120) +10);
				int x = (int) ((Math.random() * 120) +10);
				int y = (int) ((Math.random() * 120) +10);
				
				g.fillRect(x, y, ht, width);
				msg = false;
				
			}
		}
	}
	
}
