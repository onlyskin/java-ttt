package ttt;

import java.io.IOException;
import java.util.List;

public class CliMenuSpy extends CliMenu {
    public boolean displayMenuCalled;
    private List<Command> commands;
    
    public CliMenuSpy(List<Command> commands) {
        super(null, commands);
        this.commands = commands;
        this.displayMenuCalled = false;
    }

    @Override
    public void displayMenu() throws IOException {
        displayMenuCalled = true;
        commands.get(0).execute();
    }
}
