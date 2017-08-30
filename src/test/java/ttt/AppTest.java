package ttt;

import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;

public class AppTest {
    UiSpy uiSpy = new UiSpy();
    GameFactorySpy gameFactorySpy = new GameFactorySpy();
    App app = new App(uiSpy, gameFactorySpy);

    @Test
    public void tellsUiToDisplayStartMessage() throws Exception {
        app.run();
        assertTrue(uiSpy.printMessageCalledWithWelcome);
    }

    @Test
    public void tellsUiToDisplayEndMessage() throws Exception {
        app.run();
        assertTrue(uiSpy.printMessageCalledWithGoodbye);
    }

    @Ignore
    @Test
    public void callsGetInputOnUi() throws Exception {
        app.run();
        assertTrue(uiSpy.getInputCalled);
    }

    @Test
    public void callsMakeGameOnGameFactorySpyAndStartsTheGame() throws Exception {
        app.run();
        assertTrue(gameFactorySpy.makeGameCalled);
        assertTrue(gameFactorySpy.gameSpy.startCalled);
    }
}
