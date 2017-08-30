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
    Ui ui;

    @Test
    public void RunsGameToEnd() throws Exception {
        runGameWithUserInput("1\n2\n4\n5\n7\nexit\n");
        assertEquals("start\n" +
            uiString(new String[][]{{"-","-","-"},{"-","-","-"},{"-","-","-"}}) + 
            uiString(new String[][]{{"X","-","-"},{"-","-","-"},{"-","-","-"}}) + 
            uiString(new String[][]{{"X","O","-"},{"-","-","-"},{"-","-","-"}}) + 
            uiString(new String[][]{{"X","O","-"},{"X","-","-"},{"-","-","-"}}) + 
            uiString(new String[][]{{"X","O","-"},{"X","O","-"},{"-","-","-"}}) + 
            uiString(new String[][]{{"X","O","-"},{"X","O","-"},{"X","-","-"}}) + 
            "X won\n", out.toString());
    }

    @Test
    public void RunsTiedGame() throws Exception {
        runGameWithUserInput("1\n2\n7\n4\n8\n9\n6\n3\n5\nexit\n");
        assertEquals("start\n" +
            uiString(new String[][]{{"-","-","-"},{"-","-","-"},{"-","-","-"}}) + 
            uiString(new String[][]{{"X","-","-"},{"-","-","-"},{"-","-","-"}}) + 
            uiString(new String[][]{{"X","O","-"},{"-","-","-"},{"-","-","-"}}) + 
            uiString(new String[][]{{"X","O","-"},{"-","-","-"},{"X","-","-"}}) + 
            uiString(new String[][]{{"X","O","-"},{"O","-","-"},{"X","-","-"}}) + 
            uiString(new String[][]{{"X","O","-"},{"O","-","-"},{"X","X","-"}}) + 
            uiString(new String[][]{{"X","O","-"},{"O","-","-"},{"X","X","O"}}) + 
            uiString(new String[][]{{"X","O","-"},{"O","-","X"},{"X","X","O"}}) + 
            uiString(new String[][]{{"X","O","O"},{"O","-","X"},{"X","X","O"}}) + 
            uiString(new String[][]{{"X","O","O"},{"O","X","X"},{"X","X","O"}}) + 
            "a tie\n", out.toString());
    }

    private String uiString(String[][] c) {
        return ui.getBoardString(new Board(c)) + "\n";
    }

    private void runGameWithUserInput(String userInput) throws Exception {
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        out = new ByteArrayOutputStream();
        PrintStream output = new PrintStream(out);
        ui = new Ui(reader, output);
        Game game = new Game(ui);
        game.start();
    }
}
