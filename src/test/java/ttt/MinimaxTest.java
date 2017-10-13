package ttt;

import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;

public class MinimaxTest {
    Minimax minimax = new Minimax();

    @Test
    public void choosesWinningMove() throws Exception {
        Board board = new Board(new String[]{"X","-","O","O","X","-","X","O","-"});
        Integer move = minimax.minimax(board, null, 0)[1];
        assertEquals(new Integer(9), move);
    }

    @Test
    public void choosesWinningMove2() throws Exception {
        Board board = new Board(new String[]{"X","X","-","O","O","-","-","-","-"});
        Integer move = minimax.minimax(board, null, 0)[1];
        assertEquals(new Integer(3), move);
    }

    @Test
    public void blocksWinningMove() throws Exception {
        Board board = new Board(new String[]{"X","X","-","O","-","-","-","-","-"});
        Integer move = minimax.minimax(board, null, 0)[1];
        assertEquals(new Integer(3), move);
    }

    @Test
    public void playsInFirstCellWhenGoesFirst() throws Exception {
        Board board = new Board();
        Integer move = minimax.minimax(board, null, 0)[1];
        assertEquals(new Integer(1), move);
    }

    @Test
    public void playsInCenterWhenGoesSecond() throws Exception {
        Board board = new Board(new String[]{"X","-","-","-","-","-","-","-","-"});
        Integer move = minimax.minimax(board, null, 0)[1];
        assertEquals(new Integer(5), move);
    }
}
