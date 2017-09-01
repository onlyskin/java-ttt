package ttt;

import org.junit.Test;
import org.junit.Ignore;
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
        Board board = new Board();
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
    public void getMoveGetsIntegerInRangeInFreeCell() throws Exception {
        Ui ui = makeUiWithInputStream("test\n0\n46\n6\n5\n");
        Board board = new Board(new String[][]{{"-","-","-"},{"-","-","X"},{"-","-","-"}});
        assertEquals(new Integer(5), ui.getMove(board));
        assertEquals(ui.getMessage("getMove") + "\n" +
            ui.getMessage("invalidMove") + "\n" +
            ui.getMessage("invalidMove") + "\n" +
            ui.getMessage("invalidMove") + "\n" +
            ui.getMessage("invalidMove") + "\n",
            out.toString());
    }

    private Ui makeUiWithInputStream(String input) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        return new Ui(reader, printStream);
    }
}
