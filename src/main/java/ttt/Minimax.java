package ttt;

public class Minimax {

    public Integer getMove(Board board) {
        Integer[] moves = board.getAvailableMoves();
        Integer turn = 9 - moves.length;
        String marker = "X";
        if (turn % 2 == 1) {
            marker = "O";
        }
        for (Integer move : moves) {
             Board newBoard = board.play(move, marker);
             if (newBoard.isWinner(marker)) {
                 return move;
             }
        }
        return null;
    }
}
