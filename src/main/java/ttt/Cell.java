package ttt;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class Cell extends StackPane{
    Text text;

    public Cell() {
        this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2))));
        this.text = new Text();
        this.getChildren().add(text);
    }

    public void setMarker(String marker) {
        text.setText(marker);
    }
}
