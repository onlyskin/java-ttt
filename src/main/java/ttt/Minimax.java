package ttt;

public class Minimax {

    private String getMarker(Board board) {
        Integer[] moves = board.getAvailableMoves();
        Integer turn = 9 - moves.length;
        String marker = "X";
        if (turn % 2 == 1) {
            marker = "O";
        }
        return marker;
    }

    // private int score(Board board, String marker) {
    //     if (board.isTie()) {
    //         return 0;
    //     } else if (board.isWinner(marker)) {
    //         return 10;
    //     } else {
    //         return -10;
    //     }
    // }

    public Integer getMove(Board board) {
        Integer[] moves = board.getAvailableMoves();
        String marker = getMarker(board);
        for (Integer move : moves) {
            Board newBoard = board.play(move, marker);
            if (newBoard.isWinner(marker)) {
                return move;
            }
            else {
                Integer[] moves2 = newBoard.getAvailableMoves();
                String marker2 = getMarker(newBoard);
                for (Integer move2 : moves2) {
                    Board newBoard2 = newBoard.play(move2, marker2);
                    if (newBoard2.isWinner(marker2)) {
                        return move2;
                    }
                }
            }
        }
        return null;
    }
}
