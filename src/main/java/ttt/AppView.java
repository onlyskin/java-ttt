package ttt;

import javafx.scene.Parent;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

import java.util.Random;

public class AppView {

    public static Parent render() {
        Random random = new Random();
        GridPane gridPane = new GridPane();
        gridPane.setPrefSize(624,624);

        for (int i=0;i<3;i++) {
            ColumnConstraints columnConstraints = new ColumnConstraints();
            columnConstraints.setHgrow(Priority.ALWAYS);
            gridPane.getColumnConstraints().add(columnConstraints);
            RowConstraints rowConstraints = new RowConstraints();
            rowConstraints.setVgrow(Priority.ALWAYS);
            gridPane.getRowConstraints().add(rowConstraints);
        }

        for (int i=0;i<9;i++) {
            StackPane stackPane = new StackPane();
            gridPane.setRowIndex(stackPane, i/3);
            gridPane.setColumnIndex(stackPane, i%3);
            Text text = new Text();
            text.setText(Integer.toString(random.nextInt(2)));
            stackPane.getChildren().add(text);
            gridPane.getChildren().add(stackPane);
        }

        return gridPane;
    }
}
