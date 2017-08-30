package ttt;

import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;

public class AppTest {
    @Test
    public void tellsUiToDisplayStartMessage() throws Exception {
        UiSpy uiSpy = new UiSpy();
        App app = new App(uiSpy);
        app.start();
        assertEquals("start", uiSpy.printMessageCalledWith);
    }

    @Test
    public void tellsUiToDisplayEndMessage() throws Exception {
        UiSpy uiSpy = new UiSpy();
        App app = new App(uiSpy);
        app.end();
        assertEquals("end", uiSpy.printMessageCalledWith);
    }
}
