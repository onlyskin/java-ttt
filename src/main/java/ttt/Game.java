package ttt;

import java.io.PrintStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Game {
    Ui ui;
    Player[] players;
    int turn;

    public Game(Ui ui, Player[] players) {
        this.ui = ui;
        this.players = players;
        turn = 0;
    }

    private void runStartDisplay(Board b) {
        ui.printBoard(b);
    }
    
    private void runEndDisplay(Board b) {
        if (b.isTie(players)) {
            ui.printMessage("tie");
        } else if (b.isWinner(players[0])) {
            ui.printWinner(players[0]);
        } else {
            ui.printWinner(players[1]);
        }
    }

    public void start() throws IOException, NumberFormatException {
        Board b = new Board();
        runStartDisplay(b);
        while (!b.gameOver(players)) {
            Integer position = players[turn % 2].getMove(b);
            b = b.play(position, players[turn % 2]);
            ui.printBoard(b);
            turn++;
        }
        runEndDisplay(b);
    }
}
