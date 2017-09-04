package ttt;

import org.junit.Test;
import static org.junit.Assert.*;

import java.io.IOException;

public class ExitCommandTest {
    private final AppSpy appSpy = new AppSpy();
    private final Ui ui = new Ui(null, null, null);
    private final ExitCommand exitCommand = new ExitCommand(appSpy, ui);

    public ExitCommandTest() throws IOException {}

    @Test
    public void CallsExitOnApp() throws Exception {
        exitCommand.execute();
        assertTrue(appSpy.exitCalled);
    }

    @Test
    public void RespondsToUiString() throws Exception {
        assertTrue(exitCommand.respondsTo(ui.getMessage("exitAppCommand")));
    }
}
