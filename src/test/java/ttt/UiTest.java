package ttt;

import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class UiTest {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(out);
    Ui ui = new Ui(printStream);

    @Test
    public void printsBoard() throws Exception {
        Board board = new Board();
        ui.printBoard(board);
        assertEquals("---\n---\n---\n\n", out.toString());
    }
}
