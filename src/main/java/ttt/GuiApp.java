package ttt;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Random;

public class GuiApp extends Application {
    private final double windowSize = 600;
    private final double cellSize = windowSize / 3;
    private StackPane[] tiles = new StackPane[9];
    private Rectangle[] rectangles = new Rectangle[9];

    private Parent createContent() {
        return AppView.render();
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
