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

    public Board play(int position, String marker) {
        if (!this.getCell(position).equals("-")) {
            throw new IndexOutOfBoundsException();
        }
        Board b = new Board(this.cells);
        b.setCell(position, marker);
        return b;
    }

    public String getCell(int position) {
        return this.cells[position / 3][position % 3];
    }

    private void setCell(int position, String marker) {
        this.cells[position / 3][position % 3] = marker;
    }

    public boolean tie() {
        if (won()) {
            return false;
        } else {
            if (!full()) {
                return false;
            }
            return true;
        }
    }

    public boolean gameOver() {
        if (won() || tie()) {
            return true;
        } else {
            return false;
        }
    }

    private boolean full() {
        for (int i=0;i<3;i++) {
            for (int j=0;j<3;j++) {
                if (cells[i][j].equals("-")) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean won() {
        if (won("X") || won("O")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean won(String m) {
        String[][] c = cells;
        if (
            (c[0][0].equals(m) && c[0][1].equals(m) && c[0][2].equals(m)) ||
            (c[1][0].equals(m) && c[1][1].equals(m) && c[1][2].equals(m)) ||
            (c[2][0].equals(m) && c[2][1].equals(m) && c[2][2].equals(m)) ||
            (c[0][0].equals(m) && c[1][0].equals(m) && c[2][0].equals(m)) ||
            (c[0][1].equals(m) && c[1][1].equals(m) && c[2][1].equals(m)) ||
            (c[0][2].equals(m) && c[1][2].equals(m) && c[2][2].equals(m)) ||
            (c[0][0].equals(m) && c[1][1].equals(m) && c[2][2].equals(m)) ||
            (c[0][2].equals(m) && c[1][1].equals(m) && c[2][0].equals(m))
           ) {
            return true;
        }
        return false;
    }
}