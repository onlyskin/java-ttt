package ttt;

import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import org.junit.Test;
import static org.junit.Assert.*;

public class CellTest {
    Cell cell = new Cell(1);

    @Test
    public void hasABorder() throws Exception {
        assertNotNull(cell.getBorder());
    }

    @Test
    public void hasText() throws Exception {
        assertEquals(new Integer(1), (Integer)cell.getChildren().size());
        assertEquals(Text.class, cell.getChildren().get(0).getClass());
        assertEquals("", ((Text)cell.getChildren().get(0)).getText());
    }

    @Test
    public void setsMarkerOnText() throws Exception {
        cell.setMarker("X");
        assertEquals("X", cell.text.getText());
    }

    @Test
    public void hasIndex() throws Exception {
        assertEquals(new Integer(1), (Integer)cell.getIndex());
    }

    @Test
    public void gridPaneSetsIndexes() throws Exception {
        assertEquals(new Integer(0), GridPane.getRowIndex(cell));
        assertEquals(new Integer(0), GridPane.getColumnIndex(cell));
    }

    @Test
    public void gridPaneGetsIndexesFor8() throws Exception {
        Cell cell = new Cell(8);
        assertEquals(new Integer(1), GridPane.getRowIndex(cell));
        assertEquals(new Integer(2), GridPane.getColumnIndex(cell));
    }
}
