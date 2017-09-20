package ttt;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class Cell extends StackPane{
    private final int index;
    public final Text text;

    public Cell(int index) {
        this.index = index;
        this.text = new Text();
        this.getChildren().add(text);
        this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2))));
        GridPane.setRowIndex(this,(index-1)%3);
        GridPane.setColumnIndex(this,(index-1)/3);
    }

    public void setMarker(String marker) {
        text.setText(marker);
    }

    public int getIndex() {
        return this.index;
    }
}
