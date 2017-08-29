package ttt;

import java.io.PrintStream;
import java.io.BufferedReader;
import java.io.IOException;

import java.util.Map;
import java.util.HashMap;
import java.lang.Integer;

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

    private String cellString(int i, Board board) {
        if (board.getCell(i)=="-") {
            return Integer.toString(i);
        }
        return board.getCell(i);
    }

    public String getBoardString(Board board) {
        String output = "┌───┬───┬───┐\n│ " +
            cellString(0, board) + " │ " +
            cellString(1, board) + " │ " +
            cellString(2, board) + " │\n│───│───│───│\n│ " +
            cellString(3, board) + " │ " +
            cellString(4, board) + " │ " +
            cellString(5, board) + " │\n│───│───│───│\n│ " +
            cellString(6, board) + " │ " +
            cellString(7, board) + " │ " +
            cellString(8, board) + " │\n└───┴───┴───┘";
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
