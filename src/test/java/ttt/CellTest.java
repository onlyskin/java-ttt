package ttt;

import javafx.scene.text.Text;
import org.junit.Test;
import static org.junit.Assert.*;

public class CellTest {
    @Test
    public void hasABorder() throws Exception {
        Cell cell = new Cell();
        assertNotNull(cell.getBorder());
    }

    @Test
    public void hasText() throws Exception {
        Cell cell = new Cell();
        assertEquals(new Integer(1), (Integer)cell.getChildren().size());
        assertEquals(Text.class, cell.getChildren().get(0).getClass());
        assertEquals("", ((Text)cell.getChildren().get(0)).getText());
    }

    @Test
    public void setsMarker() throws Exception {
        Cell cell = new Cell();
        cell.setMarker("X");
        assertEquals("X", ((Text)cell.getChildren().get(0)).getText());
    }
}
