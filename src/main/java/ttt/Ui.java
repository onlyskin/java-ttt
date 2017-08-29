package ttt;

import java.io.PrintStream;

import java.util.Map;
import java.util.HashMap;

public class Ui {
    private final PrintStream printStream;
    private final Map<String, String> messages = new HashMap<>();

    public Ui(PrintStream printStream) {
        this.printStream = printStream;
        messages.put("start", "start");
        messages.put("tie", "a tie");
    }

    public void printBoard(Board board) {
        String output = ""; 
        for (int i=0;i<9;i++) {
            output = output + board.getCell(i);
            if (i % 3 == 2) output = output + "\n";
        }
        printStream.println(output);
    }

    public void printMessage(String id) {
        String output = messages.get(id);
        printStream.println(output);
    }

    public void printWinner(String marker) {
        printStream.println(marker + " won");
    }
}
