package ttt;

public class Board {
    private final String[][] cells;

    public Board() {
        this.cells = new String[][]{{"-","-","-"},
                                     {"-","-","-"},
                                     {"-","-","-"}};
    }

    public Board(String[][] cells) {
        this.cells = cells;
    }

    public boolean xWon() {
        if (
            (cells[0][0].equals("X") && cells[0][1].equals("X") && cells[0][2].equals("X")) ||
            (cells[1][0].equals("X") && cells[1][1].equals("X") && cells[1][2].equals("X")) ||
            (cells[2][0].equals("X") && cells[2][1].equals("X") && cells[2][2].equals("X")) ||
            (cells[0][0].equals("X") && cells[1][0].equals("X") && cells[2][0].equals("X")) ||
            (cells[0][1].equals("X") && cells[1][1].equals("X") && cells[2][1].equals("X")) ||
            (cells[0][2].equals("X") && cells[1][2].equals("X") && cells[2][2].equals("X")) ||
            (cells[0][0].equals("X") && cells[1][1].equals("X") && cells[2][2].equals("X")) ||
            (cells[0][2].equals("X") && cells[1][1].equals("X") && cells[2][0].equals("X"))
           ) {
            return true;
        }
        return false;
    }
}
