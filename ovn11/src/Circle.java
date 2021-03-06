import se.lth.cs.window.SimpleWindow;

public class Circle extends Shape {

    private final int radius;

    protected Circle(int x, int y, int radius) {
        super(x, y);
        this.radius = radius;
    }

    @Override
    public void draw(SimpleWindow w) {
        int newX = x;
        int newY = y;

        for (int i = 0; i <= 5000; i++) {
            double x = newX + Math.cos(i * (Math.PI / 180)) * radius;
            double y = newY + Math.sin(i * (Math.PI / 180)) * radius;

            w.moveTo((int) x, (int) y);
            w.lineTo((int) x, (int) y);
        }
    }
}
