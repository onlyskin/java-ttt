package ttt;

import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;

public class BoardTest {
    @Test
    public void wonReturnsFalse0() throws Exception {
        Board board = new Board();
        assertFalse(board.won("X"));
    }

    @Test
    public void wonReturnsTrue0() throws Exception {
        Board board = new Board(new String[][]{{"X","X","X"},{"-","-","-"},{"-","-","-"}});
        assertTrue(board.won("X"));
    }

    @Test
    public void wonReturnsFalse1() throws Exception {
        Board board = new Board(new String[][]{{"X","-","X"},{"-","-","-"},{"-","-","-"}});
        assertFalse(board.won("X"));
    }

    @Test
    public void wonReturnsFalse2() throws Exception {
        Board board = new Board(new String[][]{{"-","-","X"},{"-","-","X"},{"-","-","-"}});
        assertFalse(board.won("X"));
    }

    @Test
    public void wonReturnsTrue1() throws Exception {
        Board board = new Board(new String[][]{{"-","-","X"},{"-","-","X"},{"-","-","X"}});
        assertTrue(board.won("X"));
    }

    @Test
    public void wonReturnsTrue2() throws Exception {
        Board board = new Board(new String[][]{{"-","-","X"},{"-","X","-"},{"X","-","-"}});
        assertTrue(board.won("X"));
    }

    @Test
    public void wonReturnsTrue3() throws Exception {
        Board board = new Board(new String[][]{{"X","-","-"},{"-","X","-"},{"-","-","X"}});
        assertTrue(board.won("X"));
    }

    @Test
    public void wonHandlesO() throws Exception {
        Board board = new Board(new String[][]{{"O","-","-"},{"-","O","-"},{"-","-","O"}});
        assertTrue(board.won("O"));
    }

    @Test
    public void tieReturnsFalse0() throws Exception {
        Board board = new Board(new String[][]{{"O","-","-"},{"-","O","-"},{"-","-","O"}});
        assertFalse(board.tie());
    }

    @Test
    public void tieReturnsFalse1() throws Exception {
        Board board = new Board(new String[][]{{"O","X","O"},{"-","-","-"},{"-","-","-"}});
        assertFalse(board.tie());
    }

    @Test
    public void tieReturnsFalse2() throws Exception {
        Board board = new Board(new String[][]{{"O","X","O"},{"O","X","X"},{"O","O","X"}});
        assertFalse(board.tie());
    }

    @Test
    public void tieReturnsTrue() throws Exception {
        Board board = new Board(new String[][]{{"O","X","O"},{"O","X","X"},{"X","O","O"}});
        assertTrue(board.tie());
    }

    @Test
    public void gameOverReturnsTrue0() throws Exception {
        Board board = new Board(new String[][]{{"O","-","-"},{"-","O","-"},{"-","-","O"}});
        assertTrue(board.gameOver());
    }

    @Test
    public void gameOverReturnsFalse0() throws Exception {
        Board board = new Board(new String[][]{{"O","X","O"},{"-","-","-"},{"-","-","-"}});
        assertFalse(board.gameOver());
    }

    @Test
    public void gameOverReturnsTrue1() throws Exception {
        Board board = new Board(new String[][]{{"O","X","O"},{"O","X","X"},{"O","O","X"}});
        assertTrue(board.gameOver());
    }

    @Test
    public void gameOverReturnsTrue2() throws Exception {
        Board board = new Board(new String[][]{{"O","X","O"},{"O","X","X"},{"X","O","O"}});
        assertTrue(board.gameOver());
    }

    @Test
    public void playsInEmptyCell() throws Exception {
        Board board0 = new Board(new String[][]{{"O","-","-"},{"-","-","-"},{"-","-","-"}});
        Board board1 = board0.play(2, "X");
        assertEquals("O", board1.getCell(1));
        assertEquals("X", board1.getCell(2));
    }

    @Test
    public void playsInCorrectCell() throws Exception {
        Board board0 = new Board(new String[][]{{"-","-","-"},{"-","-","X"},{"-","-","-"}});
        Board board1 = board0.play(9, "O");
        assertEquals("O", board1.getCell(9));
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void raisesErrorIfCellTaken() {
        Board board = new Board(new String[][]{{"O","-","-"},{"-","-","-"},{"-","-","-"}});
        board.play(1, "X");
    }
    
    @Test
    public void isFree() throws Exception {
        Board board = new Board(new String[][]{{"O","-","-"},{"-","-","-"},{"-","-","-"}});
        assertFalse(board.isFree(1));
        assertTrue(board.isFree(2));
    }
}
