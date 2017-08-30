package ttt;

import java.io.PrintStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class App {
    Ui ui;

    public App(Ui ui) {
        this.ui = ui;
    }

    public void start() {
        ui.printMessage("start");
    }
    
    public void end() {
        ui.printMessage("end");
    }

    private void runGame() throws IOException {
        Game game = new Game(ui);
        game.start();
    }

    private void run() throws IOException {
        start();
        runGame();
        end();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Ui ui = new Ui(reader, System.out);
        App app = new App(ui);
        app.run();
    }
}
