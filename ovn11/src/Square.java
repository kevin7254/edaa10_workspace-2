import se.lth.cs.window.SimpleWindow;

public class Square extends Shape {

    private final int sizeLength;

    protected Square(int x, int y, int sizeLength) {
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
        newY -= sizeLength;
        w.lineTo(newX, newY);
        newX -= sizeLength;
        w.lineTo(newX, newY);
        newY += sizeLength;
        w.lineTo(newX, newY);
    }
}
