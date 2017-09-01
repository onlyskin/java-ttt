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

    private List<Command> buildCommands() {
        return Arrays.asList(
                new PlayCommand(ui, gameFactory),
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

    private void start() {
        this.running = true;
        ui.printMessage("welcome");
        ui.printMessage("appMenu");
    }
    
    private void end() {
        ui.printMessage("goodbye");
    }

    public void exit() {
        running = false;
    }

    private void handleInput(String line) throws IOException {
        Command command = findCommand(line);
        command.execute();
    }
    
    private void acceptInput() {
        try {
            String line = ui.getInput();
            handleInput(line);
        }
        catch (IOException e) {}
    }

    public void run() throws IOException {
        start();
        while (running) {
            acceptInput();
        }
        end();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Ui ui = new Ui(reader, System.out);
        GameFactory gameFactory = new GameFactory();
        App app = new App(ui, gameFactory);
        app.run();
    }
}
