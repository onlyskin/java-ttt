package ttt;

import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;

public class MinimaxTest {
    Minimax minimax = new Minimax();

    @Test
    public void itChooseWinningMove() throws Exception {
        Board board = new Board(new String[]{"X","-","O","O","X","-","X","O","-"});
        Integer move = minimax.getMove(board);
        assertEquals(new Integer(9), move);
    }

    @Test
    public void itChooseWinningMove2() throws Exception {
        Board board = new Board(new String[]{"X","X","-","O","O","-","-","-","-"});
        Integer move = minimax.getMove(board);
        assertEquals(new Integer(3), move);
    }

    @Ignore
    @Test
    public void itBlocksWinningMoveAtTwoSpaces() throws Exception {
        Board board = new Board(new String[]{"O","X","O","O","X","-","X","-","X"});
        Integer move = minimax.getMove(board);
        assertEquals(new Integer(0), move);
    }
}
