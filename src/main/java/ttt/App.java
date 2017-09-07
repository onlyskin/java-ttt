package ttt;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;

public class App {
    private final Ui ui;
    
    public App(Ui ui) {
        this.ui = ui;
    }

    public void run() throws IOException {
        ui.getInput();
    };

    public void exit() {};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PlayerFactory playerFactory = new PlayerFactory();
        GameFactory gameFactory = new GameFactory();
        Ui ui = new Ui(reader, System.out, playerFactory);
        App app = new App(ui);
        List<Command> commands = new ArrayList();
        commands.add(new PlayCommand(ui, gameFactory, playerFactory));
        commands.add(new ExitCommand(app, ui));
        CliMenu cliMenu = new CliMenu(ui, commands);
        cliMenu.displayMenu();
    }
}
