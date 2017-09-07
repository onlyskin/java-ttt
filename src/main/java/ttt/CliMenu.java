package ttt;

import java.util.List;
import java.io.IOException;

public class CliMenu {
    private final Ui ui;
    private List<Command> commands;

    public CliMenu(Ui ui, List<Command> commands) {
        this.ui= ui;
        this.commands = commands;
    }

    public void displayMenu() throws IOException {
        ui.printMessage("cliMenu");
        for (int i=0;i<commands.size();i++) {
            ui.printMenuChoice(i, commands.get(i).getTitle());
        }
        Integer choice = ui.getInteger();
        try {
            commands.get(choice).execute();
        } catch (IndexOutOfBoundsException e) {
            displayMenu();
        }
    }
}
