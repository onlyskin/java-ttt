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

     private int score(Board board, String marker) {
         if (board.isTie()) {
             return 0;
         } else if (board.isWinner(marker)) {
             return 10;
         } else {
             return -10;
         }
     }

    public Integer[] minimax(Board board, String mainPlayerMarker, int depth) {
        if (mainPlayerMarker == null) {
            mainPlayerMarker = getMarker(board);
        }

        if (board.gameOver()) {
            int score = score(board, mainPlayerMarker);
            return new Integer[]{score, null};
        }

        Integer[] moves = board.getAvailableMoves();
        Integer[][] nodes = new Integer[moves.length][2];
        String marker = getMarker(board);
        for (int i=0;i<moves.length; i++) {
            Integer move = moves[i];
            Board newBoard = board.play(move, marker);
            Integer[] bestMove = minimax(newBoard, mainPlayerMarker, depth+1);    
            bestMove[1] = move;
            nodes[i] = bestMove;
        }

        Integer[] result = new Integer[]{null, null};
        for (int i=0;i<nodes.length;i++) {
            if (result[0] == null) {
                result = nodes[i];
            } else {
                if (depth % 2 == 0) {
                    if (nodes[i][0] > result[0]) {
                        result = nodes[i];
                    }
                } else {
                    if (nodes[i][0] < result[0]) {
                        result = nodes[i];
                    }
                }
            }
        }

        return result;
    }
}
