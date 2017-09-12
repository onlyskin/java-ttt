package ttt;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GuiApp extends Application {
    private final double windowSize = 600;
    private final double cellSize = windowSize / 3;
    private StackPane[] tiles = new StackPane[9];
    private Rectangle[] rectangles = new Rectangle[9];

    private Parent createContent() {
        Pane pane = new Pane();
        pane.setPrefSize(windowSize+1, windowSize+1);

        for (int i=0;i<9;i++) {
            Rectangle rectangle = new Rectangle();
            StackPane stackPane = new StackPane();
            rectangles[i] = rectangle;
            tiles[i] = stackPane;
            
            rectangle.setFill(null);
            rectangle.setStroke(Color.BLACK);
            stackPane.setAlignment(Pos.CENTER);
            stackPane.getChildren().addAll(rectangle);
            pane.getChildren().add(stackPane);
        }

        updateContent(cellSize);

        return pane;
    }

    private void updateContent(double cellSize) {
        for (int i=0;i<9;i++) {
            rectangles[i].setHeight(cellSize);
            rectangles[i].setWidth(cellSize);
            tiles[i].setTranslateX((i%3) * cellSize);
            tiles[i].setTranslateY((i/3) * cellSize);
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(createContent());
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.minWidthProperty().bind(scene.heightProperty().multiply(1));
        primaryStage.minHeightProperty().bind(scene.widthProperty().multiply(1));
        primaryStage.minHeightProperty().addListener(new ChangeListener() {
            @Override public void changed(ObservableValue o, Object oldValue, Object newValue) {
                updateContent(primaryStage.getMinHeight() / 3);
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
