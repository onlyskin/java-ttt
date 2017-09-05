package ttt;

import java.util.Random;

public class ComputerPlayer implements Player {
    String marker;
    Random random;

    public ComputerPlayer(String marker, Random random) {
        this.marker = marker;
        this.random = random;
    }

    public String getMarker() {
        return marker;
    }

    private Integer getRandomCell() {
        return random.nextInt(9) + 1;
    }
    
    public Integer getMove(Board board) {
        Integer choice = getRandomCell();
        if (board.isFree(choice)) {
            return choice;
        } else {
            return getMove(board);
        }
    }
}
