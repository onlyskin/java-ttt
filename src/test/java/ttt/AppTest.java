package ttt;

import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {
    @Test
    public void callsGetInputOnUi() throws Exception {
        UiSpy uiSpy = new UiSpy("");
        App app = new App(uiSpy);
        app.run();
        assertTrue(uiSpy.getInputCalled);
    }
}
