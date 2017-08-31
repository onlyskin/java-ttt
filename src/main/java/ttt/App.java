package ttt;

import java.io.PrintStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class App {
    Ui ui;
    GameFactory gameFactory;
    boolean running;

    public App(Ui ui, GameFactory gameFactory) {
        this.ui = ui;
        this.gameFactory = gameFactory;
        this.running = false;
    }

    private void start() {
        this.running = true;
        ui.printMessage("welcome");
        ui.printMessage("appMenu");
    }
    
    private void end() {
        ui.printMessage("goodbye");
    }

    private void runGame() throws IOException {
        HumanPlayer humanPlayer1 = new HumanPlayer("X", ui);
        HumanPlayer humanPlayer2 = new HumanPlayer("O", ui);
        Player[] players = new Player[]{humanPlayer1, humanPlayer2};
        Game game = gameFactory.makeGame(ui, players);
        game.start();
    }

    private void handleInput(String line) throws IOException {
        if (line.equals(ui.getMessage("playAppCommand"))) {
            runGame();
            ui.printMessage("appMenu");
        } else if (line.equals(ui.getMessage("exitAppCommand"))) {
            running = false;
        } else {
            ui.printMessage("invalidAppCommand");
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
