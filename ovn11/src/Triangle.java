import se.lth.cs.window.SimpleWindow;

public class Triangle extends Shape {

    private final int sizeLength;

    protected Triangle(int x, int y, int sizeLength) {
        super(x, y);
        this.sizeLength = sizeLength;
    }

    @Override
    public void draw(SimpleWindow w) {
        int newX = x;
        int newY = y;
        w.moveTo(newX, newY);
        newX += sizeLength;
        w.lineTo(newX, newY);
        newX -= (sizeLength / 2);
        newY -= (int) (Math.sqrt(3) / 2 * sizeLength); // Sqrt(3)/2 == 60 grader för y (sinus)
        w.lineTo(newX, newY);
        w.lineTo(x, y);
    }
}
