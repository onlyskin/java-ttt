package ttt;

import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;

public class BoardTest {
    @Test
    public void wonReturnsFalse0() throws Exception {
        Board b = new Board();
        assertFalse(b.won("X"));
    }

    @Test
    public void wonReturnsTrue0() throws Exception {
        Board b = new Board(new String[][]{{"X","X","X"},{"-","-","-"},{"-","-","-"}});
        assertTrue(b.won("X"));
    }

    @Test
    public void wonReturnsFalse1() throws Exception {
        Board b = new Board(new String[][]{{"X","-","X"},{"-","-","-"},{"-","-","-"}});
        assertFalse(b.won("X"));
    }

    @Test
    public void wonReturnsFalse2() throws Exception {
        Board b = new Board(new String[][]{{"-","-","X"},{"-","-","X"},{"-","-","-"}});
        assertFalse(b.won("X"));
    }

    @Test
    public void wonReturnsTrue1() throws Exception {
        Board b = new Board(new String[][]{{"-","-","X"},{"-","-","X"},{"-","-","X"}});
        assertTrue(b.won("X"));
    }

    @Test
    public void wonReturnsTrue2() throws Exception {
        Board b = new Board(new String[][]{{"-","-","X"},{"-","X","-"},{"X","-","-"}});
        assertTrue(b.won("X"));
    }

    @Test
    public void wonReturnsTrue3() throws Exception {
        Board b = new Board(new String[][]{{"X","-","-"},{"-","X","-"},{"-","-","X"}});
        assertTrue(b.won("X"));
    }

    @Test
    public void wonHandlesO() throws Exception {
        Board b = new Board(new String[][]{{"O","-","-"},{"-","O","-"},{"-","-","O"}});
        assertTrue(b.won("O"));
    }

    @Test
    public void tieReturnsFalse0() throws Exception {
        Board b = new Board(new String[][]{{"O","-","-"},{"-","O","-"},{"-","-","O"}});
        assertFalse(b.tie());
    }

    @Test
    public void tieReturnsFalse1() throws Exception {
        Board b = new Board(new String[][]{{"O","X","O"},{"-","-","-"},{"-","-","-"}});
        assertFalse(b.tie());
    }

    @Test
    public void tieReturnsFalse2() throws Exception {
        Board b = new Board(new String[][]{{"O","X","O"},{"O","X","X"},{"O","O","X"}});
        assertFalse(b.tie());
    }

    @Test
    public void tieReturnsTrue() throws Exception {
        Board b = new Board(new String[][]{{"O","X","O"},{"O","X","X"},{"X","O","O"}});
        assertTrue(b.tie());
    }

    @Test
    public void gameOverReturnsTrue0() throws Exception {
        Board b = new Board(new String[][]{{"O","-","-"},{"-","O","-"},{"-","-","O"}});
        assertTrue(b.gameOver());
    }

    @Test
    public void gameOverReturnsFalse0() throws Exception {
        Board b = new Board(new String[][]{{"O","X","O"},{"-","-","-"},{"-","-","-"}});
        assertFalse(b.gameOver());
    }

    @Test
    public void gameOverReturnsTrue1() throws Exception {
        Board b = new Board(new String[][]{{"O","X","O"},{"O","X","X"},{"O","O","X"}});
        assertTrue(b.gameOver());
    }

    @Test
    public void gameOverReturnsTrue2() throws Exception {
        Board b = new Board(new String[][]{{"O","X","O"},{"O","X","X"},{"X","O","O"}});
        assertTrue(b.gameOver());
    }

    @Test
    public void playsInEmptyCell() throws Exception {
        Board b0 = new Board(new String[][]{{"O","-","-"},{"-","-","-"},{"-","-","-"}});
        Board b1 = b0.play(0, 1, "X");
        assertEquals("O", b1.getCell(0, 0));
        assertEquals("X", b1.getCell(0, 1));
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void raisesErrorIfCellTaken() {
        Board b0 = new Board(new String[][]{{"O","-","-"},{"-","-","-"},{"-","-","-"}});
        b0.play(0, 0, "X");
    }

}
