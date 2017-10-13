package ttt;

public class Minimax {

    public Integer[] minimax(Board board, String mainPlayerMarker, int depth) {
        if (mainPlayerMarker == null) {
            mainPlayerMarker = board.getNextMarker();
        }

        if (board.gameOver()) {
            int score = score(board, mainPlayerMarker);
            return new Integer[]{score, null};
        }

        Integer[] moves = board.getAvailableMoves();
        Integer[][] nodes = new Integer[moves.length][2];
        for (int i=0;i<moves.length; i++) {
            Board newBoard = board.play(moves[i], board.getNextMarker());
            Integer[] bestMove = minimax(newBoard, mainPlayerMarker, depth+1);    
            bestMove[1] = moves[i];
            nodes[i] = bestMove;
        }

        return bestByScore(nodes, depth);
    }

    private Integer[] bestByScore(Integer[][] nodes, int depth) {
        Integer[] bestNode = new Integer[]{null, null};
        for (int i=0;i<nodes.length;i++) {
            if (bestNode[0] == null) {
                bestNode = nodes[i];
            } else {
                if (depth % 2 == 0) {
                    if (nodes[i][0] > bestNode[0]) {
                        bestNode = nodes[i];
                    }
                } else {
                    if (nodes[i][0] < bestNode[0]) {
                        bestNode = nodes[i];
                    }
                }
            }
        }
        return bestNode;
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
}
