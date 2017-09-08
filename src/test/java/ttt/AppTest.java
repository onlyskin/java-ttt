package ttt;

import org.junit.Test;
import org.junit.Ignore;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AppTest {
    @Test
    public void appCallsDisplayMenuOnCliMenu() throws Exception {
        CliMenuSpy cliMenuSpy = new CliMenuSpy();
        App app = new App(null, cliMenuSpy);
        app.run();
        assertTrue(cliMenuSpy.displayMenuCalled);
    }

    // I don't know why this is working!
    @Test
    public void appExitsWhenExitCommandMatches() throws Exception {
        Ui ui = makeUiWithInputStream("0\n");
        List<Command> commands = new ArrayList();
        CliMenu cliMenu = new CliMenu(ui, commands);
        App app = new App(ui, cliMenu);
        commands.add(new ExitCommand(app, ui));
        app.run();
    }

    @Ignore
    @Test
    public void callsGetInputOnUi() throws Exception {
        UiSpy uiSpy = new UiSpy("");
        App app = new App(uiSpy, null);
        app.run();
        assertTrue(uiSpy.getInputCalled);
    }

    private Ui makeUiWithInputStream(String input) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(out);
        PlayerFactorySpy playerFactorySpy = new PlayerFactorySpy();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        return new Ui(reader, printStream, playerFactorySpy);
    }
}
