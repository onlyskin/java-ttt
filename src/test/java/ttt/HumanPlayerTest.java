package ttt;

import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;

public class HumanPlayerTest {

    @Test
    public void RunsGameToEnd() throws Exception {
        UiSpy uiSpy = new UiSpy("3\n");
        HumanPlayer humanPlayer = new HumanPlayer("X", uiSpy);
        assertEquals(humanPlayer.getMarker(), "X");
        humanPlayer.getMove(null);
        assertTrue(uiSpy.getMoveCalled);
    }
}
