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
    ByteArrayInputStream inputStream = new ByteArrayInputStream("test\nthis\n".getBytes());
    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
    Ui ui = new Ui(reader, printStream);

    @Test
    public void printsBoard() throws Exception {
        Board board = new Board();
        ui.printBoard(board);
        assertEquals("┌───┬───┬───┐\n│ 0 │ 1 │ 2 │\n│───│───│───│\n" +
            "│ 3 │ 4 │ 5 │\n│───│───│───│\n│ 6 │ 7 │ 8 │\n└───┴───┴───┘\n",
            out.toString());
    }

    @Test
    public void printsWinner() throws Exception {
        String marker = "X";
        ui.printWinner(marker);
        assertEquals("X won\n", out.toString());
    }

    @Test
    public void getsInputLine() throws Exception {
        assertEquals("test", ui.getInput());
    }
}
