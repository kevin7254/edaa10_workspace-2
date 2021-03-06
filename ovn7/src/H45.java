import java.util.Random;

//import se.lth.cs.p.ovn.turtle.Turtle;
import se.lth.cs.window.SimpleWindow;

public class H45 {
    private int nbr1, nbr2;
    SimpleWindow w;
    Turtle t1, t2;
    Random random;
    private static final int DELAY = 10;


    public H45() {
        this.w = new SimpleWindow(600,600,"Randomness");
        this.t1 = new Turtle(w,250,250);
        this.t2 = new Turtle(w,350,350);
        this.random = new Random();
        wandering();

    }


    public int getDistance(int x1, int y1, int x2, int y2) {
        return (int) Math.sqrt(Math.pow(x2-x1, 2)+ Math.pow(y2-y1, 2));
    }


    public final void wandering() {
        t1.penDown();
        t2.penDown();
        while(getDistance(t1.getX(), t1.getY(), t2.getX(),t2.getY()) >= 50) {

            move(t1);
            move(t2);

            SimpleWindow.delay(DELAY);
        }
        System.out.print("klar");
    }


    public void move(Turtle t) {
        setNbrs();
        t.forward(nbr1);
        t.right(nbr2);
    }


    public void setNbrs() {
        this.nbr1 = 1 + random.nextInt(10);
        this.nbr2 = -179 + random.nextInt(360);

    }


    public static void main(String[] args) {
        new H45();
    }
}


