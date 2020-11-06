import se.lth.cs.window.SimpleWindow;

public class TurtleRace {

    public static void main(String[] args) {

        SimpleWindow w = new SimpleWindow(500,500,"Race");
        RaceTrack track = new RaceTrack(w);
        RacingEvent race = new RacingEvent(track);

        track.draw();
        race.createTurtle(w,8);
        race.playLap(w);

    }

}
