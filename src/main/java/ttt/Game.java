package ttt;

import java.io.IOException;

public class Game {
    private final Ui ui;
    private final Player[] players;
    private int turn;

    public Game(Ui ui, Player[] players) {
        this.ui = ui;
        this.players = players;
        this.turn = 0;
    }

    public void start() throws IOException, NumberFormatException {
        Board b = new Board(new String[]{"-","-","-","-","-","-","-","-","-"});
        runStartDisplay(b);
        while (!b.gameOver(players)) {
            Integer position = players[turn % 2].getMove(b);
            b = b.play(position, players[turn % 2]);
            ui.printBoard(b);
            turn++;
        }
        runEndDisplay(b);
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
}
