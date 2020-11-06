import se.lth.cs.window.SimpleWindow;

public class RaceTrack {

    private final int yStart;
    private final int yFinish;
    private int startingLineLength;
    private final SimpleWindow w;


    public RaceTrack(SimpleWindow w, int yStart, int yFinish) {
        this.yStart = yStart;
        this.yFinish = yFinish;
        this.w = w;
    }

    public RaceTrack(SimpleWindow w) {
        this(w, (w.getHeight() / 6), (w.getHeight()) - w.getHeight() / 6);

    }

    public void draw() {
        this.startingLineLength = w.getWidth() / 2;

        Turtle start = new Turtle(w, (w.getWidth() / 4), yStart);
        Turtle finish = new Turtle(w, (w.getWidth() / 4), yFinish);
        forward(start);
        forward(finish);
    }

    private void forward(Turtle t) {
        t.penDown();
        t.right(90);
        t.forward(startingLineLength);
    }


    public int getyStart() {
        return yStart;
    }

    public int getyFinish() {
        return yFinish;
    }

    public int getStartingLineLength() {
        return startingLineLength;
    }
}
