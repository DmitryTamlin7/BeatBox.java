import javax.sound.midi.*;

public class MiniminimusicApp {
    public static void main(String[] args) {
        MiniminimusicApp mini = new MiniminimusicApp();
        mini.play();
    }

    public void play() {
        try {
            // Создание последовательности
            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            // Создание и добавление события "note on"
            ShortMessage a = new ShortMessage();
            a.setMessage(144, 1, 44, 100); // note on
            MidiEvent noteOn = new MidiEvent(a, 1);
            track.add(noteOn);

            // Создание и добавление события "note off"
            ShortMessage b = new ShortMessage();
            b.setMessage(128, 1, 44, 100); // note off
            MidiEvent noteOff = new MidiEvent(b, 16); // note off через 16 тиков
            track.add(noteOff);

            // Создание синтезатора и проигрывание последовательности
            Sequencer player = MidiSystem.getSequencer();
            player.open();
            player.setSequence(seq);
            player.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}