public class Life {
    LifeBoard board;

    public Life(LifeBoard board) {
        this.board = board;

    }

    public void newGeneration() {
        boolean[][] newGen = new boolean[board.getRows()][board.getCols()]; // temp board
        this.board.increaseGeneration();

        for (int row = 0; row < board.getRows(); row++) {
            for (int col = 0; col < board.getCols(); col++) {

                if ((board.get(row, col)) && (getNeighbours(row, col) < 2)) { //dör av isolering :(
                    newGen[row][col] = false;
                }

                else if ((board.get(row, col)) && (getNeighbours(row, col) > 3)) { //dör av överpopulation :(
                    newGen[row][col] = false;
                }

                else if ((board.get(row, col)) && (getNeighbours(row, col) == 3) || (getNeighbours(row, col) == 2)) { //lever vidare + föds
                    newGen[row][col] = true;
                }

                else { // samma som innan
                    newGen[row][col] = board.get(row, col);
                }
            }
        }
        for (int row = 0; row < board.getRows(); row++) {
            for (int col = 0; col < board.getCols(); col++) {
                board.put(row,col, newGen[row][col]);
            }

        }
    }

    private int getNeighbours(int row, int col) {
        int count = 0;
        for (int r = -1; r <= 1; r++) {
            for (int c = -1; c <= 1; c++) {
                if (board.get(r + row, c + col)) {
                    count++;
                }
            }
        }
        count--;
        return count; //minus orginalcellen
    }

    void flip(int row, int col) {
        board.put(row, col, !board.get(row, col));
    }

}
