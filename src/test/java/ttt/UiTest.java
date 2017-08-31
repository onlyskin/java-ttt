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
    ByteArrayInputStream inputStream = new ByteArrayInputStream("test\n6\n5\n".getBytes());
    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
    Ui ui = new Ui(reader, printStream);

    @Test
    public void printsBoard() throws Exception {
        Board board = new Board();
        ui.printBoard(board);
        assertEquals("┌───┬───┬───┐\n│ 1 │ 2 │ 3 │\n│───│───│───│\n" +
            "│ 4 │ 5 │ 6 │\n│───│───│───│\n│ 7 │ 8 │ 9 │\n└───┴───┴───┘\n",
            out.toString());
    }

    @Test
    public void printsWinner() throws Exception {
        ui.printWinner(new PlayerStub("X"));
        assertEquals("X won\n\n", out.toString());
    }

    @Test
    public void getsInputLine() throws Exception {
        assertEquals("test", ui.getInput());
    }

    @Test
    public void getMoveTriesAgainUntilInt() throws Exception {
        Board board = new Board();
        assertEquals(new Integer(6), ui.getMove(board));
        assertEquals(ui.getMessage("getMove") + "\n" +
            ui.getMessage("invalidMove") + "\n", out.toString());
    }

    @Test
    public void getMoveTriesAgainIfCellTaken() throws Exception {
        Board board = new Board(new String[][]{{"-","-","-"},{"-","-","X"},{"-","-","-"}});
        assertEquals(new Integer(5), ui.getMove(board));
        assertEquals(ui.getMessage("getMove") + "\n" +
            ui.getMessage("invalidMove") + "\n" +
            ui.getMessage("invalidMove") + "\n",
            out.toString());
    }
}
