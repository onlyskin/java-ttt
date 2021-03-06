package ttt;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;

public class App {
    private final Ui ui;
    private final CliMenu cliMenu;
    private boolean running;
    
    public App(Ui ui, CliMenu cliMenu) {
        this.ui = ui;
        this.cliMenu = cliMenu;
        this.running = false;
    }

    public void run() throws IOException {
        start();
        running = true;
        while (running) {
            cliMenu.displayMenu();
        }
        end();
    };

    public void exit() {
        running = false;
    };

    private void start() {
        ui.printMessage("welcome");
    }

    private void end() {
        ui.printMessage("goodbye");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PlayerFactory playerFactory = new PlayerFactory();
        GameFactory gameFactory = new GameFactory();
        Ui ui = new Ui(reader, System.out);
        List<Command> commands = new ArrayList();
        CliMenu cliMenu = new CliMenu(ui, commands);
        App app = new App(ui, cliMenu);
        commands.add(new PlayCommand(ui, gameFactory, playerFactory));
        commands.add(new ExitCommand(app, ui));
        app.run();
    }
}
