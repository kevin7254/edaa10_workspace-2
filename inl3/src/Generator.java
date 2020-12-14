import java.awt.*;

public class Generator {

    private final static int ITERATIONS = 200;
    private final Color[] colorArray = new Color[ITERATIONS];

    public Generator() {
        for (int i = 0; i < ITERATIONS; i++) {
            colorArray[i] = new Color(0, 0, i + 20);
        }

    }

    public void render(MandelbrotGUI gui) {
        gui.disableInput();
        Complex[][] mesh = mesh(gui.getMinimumReal(), gui.getMaximumReal(),
                gui.getMinimumImag(), gui.getMaximumImag(), gui.getWidth(), gui.getHeight());
        int pixelCount = 1;

        switch (gui.getResolution()) {
            case MandelbrotGUI.RESOLUTION_VERY_HIGH -> {
            }
            case MandelbrotGUI.RESOLUTION_HIGH -> pixelCount = 3;
            case MandelbrotGUI.RESOLUTION_MEDIUM -> pixelCount = 5;
            case MandelbrotGUI.RESOLUTION_LOW -> pixelCount = 7;
            case MandelbrotGUI.RESOLUTION_VERY_LOW -> pixelCount = 9;
        }
        Color[][] picture = new Color[gui.getHeight()][gui.getWidth()];

        for (int i = 0; i < gui.getHeight(); i++) {
            for (int j = 0; j < gui.getHeight(); j++) {
                Complex c = new Complex(0, 0);
                int count = 0;
                while (count++ < ITERATIONS && c.getAbs2() <= 2) {
                    c.mul(c);
                    c.add(mesh[i][j]);
                }

                switch (gui.getMode()) {
                    case MandelbrotGUI.MODE_BW -> {
                        if (c.getAbs2() <= 2) {
                            picture[i / pixelCount][j / pixelCount] = Color.BLACK;
                        } else {
                            picture[i / pixelCount][j / pixelCount] = Color.WHITE;
                        }
                    }

                    case MandelbrotGUI.MODE_COLOR -> {
                        if (count < ITERATIONS) {
                            picture[i / pixelCount][j / pixelCount] = colorArray[count];
                        } else {
                            picture[i / pixelCount][j / pixelCount] = Color.MAGENTA;
                        }
                    }
                }
            }
        }
        gui.putData(picture, pixelCount, pixelCount);
        gui.enableInput();
    }

    private Complex[][] mesh(double minRe, double maxRe, double minIm, double maxIm, int width, int height) {
        Complex[][] mesh = new Complex[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                double im = maxIm - (maxIm - minIm) / (height - 1) * i;
                double re = minRe + (maxRe - minRe) / (width - 1) * j;
                mesh[i][j] = new Complex(re, im);
            }
        }
        return mesh;
    }

    private void circle_old(MandelbrotGUI gui, Complex[][] mesh, Color[][] picture, int pixelCount) {
        for (int i = 0; i < gui.getHeight(); i++) {
            for (int j = 0; j < gui.getWidth(); j++) {
                if (mesh[i][j].getAbs2() > 1) {
                    picture[i / pixelCount][j / pixelCount] = Color.WHITE;
                } else if (mesh[i][j].getRe() > 0 && mesh[i][j].getIm() > 0) { //Första kvadranten
                    picture[i / pixelCount][j / pixelCount] = Color.RED;
                } else if (mesh[i][j].getRe() < 0 && mesh[i][j].getIm() > 0) { //Andra kvadranten
                    picture[i / pixelCount][j / pixelCount] = Color.BLUE;
                } else if (mesh[i][j].getRe() < 0 && mesh[i][j].getIm() < 0) { //Tredje kvadranten
                    picture[i / pixelCount][j / pixelCount] = Color.GREEN;
                } else if (mesh[i][j].getRe() > 0 && mesh[i][j].getIm() < 0) { //Fjärde kvadranten
                    picture[i / pixelCount][j / pixelCount] = Color.YELLOW;
                }
            }
        }
    }
}
