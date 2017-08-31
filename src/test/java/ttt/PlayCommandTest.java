package ttt;

import org.junit.Test;
import static org.junit.Assert.*;

public class PlayCommandTest {
    private final UiSpy uiSpy = new UiSpy("");
    private final GameFactorySpy gameFactorySpy = new GameFactorySpy();
    private final PlayCommand playCommand = new PlayCommand(uiSpy, gameFactorySpy);

    @Test
    public void makesAndStartsGame() throws Exception {
        playCommand.execute();
        assertEquals(new Integer(1), gameFactorySpy.makeGameCallCount);
        assertTrue(gameFactorySpy.gameSpy.startCalled);
        assertEquals(new Integer(1), uiSpy.appMenuCallCount);
    }

    @Test
    public void RespondsToUiString() throws Exception {
        assertTrue(playCommand.respondsTo(uiSpy.getMessage("playAppCommand")));
    }
}
