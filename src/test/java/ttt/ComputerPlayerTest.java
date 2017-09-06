package ttt;

import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;

public class ComputerPlayerTest {
    RandomSpy randomSpy = new RandomSpy();
    ComputerPlayer computerPlayer = new ComputerPlayer("O", randomSpy);

    @Test
    public void hasMarker() throws Exception {
        assertEquals(computerPlayer.getMarker(), "O");
    }

    @Test
    public void callsNextIntOnRandomWith9() throws Exception {
        computerPlayer.getMove(new Board());
        assertTrue(randomSpy.nextIntCalledWith9);
    }
}
