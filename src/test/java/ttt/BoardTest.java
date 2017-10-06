package ttt;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;
import java.util.Arrays;

public class BoardTest {
    PlayerStub playerStubX = new PlayerStub("X");
    PlayerStub playerStubO = new PlayerStub("O");
    Player[] players = new Player[]{playerStubX, playerStubO};

    @Test
    public void isWinnerReturnsFalse0() throws Exception {
        Board board = new Board();
        assertFalse(board.isWinner(players[0].getMarker()));
    }

    @Test
    public void isWinnerReturnsTrue0() throws Exception {
        Board board = new Board(new String[]{"X","X","X","-","-","-","-","-","-"});
        assertTrue(board.isWinner(players[0].getMarker()));
    }

    @Test
    public void isWinnerReturnsFalse1() throws Exception {
        Board board = new Board(new String[]{"X","-","X","-","-","-","-","-","-"});
        assertFalse(board.isWinner(players[0].getMarker()));
    }

    @Test
    public void isWinnerReturnsFalse2() throws Exception {
        Board board = new Board(new String[]{"-","-","X","-","-","X","-","-","-"});
        assertFalse(board.isWinner(players[0].getMarker()));
    }

    @Test
    public void isWinnerReturnsTrue1() throws Exception {
        Board board = new Board(new String[]{"-","-","X","-","-","X","-","-","X"});
        assertTrue(board.isWinner(players[0].getMarker()));
    }

    @Test
    public void isWinnerReturnsTrue2() throws Exception {
        Board board = new Board(new String[]{"-","-","X","-","X","-","X","-","-"});
        assertTrue(board.isWinner(players[0].getMarker()));
    }

    @Test
    public void isWinnerReturnsTrue3() throws Exception {
        Board board = new Board(new String[]{"X","-","-","-","X","-","-","-","X"});
        assertTrue(board.isWinner(players[0].getMarker()));
    }

    @Test
    public void isWinnerHandlesO() throws Exception {
        Board board = new Board(new String[]{"O","-","-","-","O","-","-","-","O"});
        assertTrue(board.isWinner(players[1].getMarker()));
    }

    @Test
    public void isTieReturnsFalse0() throws Exception {
        Board board = new Board(new String[]{"O","-","-","-","O","-","-","-","O"});
        assertFalse(board.isTie());
    }

    @Test
    public void isTieReturnsFalse1() throws Exception {
        Board board = new Board(new String[]{"O","X","O","-","-","-","-","-","-"});
        assertFalse(board.isTie());
    }

    @Test
    public void isTieReturnsFalse2() throws Exception {
        Board board = new Board(new String[]{"O","X","O","O","X","X","O","O","X"});
        assertFalse(board.isTie());
    }

    @Test
    public void isTieReturnsTrue() throws Exception {
        Board board = new Board(new String[]{"O","X","O","O","X","X","X","O","O"});
        assertTrue(board.isTie());
    }

    @Test
    public void gameOverReturnsTrue0() throws Exception {
        Board board = new Board(new String[]{"O","-","-","-","O","-","-","-","O"});
        assertTrue(board.gameOver());
    }

    @Test
    public void gameOverReturnsFalse0() throws Exception {
        Board board = new Board(new String[]{"O","X","O","-","-","-","-","-","-"});
        assertFalse(board.gameOver());
    }

    @Test
    public void gameOverReturnsTrue1() throws Exception {
        Board board = new Board(new String[]{"O","X","O","O","X","X","O","O","X"});
        assertTrue(board.gameOver());
    }

    @Test
    public void gameOverReturnsTrue2() throws Exception {
        Board board = new Board(new String[]{"O","X","O","O","X","X","X","O","O"});
        assertTrue(board.gameOver());
    }

    @Test
    public void playsInEmptyCell() throws Exception {
        Board board0 = new Board(new String[]{"O","-","-","-","-","-","-","-","-"});
        Board board1 = board0.play(2, players[0].getMarker());
        assertEquals("O", board1.getCell(1));
        assertEquals("X", board1.getCell(2));
    }

    @Test
    public void leavesOriginalBoardCellsUnchanged() throws Exception {
        Board board0 = new Board(new String[]{"-","-","-","-","-","X","-","-","-"});
        Board board1 = board0.play(9, players[1].getMarker());
        assertEquals("O", board1.getCell(9));
        assertEquals("-", board0.getCell(9));
    }
    
    @Test
    public void playsInCorrectCell() throws Exception {
        Board board0 = new Board(new String[]{"-","-","-","-","-","X","-","-","-"});
        Board board1 = board0.play(9, players[1].getMarker());
        assertEquals("O", board1.getCell(9));
    }
    
    @Test
    public void returnsSameBoardifCellTaken() throws Exception {
        Board board = new Board(new String[]{"O","-","-","-","-","-","-","-","-"});
        assertEquals(board, board.play(1, players[0].getMarker()));
    }
    
    @Test
    public void isFree() throws Exception {
        Board board = new Board(new String[]{"O","-","-","-","-","-","-","-","-"});
        assertFalse(board.isFree(1));
        assertTrue(board.isFree(2));
    }

    @Test
    public void moveIsInvalidIfOutOfRange() throws Exception {
        Board board = new Board(new String[]{"-","-","-","-","-","X","-","-","-"});
        assertFalse(board.isValidMove(0));
        assertFalse(board.isValidMove(46));
    }
    
    @Test
    public void moveIsValidIfFree() throws Exception {
        Board board = new Board(new String[]{"-","-","-","-","-","X","-","-","-"});
        assertTrue(board.isValidMove(5));
    }
    
    @Test
    public void moveIsInvalidIfNotFree() throws Exception {
        Board board = new Board(new String[]{"-","-","-","-","-","X","-","-","-"});
        assertFalse(board.isValidMove(6));
    }

    @Test
    public void getsAvailableMoves() throws Exception {
        Board board = new Board(new String[]{"X","X","X","-","-","O","O","-","-"});
        Integer[] moves = board.getAvailableMoves();
        Integer[] expected = new Integer[]{4, 5, 8, 9};
        assertTrue(Arrays.equals(expected, moves));
    }

    @Test
    public void getsNextMarker() throws Exception {
        Board board = new Board(new String[]{"O","X","O","-","-","O","X","-","X"});
        assertEquals("X", board.getNextMarker());
    }

    @Test
    public void getsNextMarker2() throws Exception {
        Board board = new Board(new String[]{"X","X","-","O","-","-","-","-","-"});
        assertEquals("O", board.getNextMarker());
    }
}
