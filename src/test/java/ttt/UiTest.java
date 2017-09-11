package ttt;

import org.junit.Test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class UiTest {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(out);

    @Test
    public void printsBoard() throws Exception {
        Ui ui = makeUiWithInputStream("");
        Board board = new Board(new String[]{"-","-","-","-","-","-","-","-","-"});
        ui.printBoard(board);
        assertEquals("┌───┬───┬───┐\n│ 1 │ 2 │ 3 │\n│───│───│───│\n" +
            "│ 4 │ 5 │ 6 │\n│───│───│───│\n│ 7 │ 8 │ 9 │\n└───┴───┴───┘\n",
            out.toString());
    }

    @Test
    public void printsWinner() throws Exception {
        Ui ui = makeUiWithInputStream("");
        ui.printWinner(new PlayerStub("X"));
        assertEquals("X won\n\n", out.toString());
    }

    @Test
    public void getsInputLine() throws Exception {
        Ui ui = makeUiWithInputStream("test\n");
        assertEquals("test", ui.getInput());
    }

    @Test
    public void getPlayerTypePrintsMessage() throws Exception {
        Ui ui = makeUiWithInputStream("h\n");
        ui.getPlayerType("X");
        assertEquals("Player X - " + ui.getMessage("getPlayerType") + "\n", out.toString());
    }

    @Test
    public void getPlayerTypeReturnsHuman() throws Exception {
        Ui ui = makeUiWithInputStream("h\n");
        String type = ui.getPlayerType("X");
        assertEquals("human", type);
    }

    @Test
    public void getPlayerTypeReturnsComputer() throws Exception {
        Ui ui = makeUiWithInputStream("c\n");
        String type = ui.getPlayerType("X");
        assertEquals("computer", type);
    }

    @Test
    public void getIntegerGetsValidInput() throws Exception {
        Ui ui = makeUiWithInputStream("3\n");
        Integer input = ui.getInteger();
        assertEquals(new Integer(3), input);
    }

    @Test
    public void getIntegerRejectsInvalidInput() throws Exception {
        Ui ui = makeUiWithInputStream("three\n3\n");
        Integer input = ui.getInteger();
        assertEquals(new Integer(3), input);
    }

    @Test
    public void getIntegerPrintMessageOnInvalidInput() throws Exception {
        Ui ui = makeUiWithInputStream("three\n3\n");
        Integer input = ui.getInteger();
        assertEquals(ui.getMessage("invalidInteger") + "\n", out.toString());
    }

    @Test
    public void getPlayerTypeRejectsOther() throws Exception {
        Ui ui = makeUiWithInputStream("r\nh\n");
        String type = ui.getPlayerType("X");
        assertEquals("human", type);
    }

    @Test
    public void printsMenuChoice() throws Exception {
        Ui ui = makeUiWithInputStream("");
        ui.printMenuChoice(0, "play");
        assertEquals("0) play\n", out.toString());
    }

    private Ui makeUiWithInputStream(String input) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        return new Ui(reader, printStream);
    }
}
