package ttt;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
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
        this.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                handleClick(me);
            }
        });
    }

    public void setMarker(String marker) {
        text.setText(marker);
    }

    public int getIndex() {
        return this.index;
    }

    public static void handleClick(MouseEvent event) {
        StackPane source = (StackPane) event.getSource();
        GridPane parent = (GridPane) source.getParent();
        int row = parent.getRowIndex(source);
        int column = parent.getColumnIndex(source);
        System.out.println(row + ", " + column);
    }
}
