package ttt;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class CellView {

    public static StackPane render(GridPane gridPane, int row, int column, String marker) {
        StackPane stackPane = makeStackPane();
        addText(stackPane, marker);
        setIndices(gridPane, stackPane, row, column);
        return stackPane;
    }

    private static StackPane makeStackPane() {
        StackPane stackPane = new StackPane();
        stackPane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2))));
        return stackPane;
    }

    private static void addText(StackPane stackPane, String marker) {
        Text text = new Text();
        text.setText(marker);
        stackPane.getChildren().add(text);
    }

    private static void setIndices(GridPane gridPane, StackPane stackPane, int row, int column) {
        gridPane.setRowIndex(stackPane, row);
        gridPane.setColumnIndex(stackPane, column);
    }
}
