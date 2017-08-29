package ttt;

import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;

import java.io.PrintStream;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class GameTest {
        ByteArrayOutputStream out;

    @Test
    public void RunsGameToEnd() throws Exception {
        runGameWithUserInput("0\n1\n3\n4\n6\nexit\n");
        assertEquals("start\n" +
                "---\n---\n---\n\n" +
                "X--\n---\n---\n\n" +
                "XO-\n---\n---\n\n" +
                "XO-\nX--\n---\n\n" +
                "XO-\nXO-\n---\n\n" +
                "XO-\nXO-\nX--\n\n" +
                "X won\n", out.toString());
    }

    @Test
    public void RunsTiedGame() throws Exception {
        runGameWithUserInput("0\n1\n6\n3\n7\n8\n5\n2\n4\nexit\n");
        assertEquals("start\n" +
                "---\n---\n---\n\n" +
                "X--\n---\n---\n\n" +
                "XO-\n---\n---\n\n" +
                "XO-\n---\nX--\n\n" +
                "XO-\nO--\nX--\n\n" +
                "XO-\nO--\nXX-\n\n" +
                "XO-\nO--\nXXO\n\n" +
                "XO-\nO-X\nXXO\n\n" +
                "XOO\nO-X\nXXO\n\n" +
                "XOO\nOXX\nXXO\n\n" +
                "a tie\n", out.toString());
    }

    private void runGameWithUserInput(String userInput) throws Exception {
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        out = new ByteArrayOutputStream();
        PrintStream output = new PrintStream(out);
        Ui ui = new Ui(reader, output);
        Game game = new Game(ui);
        game.start();
    }
}
