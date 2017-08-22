package ttt;

import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;

public class BoardTest {
    @Test
    public void xWonReturnsFalse0() {
        Board b = new Board();
        assertFalse(b.xWon());
    }

    @Test
    public void xWonReturnsTrue0() {
        Board b = new Board(new String[][]{{"X","X","X"},{"-","-","-"},{"-","-","-"}});
        assertTrue(b.xWon());
    }

    @Test
    public void xWonReturnsFalse1() {
        Board b = new Board(new String[][]{{"X","-","X"},{"-","-","-"},{"-","-","-"}});
        assertFalse(b.xWon());
    }

    @Test
    public void xWonReturnsFalse2() {
        Board b = new Board(new String[][]{{"-","-","X"},{"-","-","X"},{"-","-","-"}});
        assertFalse(b.xWon());
    }

    @Test
    public void xWonReturnsTrue1() {
        Board b = new Board(new String[][]{{"-","-","X"},{"-","-","X"},{"-","-","X"}});
        assertTrue(b.xWon());
    }

    @Test
    public void xWonReturnsTrue2() {
        Board b = new Board(new String[][]{{"-","-","X"},{"-","X","-"},{"X","-","-"}});
        assertTrue(b.xWon());
    }

    @Test
    public void xWonReturnsTrue3() {
        Board b = new Board(new String[][]{{"X","-","-"},{"-","X","-"},{"-","-","X"}});
        assertTrue(b.xWon());
    }
}
