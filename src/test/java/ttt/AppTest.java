package ttt;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AppTest {
    @Test
    public void appCallsDisplayMenuOnCliMenu() throws Exception {
        List<Command> commands = new ArrayList();
        CliMenuSpy cliMenuSpy = new CliMenuSpy(commands);
        App app = new App(null, cliMenuSpy);
        commands.add(new ExitCommand(app, null));
        app.run();
        assertTrue(cliMenuSpy.displayMenuCalled);
    }

    @Test
    public void appExitsWhenExitCommandMatches() throws Exception {
        Ui ui = makeUiWithInputStream("0\n");
        List<Command> commands = new ArrayList();
        CliMenu cliMenu = new CliMenu(ui, commands);
        App app = new App(ui, cliMenu);
        commands.add(new ExitCommand(app, ui));
        app.run();
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
