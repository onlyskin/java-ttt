package ttt;

public class ComputerPlayer implements Player {
    private final String marker;
    private final Minimax minimax;

    public ComputerPlayer(String marker, Minimax minimax) {
        this.marker = marker;
        this.minimax = minimax;
    }

    public String getMarker() {
        return marker;
    }
    
    public Integer getMove(Board board) {
        return minimax.minimax(board, null, 0)[1];
    }
}
