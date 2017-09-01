package ttt;

import org.junit.Test;
import static org.junit.Assert.*;

public class BadCommandTest {
    private final UiSpy uiSpy = new UiSpy("");
    private final BadCommand badCommand = new BadCommand(uiSpy);

    @Test
    public void tellsUiToPrintInvalidCommand() throws Exception {
        badCommand.execute();
        assertTrue(uiSpy.printMessageCalledWithInvalidCommand);
    }
}
