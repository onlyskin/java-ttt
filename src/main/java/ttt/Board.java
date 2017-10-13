package ttt;

import java.util.List;
import java.util.ArrayList;

public class Board {
    private String[] cells;
    private static final String[] MARKERS = new String[]{"X", "O"};

    public Board() {
        this.cells = new String[]{"-","-","-","-","-","-","-","-","-"};
    }

    public Board(String[] cells) {
        this.cells = cells;
    }

    public Board play(int position, String marker) {
        if (!isFree(position)) {
            return this;
        }
        Board b = new Board(this.cells.clone());
        b.setCell(position, marker);
        return b;
    }

    public String getCell(int position) {
        position = position - 1;
        return this.cells[position];
    }

    public boolean isTie() {
        if (won()) {
            return false;
        } else {
            return isFull();
        }
    }

    public boolean gameOver() {
        return won() || isTie();
    }

    public boolean isWinner(String m) {
        String[] c = cells;
        return (c[0].equals(m) && c[1].equals(m) && c[2].equals(m)) ||
               (c[3].equals(m) && c[4].equals(m) && c[5].equals(m)) ||
               (c[6].equals(m) && c[7].equals(m) && c[8].equals(m)) ||
               (c[0].equals(m) && c[3].equals(m) && c[6].equals(m)) ||
               (c[1].equals(m) && c[4].equals(m) && c[7].equals(m)) ||
               (c[2].equals(m) && c[5].equals(m) && c[8].equals(m)) ||
               (c[0].equals(m) && c[4].equals(m) && c[8].equals(m)) ||
               (c[2].equals(m) && c[4].equals(m) && c[6].equals(m));
    }

    public boolean isFree(int position) {
        return this.getCell(position).equals("-");
    }

    public boolean isValidMove(int move) {
        return availableMoves().contains(move);
    }

    private void setCell(int position, String marker) {
        position = position - 1;
        this.cells[position] = marker;
    }

    private boolean isFull() {
        return availableMoves().size() == 0;
    }

    public Integer[] getAvailableMoves() {
        List<Integer> moves = availableMoves();
        return moves.toArray(new Integer[moves.size()]);
    }

    private List<Integer> availableMoves() {
        List<Integer> moves = new ArrayList();
        for (int i=0;i<9;i++) {
            if (cells[i].equals("-")) {
                moves.add(i + 1);
            }
        }
        return moves;
    }

    private boolean won() {
        if (isWinner(MARKERS[0]) || isWinner(MARKERS[1])) {
            return true;
        } else {
            return false;
        }
    }

    public String getNextMarker() {
        Integer[] moves = this.getAvailableMoves();
        Integer turn = 9 - moves.length;
        return MARKERS[turn % 2];
    }
}
