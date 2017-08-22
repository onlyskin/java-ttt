package ttt;

import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;

public class BoardTest {
    @Test
    public void wonReturnsFalse0() {
        Board b = new Board();
        assertFalse(b.won("X"));
    }

    @Test
    public void wonReturnsTrue0() {
        Board b = new Board(new String[][]{{"X","X","X"},{"-","-","-"},{"-","-","-"}});
        assertTrue(b.won("X"));
    }

    @Test
    public void wonReturnsFalse1() {
        Board b = new Board(new String[][]{{"X","-","X"},{"-","-","-"},{"-","-","-"}});
        assertFalse(b.won("X"));
    }

    @Test
    public void wonReturnsFalse2() {
        Board b = new Board(new String[][]{{"-","-","X"},{"-","-","X"},{"-","-","-"}});
        assertFalse(b.won("X"));
    }

    @Test
    public void wonReturnsTrue1() {
        Board b = new Board(new String[][]{{"-","-","X"},{"-","-","X"},{"-","-","X"}});
        assertTrue(b.won("X"));
    }

    @Test
    public void wonReturnsTrue2() {
        Board b = new Board(new String[][]{{"-","-","X"},{"-","X","-"},{"X","-","-"}});
        assertTrue(b.won("X"));
    }

    @Test
    public void wonReturnsTrue3() {
        Board b = new Board(new String[][]{{"X","-","-"},{"-","X","-"},{"-","-","X"}});
        assertTrue(b.won("X"));
    }

    @Test
    public void wonHandlesO() {
        Board b = new Board(new String[][]{{"O","-","-"},{"-","O","-"},{"-","-","O"}});
        assertTrue(b.won("O"));
    }
}
