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

    public Board play(int x, int y, String marker) {
        if (!this.getCell(x, y).equals("-")) {
            throw new IndexOutOfBoundsException();
        }
        Board b = new Board(this.cells);
        b.setCell(x, y, marker);
        return b;
    }

    public String getCell(int x, int y) {
        return this.cells[x][y];
    }

    private void setCell(int x, int y, String marker) {
        this.cells[x][y] = marker;
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
