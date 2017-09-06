package ttt;

import java.util.Arrays;
import java.util.List;

import java.io.PrintStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class App {
    Ui ui;
    GameFactory gameFactory;
    boolean running;
    private List<Command> commands;

    public App(Ui ui, GameFactory gameFactory) {
        this.ui = ui;
        this.gameFactory = gameFactory;
        this.running = false;
        this.commands = buildCommands();
    }

    public void run() throws IOException {
        start();
        while (running) {
            acceptInput();
        }
        end();
    }

    private void start() {
        this.running = true;
        ui.printMessage("welcome");
        ui.printMessage("appMenu");
    }
    
    private void end() {
        ui.printMessage("goodbye");
    }

    private void acceptInput() {
        try {
            String line = ui.getInput();
            handleInput(line);
        }
        catch (IOException e) {}
    }

    private void handleInput(String line) throws IOException {
        findCommand(line).execute();
    }
    
    private List<Command> buildCommands() {
        return Arrays.asList(
                new PlayCommand(ui, gameFactory, new PlayerFactory()),
                new ExitCommand(this, ui),
                new BadCommand(ui));
    }

    private Command findCommand(String input) {
        for (Command c : commands) {
            if (c.respondsTo(input)) {
                return c;
            }
        }
        return null;
    }

    public void exit() {
        running = false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PlayerFactory playerFactory = new PlayerFactory();
        Ui ui = new Ui(reader, System.out, playerFactory);
        GameFactory gameFactory = new GameFactory();
        App app = new App(ui, gameFactory);
        app.run();
    }
}
