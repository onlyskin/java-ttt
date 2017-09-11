package ttt;

import org.junit.Test;

import static org.junit.Assert.*;

import java.io.PrintStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class GameTest {
    ByteArrayOutputStream out;
    Ui ui;

    @Test
    public void RunsGameToEnd() throws Exception {
        runGameWithUserInput("1\n2\n4\n5\n7\nexit\n");
        assertEquals(
            uiString(new String[]{"-","-","-","-","-","-","-","-","-"}) +
            ui.getMessage("getMove") + "\n" +
            uiString(new String[]{"X","-","-","-","-","-","-","-","-"}) +
            ui.getMessage("getMove") + "\n" +
            uiString(new String[]{"X","O","-","-","-","-","-","-","-"}) +
            ui.getMessage("getMove") + "\n" +
            uiString(new String[]{"X","O","-","X","-","-","-","-","-"}) +
            ui.getMessage("getMove") + "\n" +
            uiString(new String[]{"X","O","-","X","O","-","-","-","-"}) +
            ui.getMessage("getMove") + "\n" +
            uiString(new String[]{"X","O","-","X","O","-","X","-","-"}) +
            "X won\n\n", out.toString());
    }

    @Test
    public void RunsTiedGame() throws Exception {
        runGameWithUserInput("1\n2\n7\n4\n8\n9\n6\n3\n5\nexit\n");
        assertEquals(
            uiString(new String[]{"-","-","-","-","-","-","-","-","-"}) +
            ui.getMessage("getMove") + "\n" +
            uiString(new String[]{"X","-","-","-","-","-","-","-","-"}) +
            ui.getMessage("getMove") + "\n" +
            uiString(new String[]{"X","O","-","-","-","-","-","-","-"}) +
            ui.getMessage("getMove") + "\n" +
            uiString(new String[]{"X","O","-","-","-","-","X","-","-"}) +
            ui.getMessage("getMove") + "\n" +
            uiString(new String[]{"X","O","-","O","-","-","X","-","-"}) +
            ui.getMessage("getMove") + "\n" +
            uiString(new String[]{"X","O","-","O","-","-","X","X","-"}) +
            ui.getMessage("getMove") + "\n" +
            uiString(new String[]{"X","O","-","O","-","-","X","X","O"}) +
            ui.getMessage("getMove") + "\n" +
            uiString(new String[]{"X","O","-","O","-","X","X","X","O"}) +
            ui.getMessage("getMove") + "\n" +
            uiString(new String[]{"X","O","O","O","-","X","X","X","O"}) +
            ui.getMessage("getMove") + "\n" +
            uiString(new String[]{"X","O","O","O","X","X","X","X","O"}) +
            "a tie\n\n", out.toString());
    }

    private String uiString(String[] c) {
        return ui.getBoardString(new Board(c)) + "\n";
    }

    private void runGameWithUserInput(String userInput) throws Exception {
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        out = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(out);
        ui = new Ui(reader, printStream);
        HumanPlayer humanPlayer1 = new HumanPlayer("X", ui);
        HumanPlayer humanPlayer2 = new HumanPlayer("O", ui);
        Player[] players = new Player[]{humanPlayer1, humanPlayer2};
        Game game = new Game(ui, players);
        game.start();
    }
}
