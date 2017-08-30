package ttt;

import java.io.PrintStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class App {
    Ui ui;
    GameFactory gameFactory;

    public App(Ui ui, GameFactory gameFactory) {
        this.ui = ui;
        this.gameFactory = gameFactory;
    }

    private void start() {
        ui.printMessage("welcome");
    }
    
    private void end() {
        ui.printMessage("goodbye");
    }

    private void runGame() throws IOException {
        Game game = new Game(ui);
        game.start();
    }

    public void run() throws IOException {
        start();
        // String line = ui.getInput();
        Game game = gameFactory.makeGame(ui);
        game.start();
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
