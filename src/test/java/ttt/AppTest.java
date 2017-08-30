package ttt;

import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;

import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AppTest {
    UiSpy uiSpy = new UiSpy("exit");
    GameFactorySpy gameFactorySpy = new GameFactorySpy();

    @Test
    public void tellsUiToDisplayStartMessages() throws Exception {
        new App(uiSpy, null).run();
        assertTrue(uiSpy.printMessageCalledWithWelcome);
        assertTrue(uiSpy.printMessageCalledWithGameInstructions);
    }

    @Test
    public void tellsUiToDisplayEndMessage() throws Exception {
        new App(uiSpy, null).run();
        assertTrue(uiSpy.printMessageCalledWithGoodbye);
    }

    @Test
    public void callsGetInputOnUi() throws Exception {
        new App(uiSpy, null).run();
        assertTrue(uiSpy.getInputCalled);
    }

    @Test
    public void tellsUiToDisplayInvalidAppCommandMessage() throws Exception {
        uiSpy = new UiSpy("invalid\nexit");
        new App(uiSpy, null).run();
        assertTrue(uiSpy.printMessageCalledWithInvalidAppCommand);
    }

    @Test
    public void playsTwoGamesByEnteringP() throws Exception {
        InputStream inputStream = new ByteArrayInputStream("play\nplay\nexit\n".getBytes());
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(out);
        Ui ui = new Ui(reader, printStream);
        App app = new App(ui, gameFactorySpy);
        app.run();
        assertEquals(new Integer(2), gameFactorySpy.makeGameCallCount);
        assertTrue(gameFactorySpy.gameSpy.startCalled);
    }
}
