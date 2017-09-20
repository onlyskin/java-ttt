package ttt;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class CellView {
    public static void handleClick(MouseEvent event) {
        StackPane source = (StackPane) event.getSource();
        GridPane parent = (GridPane) source.getParent();
        int row = parent.getRowIndex(source);
        int column = parent.getColumnIndex(source);
        System.out.println(row);
        System.out.println(column);
    }

    public static StackPane render(GridPane gridPane, int row, int column, String marker) {
        StackPane stackPane = makeStackPane();
        addText(stackPane, marker);
        setIndices(gridPane, stackPane, row, column);
        setEventHandler(stackPane);
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

    private static void setEventHandler(StackPane stackPane) {
        stackPane.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                handleClick(me);
            }
        });
    }
}
