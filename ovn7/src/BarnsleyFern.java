import se.lth.cs.window.SimpleWindow;

import java.awt.*;

public class BarnsleyFern {
    SimpleWindow w;
    Turtle t1;
    final int dim = 640;


    public BarnsleyFern() {
        this.w = new SimpleWindow(dim, dim, "Fern");
        w.setLineColor(Color.GREEN);
        this.t1 = new Turtle(w, 200, 200);
        createFern(dim, dim);
    }



    final void createFern(int w, int h) {

        double x = 0;
        double y = 0;
        t1.penDown();

        for (int i = 0; i < 200_000; i++) {
            double tmpx, tmpy;
            double r = Math.random();

            if (r <= 0.01) {
                tmpx = 0;
                tmpy = 0.16 * y;
            } else if (r <= 0.08) {
                tmpx = 0.2 * x - 0.26 * y;
                tmpy = 0.23 * x + 0.22 * y + 1.6;
            } else if (r <= 0.15) {
                tmpx = -0.15 * x + 0.28 * y;
                tmpy = 0.26 * x + 0.24 * y + 0.44;
            } else {
                tmpx = 0.85 * x + 0.04 * y;
                tmpy = -0.04 * x + 0.85 * y + 1.6;
            }

            double distance = getDistance(x,y, tmpx, tmpy);

            x = tmpx;
            y = tmpy;

            t1.setX((int)Math.round(w / 2 + x * w / 11));
            t1.setY((int) Math.round(h - y * h / 11));
            t1.forward((int) Math.round(distance));
            //SimpleWindow.delay();

        }


    }

    private double getDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2-x1, 2)+ Math.pow(y2-y1, 2));
    }


    public static void main(String[] args) {
        new BarnsleyFern();
    }

}
