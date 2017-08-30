package ttt;

import java.io.PrintStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Game {
    Ui ui;
    String[] players;
    int turn;

    public Game(Ui ui) {
        this.ui = ui;
        players = new String[]{"X", "O"};
        turn = 0;
    }

    private void runStartDisplay(Board b) {
        ui.printBoard(b);
    }
    
    private void runEndDisplay(Board b) {
        if (b.tie()) ui.printMessage("tie");
        else if (b.won("X")) ui.printWinner("X");
        else ui.printWinner("O");
    }

    public void start() throws IOException, NumberFormatException {
        Board b = new Board();
        runStartDisplay(b);
        while (!b.gameOver()) {
            Integer position = ui.getMove(b);
            b = b.play(position, players[turn % 2]);
            ui.printBoard(b);
            turn++;
        }
        runEndDisplay(b);
    }
}
