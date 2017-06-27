package HeadFirst;

import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

public class MiniMusicPlayer1 {
	public static MidiEvent makeEvent(int comd, int chan, int one, int two, int tick){
		MidiEvent event = null;
		try {
			ShortMessage a = new ShortMessage();
			a.setMessage(comd, chan, one, two);
			event = new MidiEvent(a, tick);
		} catch (Exception e) {}
		return event;
	}
	public static void main(String[] args){
		try {
			Sequencer player = MidiSystem.getSequencer();
			player.open();
			
			Sequence seq = new Sequence(Sequence.PPQ, 4);
			Track track = seq.createTrack();
			for(int i = 0; i < 100; i+=4){
				track.add(makeEvent(144, 1, i, 100, i));
				track.add(makeEvent(176, 1, i, 100, i));
				track.add(makeEvent(128, 1, i, 100, i+2));
			}
			player.setSequence(seq);
			player.setTempoFactor(200.0f);
			player.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
