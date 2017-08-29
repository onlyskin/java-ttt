package ttt;

import java.io.PrintStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Game {
    BufferedReader reader;
    Ui ui;
    boolean running;
    String[] players;
    int turn;

    public Game(BufferedReader reader, Ui ui) {
        this.reader = reader;
        this.ui = ui;
        this.running = false;
        players = new String[]{"X", "O"};
        turn = 0;
    }

    private void printStartMessage(Board b) {
        ui.printMessage("start");
        ui.printBoard(b);
    }
    
    private void printEndMessage(Board b) {
        if (b.tie()) ui.printMessage("tie");
        else if (b.won("X")) ui.printWinner("X");
        else ui.printWinner("O");
    }

    public void start() throws IOException, NumberFormatException {
        this.running = true;
        Board b = new Board();
        printStartMessage(b);
        while (running) {
            String line = reader.readLine();
            if (line == null) {
                continue;
            }
            if (line.startsWith("exit")) {
                return;
            }
            int position = Integer.parseInt(line);
            b = b.play(position, players[turn % 2]);
            ui.printBoard(b);
            turn++;
            if (b.gameOver()) {
                break;
            }
        }
        printEndMessage(b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Ui ui = new Ui(System.out);
        Game g = new Game(reader, ui);
        g.start();
    }
}
