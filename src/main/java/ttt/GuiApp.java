package ttt;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GuiApp extends Application {
    private final Integer windowSize = 600;

    private Parent createContent() {
        Pane pane = new Pane();
        pane.setPrefSize(windowSize+1, windowSize+1);

        for (int i=0;i<3;i++) {
            for (int j=0;j<3;j++) {
                Tile tile = new Tile();
                tile.setTranslateX(j * windowSize / 3);
                tile.setTranslateY(i * windowSize / 3);

                pane.getChildren().add(tile);
            }
        }

        return pane;
    }

    private class Tile extends StackPane {
        public Tile () {
            Rectangle rectangle = new Rectangle(windowSize / 3, windowSize / 3);
            rectangle.setFill(null);
            rectangle.setStroke(Color.BLACK);

            setAlignment(Pos.CENTER);
            getChildren().addAll(rectangle);
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(createContent());
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.minWidthProperty().bind(scene.heightProperty().multiply(1));
        primaryStage.minHeightProperty().bind(scene.widthProperty().multiply(1));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
