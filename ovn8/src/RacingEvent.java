import se.lth.cs.window.SimpleWindow;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class RacingEvent {

    private final RaceTrack track;
    private final Random random;
    private final ArrayList<Turtle> turtles;
    private final ArrayList<Integer> xPos;
    private boolean isRunning;


    public RacingEvent(RaceTrack track) {
        this.track = track;
        this.isRunning = true;
        this.turtles = new ArrayList<>();
        this.xPos = new ArrayList<>();
        this.random = new Random();

    }


    public void createTurtle(SimpleWindow w, int numberTurtles) {
        int x = (int) Math.round(track.getStartingLineLength() / 2.0);
        int y = track.getyFinish();
        for (int i = 0; i < numberTurtles; i++) {

            this.turtles.add(new Turtle(w, x, y)); //lägger till nya turtles i arraylist

        }
        turtleStartingPos();
        lineNumberText(w); //printar siffrorna under startlinjen
    }


    private void turtleStartingPos() {
        double xStartingPos = (double) (track.getStartingLineLength() / turtles.size()) / 2; //xCord för första turtlen.

        for (Turtle turtle : turtles) { //loopar igenom varje turtle i arraylisten och placerar ut på startfältet

            turtle.right(90);
            turtle.forward((int) Math.round(xStartingPos));
            turtle.turnNorth();
            xPos.add((int) xStartingPos);

            xStartingPos += (double) track.getStartingLineLength() / turtles.size();
        }
    }

    private void lineNumberText(SimpleWindow w) {
        int numberText = 1;
        for (int x : xPos) {
            w.moveTo((int) Math.round(x + track.getStartingLineLength() / 2.0), track.getyFinish() + 40);
            w.writeText(String.valueOf(numberText));
            numberText++;
        }
    }


    public void playLap(SimpleWindow w) {
        w.waitForMouseClick();
        while (isRunning) {
            int rand;

            for (Turtle turtle : turtles) {
                turtle.penDown();
                rand = random.nextInt(3);
                turtle.forward(rand);
                turtle.setDistanceTraveled(rand);
                SimpleWindow.delay(2);

                if (turtle.getY() <= track.getyStart()) {
                    System.out.println("Turtle nummer " + (turtles.indexOf(turtle) + 1) + " vann!");
                    w.setLineColor(Color.GREEN);
                    turtle.right(180);
                    turtle.forward(turtle.getDistanceTraveled());

                    isRunning = false;

                }
            }
        }

    }


}



