public class LifeController {

    public static void main(String[] args) {
        LifeBoard board = new LifeBoard(20,20);
        LifeView window = new LifeView(board);
        Life life = new Life(board);
        window.drawBoard();

        init(window, life);

    }



    public static void init(LifeView window, Life life) {

        while(true) {

            int command = window.getCommand();
            if (command == 1) { //Om man klickar i en ruta
                life.flip(window.getRow(), window.getCol());
                window.update();
            } else if (command == 2) { //Om man klickar next
                life.newGeneration();
                window.update();
            }
            else if (command == 3) {
                System.exit(0);
            }
        }

    }

}
