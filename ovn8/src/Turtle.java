import se.lth.cs.window.SimpleWindow;

public class Turtle {

    private boolean penUp;
    private double xHome, yHome;
    private double alpha;
    private final SimpleWindow w;
    private int distanceTraveled;

    /**
     * skapar en sk�ldpadda som ritar i ritf�nstret w.
     * Fr�n b�rjan befinner sig sk�ldpaddan i punkten xHome,yHome med pennan
     * lyft och huvudet pekande rakt upp�t i f�nstret, dvs i negativ y-riktning
     */
    Turtle(SimpleWindow w, int xHome, int yHome) {
        this.w = w;
        this.xHome = xHome;
        this.yHome = yHome;
        this.penUp = true;
        this.alpha = 90;
        this.distanceTraveled = 0;
    }

    /**
     * s�nker pennan
     */
    void penDown() {
        this.penUp = false;
    }

    /**
     * lyfter pennan
     */
    void penUp() {
        this.penUp = true;
    }

    /**
     * g�r rakt fram�t n pixlar i huvudets riktning
     */
    void forward(int n) {
        this.w.moveTo((int) Math.round(this.xHome), (int) Math.round(this.yHome));
        this.xHome += (n * Math.cos(Math.toRadians(this.alpha))); // samma som PI/180
        this.yHome -= (n * Math.sin(Math.toRadians(this.alpha)));
        if (!penUp) {
            this.w.lineTo((int) Math.round(this.xHome), (int) Math.round(this.yHome));
        }

    }

    /**
     * vrider huvudet beta grader �t v�nster
     */
    void left(int beta) {
        this.alpha += beta;
    }

    /**
     * vrider hvudet beta grader �t h�ger
     */
    void right(int beta) {
        this.alpha -= beta;
    }

    /**
     * g�r till punkten newX,newY utan att rita.
     * Pennans l�ge och huvudets riktning p�verkas inte
     */
    void jumpTo(int newX, int newY) {
        this.xHome = newX;
        this.yHome = newY;
    }

    /**
     * �terst�ller huvudets riktning till den ursprungliga
     */
    void turnNorth() {
        this.alpha = 90;
    }

    /**
     * tar reda p� sk�ldpaddans aktuella x-koordinat
     */
    int getX() {
        return (int) this.xHome;
    }

    /**
     * tar reda p� sk�ldpaddans aktuella y-koordinat
     */
    int getY() {
        return (int) this.yHome;
    }

    void setY(int y) {
        this.yHome = y;
    }

    void setX(int x) {
        this.xHome = x;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    public void setDistanceTraveled(int distanceTraveled) {
        this.distanceTraveled += distanceTraveled;
    }
}
