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

    public Board play(int position, Player player) {
        if (!isFree(position)) {
            throw new IndexOutOfBoundsException();
        }
        Board b = new Board(this.cells);
        b.setCell(position, player.getMarker());
        return b;
    }

    public String getCell(int position) {
        position = position - 1;
        return this.cells[position / 3][position % 3];
    }

    private void setCell(int position, String marker) {
        position = position - 1;
        this.cells[position / 3][position % 3] = marker;
    }

    public boolean isTie(Player[] players) {
        if (won(players)) {
            return false;
        } else {
            if (!isFull()) {
                return false;
            }
            return true;
        }
    }

    public boolean gameOver(Player[] players) {
        if (won(players) || isTie(players)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isFull() {
        for (int i=0;i<3;i++) {
            for (int j=0;j<3;j++) {
                if (cells[i][j].equals("-")) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean won(Player[] players) {
        if (isWinner(players[0]) || isWinner(players[1])) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isWinner(Player player) {
        String m = player.getMarker();
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

    public boolean isFree(int position) {
        return this.getCell(position).equals("-");
    }
}
