package ttt;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Random;

public class GuiApp extends Application {
    private final double windowSize = 600;
    private final double cellSize = windowSize / 3;
    private StackPane[] tiles = new StackPane[9];
    private Rectangle[] rectangles = new Rectangle[9];

    private Parent createContent() {
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

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(createContent());
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.minWidthProperty().bind(scene.heightProperty());
        primaryStage.minHeightProperty().bind(scene.widthProperty());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
