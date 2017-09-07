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
    private final Map<String, String> messages;
    private final PlayerFactory playerFactory;

    public Ui(BufferedReader reader, PrintStream printStream,
            PlayerFactory playerFactory) {
        this.reader = reader;
        this.printStream = printStream;
        this.playerFactory = playerFactory;
        this.messages = new HashMap<>();
        messages.put("welcome", "Welcome to Noughts and Crosses.\nLet's play a game.");
        messages.put("tie", "a tie\n");
        messages.put("getMove", "Please choose a cell:");
        messages.put("invalidMove", "Please choose a valid cell:");
        messages.put("goodbye", "Thanks for playing.");
        messages.put("appMenu", "Menu:\n - play\n - exit\n-------");
        messages.put("invalidCommand", "Please choose a valid option:");
        messages.put("playAppCommand", "play");
        messages.put("exitAppCommand", "exit");
        messages.put("getPlayerType", "player type (h)uman or (c)omputer:");
        messages.put("invalidInteger", "Please choose a valid number:");
    }

    public String getMessage(String id) {
        return messages.get(id);
    }

    public void printMessage(String id) {
        String output = messages.get(id);
        printStream.println(output);
    }

    public void printBoard(Board board) {
        printStream.println(getBoardString(board));
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

    public void printWinner(Player player) {
        printStream.println(player.getMarker() + " won\n");
    }
    
    public String getInput() throws IOException {
        return reader.readLine();
    }

    public String getPlayerType(String marker) throws IOException {
        printStream.print("Player " + marker + " - ");
        printMessage("getPlayerType");
        String input = getInput();
        if (input.equals("h")) {
            return "human";
        }
        else if (input.equals("c")) {
            return "computer";
        } else return getPlayerType(marker);
    }

    public Integer getMove(Board board) throws IOException {
        return getMove(board, 0);
    }

    private String cellString(int i, Board board) {
        if (board.getCell(i)=="-") {
            return Integer.toString(i);
        }
        return board.getCell(i);
    }

    private Integer getMove(Board board, int depth) throws IOException {
        if (depth == 0) printMessage("getMove");
        else printMessage("invalidMove");
        Integer move = null;
        try {
            move = Integer.parseInt(getInput());
        } catch (NumberFormatException e) {
            return getMove(board, depth+1);
        }
        if (move > 9 || move < 1) {
            return getMove(board, depth+1);
        }
        if (board.isFree(move)) {
            return move;
        } else {
            return getMove(board, depth+1);
        }
    }

    public void printMenuChoice(int index, String title) {
    }
    
    public Integer getInteger() throws IOException {
        String input = getInput();
        while (!validNumber(input)) {
            printMessage("invalidInteger");
            input = getInput();
        }
        return Integer.parseInt(input);
    }

    private boolean validNumber(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
