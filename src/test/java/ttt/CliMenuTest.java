package ttt;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;
import java.io.IOException;

public class CliMenuTest {
    UiSpy uiSpy = new UiSpy("1\n0\n");
    List<Command> commands = new ArrayList();
    CliMenu cliMenu;
    CommandStub command0 = new CommandStub("first");
    CommandStub command1 = new CommandStub("second");

    @Test
    public void itCallsPrintMessageOnUiSpyWithCliMenuUntilValidResponse() throws Exception {
        List<Command> commands = new ArrayList();
        commands.add(command0);
        cliMenu = new CliMenu(uiSpy, commands);
        cliMenu.displayMenu();
        assertEquals(new Integer(2), uiSpy.printMessageCalledWithCliMenuCount);
    }

    @Test
    public void itPrintsTwoMenuChoices() throws Exception {
        makeCliMenu();
        assertEquals("first", uiSpy.printMenuChoiceCalledWith.get(0));
        assertEquals("second", uiSpy.printMenuChoiceCalledWith.get(1));
    }

    @Test
    public void itCallsGetIntegerOnUiSpy() throws Exception {
        makeCliMenu();
        assertTrue(uiSpy.getIntegerCalled);
    }

    @Test
    public void itCallsExecuteOn1stCommand() throws Exception {
        makeCliMenu();
        assertTrue(command1.executeCalled);
    }

    public void makeCliMenu() throws IOException {
        commands.add(command0);
        commands.add(command1);
        cliMenu = new CliMenu(uiSpy, commands);
        cliMenu.displayMenu();
    }
}
