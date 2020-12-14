public class Mandelbrot {

    public static void main(String[] args) {
        MandelbrotGUI gui = new MandelbrotGUI();
        Generator generator = new Generator();
        boolean hasImage = false;
        while(true) {
            switch (gui.getCommand()) {
                case MandelbrotGUI.QUIT -> System.exit(1);
                case MandelbrotGUI.RENDER -> {
                    hasImage = true;
                    generator.render(gui);
                }
                case MandelbrotGUI.RESET ->  {
                    hasImage = false;
                    gui.resetPlane();
                    gui.clearPlane();
                }
                case MandelbrotGUI.ZOOM -> {
                    if (hasImage) {
                        generator.render(gui);
                    } else {
                        gui.resetPlane();
                    }
                }
            }
        }
    }
}
