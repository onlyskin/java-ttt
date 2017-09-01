package ttt;

import java.io.PrintStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class App {
    Ui ui;
    GameFactory gameFactory;
    boolean running;
    PlayCommand playCommand;
    ExitCommand exitCommand;
    BadCommand badCommand;

    public App(Ui ui, GameFactory gameFactory) {
        this.ui = ui;
        this.gameFactory = gameFactory;
        this.running = false;
        this.playCommand = new PlayCommand(ui, gameFactory);
        this.exitCommand = new ExitCommand(this, ui);
        this.badCommand = new BadCommand(ui);
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
        if (line.equals(ui.getMessage("playAppCommand"))) {
            playCommand.execute();
        } else if (line.equals(ui.getMessage("exitAppCommand"))) {
            exitCommand.execute();
        } else {
            badCommand.execute();
        }
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
