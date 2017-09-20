package ttt;

import javafx.scene.Parent;
import javafx.scene.layout.*;

public class AppView {

    public static Parent render(int size) {
        GridPane gridPane = makeGridPane(size);
        addCells(gridPane);
        return gridPane;
    }

    private static GridPane makeGridPane(int size) {
        GridPane gridPane = new GridPane();
        gridPane.setPrefSize(size, size);
        setConstraints(gridPane);
        return gridPane;
    }

    private static void setColumnConstraint(GridPane gridPane) {
        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setHgrow(Priority.ALWAYS);
        gridPane.getColumnConstraints().add(columnConstraints);
    }

    private static void setRowConstraint(GridPane gridPane) {
        RowConstraints rowConstraints = new RowConstraints();
        rowConstraints.setVgrow(Priority.ALWAYS);
        gridPane.getRowConstraints().add(rowConstraints);
    }

    private static void setConstraints(GridPane gridPane) {
        for (int i=0;i<3;i++) {
            setColumnConstraint(gridPane);
            setRowConstraint(gridPane);
        }
    }

    private static void addCells(GridPane gridPane) {
        for (int i=0;i<9;i++) {
            StackPane stackPane = CellView.render(gridPane, i/3, i%3);
            gridPane.getChildren().add(stackPane);
        }
    }
}
