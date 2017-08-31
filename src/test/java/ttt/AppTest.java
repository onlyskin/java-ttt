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
    public void tellsUiToDisplayInvalidAppCommandMessage() throws Exception {
        uiSpy = new UiSpy("invalid\nexit");
        new App(uiSpy, null).run();
        assertTrue(uiSpy.printMessageCalledWithInvalidAppCommand);
    }

    @Test
    public void callsCorrectMessagesAndPlaysTwoGames() throws Exception {
        uiSpy = new UiSpy("play\nplay\nexit\n");
        new App(uiSpy, gameFactorySpy).run();
        assertTrue(uiSpy.printMessageCalledWithWelcome);
        assertTrue(uiSpy.printMessageCalledWithGoodbye);
        assertTrue(uiSpy.getInputCalled);
        assertEquals(new Integer(2), gameFactorySpy.makeGameCallCount);
        assertEquals(new Integer(3), uiSpy.appMenuCallCount);
        assertTrue(gameFactorySpy.gameSpy.startCalled);
    }
}
