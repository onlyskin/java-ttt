package ttt;

import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class PlayCommandTest {
    private final UiSpy uiSpy = new UiSpy("");
    private final GameFactorySpy gameFactorySpy = new GameFactorySpy();
    private final PlayerFactorySpy playerFactorySpy = new PlayerFactorySpy();
    private final PlayCommand playCommand = new PlayCommand(uiSpy, gameFactorySpy,
            playerFactorySpy);

    @Test
    public void makesAndStartsGame() throws Exception {
        playCommand.execute();
        assertEquals(new Integer(1), gameFactorySpy.makeGameCallCount);
        assertTrue(gameFactorySpy.gameSpy.startCalled);
    }

    @Test
    public void respondsToUiString() throws Exception {
        assertTrue(playCommand.respondsTo(uiSpy.getMessage("playAppCommand")));
    }

    @Test
    public void callsMakePlayerTwiceOnPlayerFactoryWithCorrectInputs() throws Exception {
        Ui ui = makeUiWithInputStream("h\nc\n");
        PlayCommand playCommand = new PlayCommand(ui, gameFactorySpy, playerFactorySpy);
        playCommand.execute();
        assertEquals(new Integer(2), playerFactorySpy.makePlayerCalledCount);
        assertEquals("human", playerFactorySpy.calledWithType.get(0));
        assertEquals("computer", playerFactorySpy.calledWithType.get(1));
    }

    @Test
    public void callsGetPlayerTypeOnUiTwice() throws Exception {
        playCommand.execute();
        assertEquals(new Integer(2), uiSpy.getPlayerTypeCalledCount);
    }

    private Ui makeUiWithInputStream(String input) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(out);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        return new Ui(reader, printStream);
    }
}
