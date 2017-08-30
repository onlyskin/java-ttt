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
        messages.put("getMove", "Please choose a cell:");
    }

    private String cellString(int i, Board board) {
        if (board.getCell(i)=="-") {
            return Integer.toString(i);
        }
        return board.getCell(i);
    }

    public String getBoardString(Board board) {
        String output = "┌───┬───┬───┐\n│ " +
            cellString(1, board) + " │ " +
            cellString(2, board) + " │ " +
            cellString(3, board) + " │\n│───│───│───│\n│ " +
            cellString(4, board) + " │ " +
            cellString(5, board) + " │ " +
            cellString(6, board) + " │\n│───│───│───│\n│ " +
            cellString(7, board) + " │ " +
            cellString(8, board) + " │ " +
            cellString(9, board) + " │\n└───┴───┴───┘";
        return output;
    }

    public void printBoard(Board board) {
        printStream.println(getBoardString(board));
    }

    public String getMessage(String id) {
        return messages.get(id);
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

    public Integer getMove(Board board) throws IOException {
        printMessage("getMove");
        Integer level = null;
        try {
            level = Integer.parseInt(reader.readLine());
        } catch (NumberFormatException e) {
            return getMove(board);
        }
        if (board.isFree(level)) {
            return level;
        } else {
            return getMove(board);
        }
    }
}
