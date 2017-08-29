package ttt;

import java.io.PrintStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Game {
    BufferedReader reader;
    PrintStream printStream;
    boolean running;
    String[] players;
    int turn;

    public Game(BufferedReader reader, PrintStream printStream) {
        this.reader = reader;
        this.printStream = printStream;
        this.running = false;
        players = new String[]{"X", "O"};
        turn = 0;
    }

    private void printBoard(Board board) {
        String output = ""; 
        for (int i=0;i<9;i++) {
            output = output + board.getCell(i);
            if (i % 3 == 2) output = output + "\n";
        }
        printStream.println(output);
    }
    
    private void printStartMessage(Board b) {
        printStream.println("start");
        printBoard(b);
    }
    
    private void printEndMessage(Board b) {
        if (b.tie()) printStream.println("a tie");
        else if (b.won("X")) printStream.println("X won");
        else printStream.println("O won");
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
            printBoard(b);
            turn++;
            if (b.gameOver()) {
                break;
            }
        }
        printEndMessage(b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Game g = new Game(reader, System.out);
        g.start();
    }
}
