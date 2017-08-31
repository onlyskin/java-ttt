package ttt;

import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;

public class ComputerPlayerTest {

    @Test
    public void computerPlayerPlaysBetween1And9() throws Exception {
        ComputerPlayer computerPlayer = new ComputerPlayer("O");
        assertEquals(computerPlayer.getMarker(), "O");
        List<Integer> moves = new ArrayList();
        Board board = new Board(new String[][]{{"X","O","X"},{"-","-","-"},{"-","-","-"}});
        for (int i=0;i<100;i++) {
            Integer move = computerPlayer.getMove(board);
            if (!moves.contains(move)) {
                moves.add(move);
            }
        }
        assertEquals(6, moves.size());
        for (int i=4;i<=9;i++) {
            assertTrue(moves.contains(i));
        }
    }
}
