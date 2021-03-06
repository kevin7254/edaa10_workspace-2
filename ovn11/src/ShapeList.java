import se.lth.cs.window.SimpleWindow;

import java.util.ArrayList;
import java.util.List;

public class ShapeList {

    private final List<Shape> shapes;

    protected ShapeList() {
        this.shapes = new ArrayList<>();
    }

    public void insert(Shape s) {
        shapes.add(s);
    }

    public void draw(SimpleWindow w) {
        for (Shape s : shapes) {
            s.draw(w);
        }
    }

    public Shape findHit(int xc, int yc) {
        for (Shape s : shapes) {
            if (s.near(xc, yc)) {
                return s;
            }
        }
        return null;
    }
}
