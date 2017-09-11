package ttt;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AppTest {
    @Test
    public void appCallsDisplayMenuOnCliMenu() throws Exception {
        UiStub uiStub = new UiStub();
        List<Command> commands = new ArrayList();
        CliMenuSpy cliMenuSpy = new CliMenuSpy(commands);
        App app = new App(uiStub, cliMenuSpy);
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

    @Test
    public void appCallsUiPrintMessageWithWelcome() throws Exception {
        UiSpy uiSpy = new UiSpy("0\n");
        List<Command> commands = new ArrayList();
        CliMenu cliMenu = new CliMenu(uiSpy, commands);
        App app = new App(uiSpy, cliMenu);
        commands.add(new ExitCommand(app, uiSpy));
        app.run();
        assertTrue(uiSpy.printMessageCalledWithWelcome);
    }

    @Test
    public void appCallsUiPrintMessageWithGoodbye() throws Exception {
        UiSpy uiSpy = new UiSpy("0\n");
        List<Command> commands = new ArrayList();
        CliMenu cliMenu = new CliMenu(uiSpy, commands);
        App app = new App(uiSpy, cliMenu);
        commands.add(new ExitCommand(app, uiSpy));
        app.run();
        assertTrue(uiSpy.printMessageCalledWithGoodbye);
    }

    private Ui makeUiWithInputStream(String input) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(out);
        PlayerFactorySpy playerFactorySpy = new PlayerFactorySpy();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        return new Ui(reader, printStream);
    }
}
