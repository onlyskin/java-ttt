package ttt;

import java.io.PrintStream;
import java.io.BufferedReader;
import java.io.IOException;

import java.util.Map;
import java.util.HashMap;

public class Ui {
    private final PrintStream printStream;
    private final BufferedReader reader;
    private final Map<String, String> messages = new HashMap<>();

    public Ui(BufferedReader reader, PrintStream printStream) {
        this.reader = reader;
        this.printStream = printStream;
        messages.put("start", "start");
        messages.put("tie", "a tie");
    }

    public String getBoardString(Board board) {
        String output = ""; 
        for (int i=0;i<9;i++) {
            output = output + board.getCell(i);
            if (i % 3 == 2) output = output + "\n";
        }
        return output;
    }

    public void printBoard(Board board) {
        printStream.println(getBoardString(board));
    }

    public void printMessage(String id) {
        String output = messages.get(id);
        printStream.println(output);
    }

    public void printWinner(String marker) {
        printStream.println(marker + " won");
    }
    
    public String getInput() throws IOException {
        return reader.readLine();
    }
}
