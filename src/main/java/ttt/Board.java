package ttt;

import java.util.List;
import java.util.ArrayList;

public class Board {
    private String[] cells;

    public Board() {
        this.cells = new String[]{"-","-","-","-","-","-","-","-","-"};
    }

    public Board(String[] cells) {
        this.cells = cells;
    }

    public Board play(int position, Player player) {
        if (!isFree(position)) {
            return this;
        }
        Board b = new Board(this.cells);
        b.setCell(position, player.getMarker());
        return b;
    }

    public String getCell(int position) {
        position = position - 1;
        return this.cells[position];
    }

    public boolean isTie(Player[] players) {
        if (won(players)) {
            return false;
        } else {
            return isFull();
        }
    }

    public boolean gameOver(Player[] players) {
        return won(players) || isTie(players);
    }

    public boolean isWinner(Player player) {
        String m = player.getMarker();
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

    private List<Integer> availableMoves() {
        List<Integer> moves = new ArrayList();
        for (int i=0;i<9;i++) {
            if (cells[i].equals("-")) {
                moves.add(i + 1);
            }
        }
        return moves;
    }

    private boolean won(Player[] players) {
        if (isWinner(players[0]) || isWinner(players[1])) {
            return true;
        } else {
            return false;
        }
    }
    
}
