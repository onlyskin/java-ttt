package ttt;

import org.junit.Test;
import static org.junit.Assert.*;

public class ComputerPlayerTest {
    MinimaxSpy minimaxSpy = new MinimaxSpy();
    ComputerPlayer computerPlayer = new ComputerPlayer("O", minimaxSpy);

    @Test
    public void hasMarker() throws Exception {
        assertEquals(computerPlayer.getMarker(), "O");
    }

    @Test
    public void callsMinimaxOnMinimax() throws Exception {
        Board board = new Board();
        Integer move = computerPlayer.getMove(board);
        assertTrue(minimaxSpy.minimaxCalled);
        assertEquals(board, minimaxSpy.minimaxFirstArg);
        assertNull(minimaxSpy.minimaxSecondArg);
        assertEquals(new Integer(0), minimaxSpy.minimaxThirdArg);
        assertEquals(new Integer(1), move);
    }
}
