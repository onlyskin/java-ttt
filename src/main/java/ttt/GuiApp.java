package ttt;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Random;

public class GuiApp extends Application {

    private Parent createContent() {
        String[] cells = makeRandomCells();
        return AppView.render(600, cells);
    }

    private static String[] makeRandomCells() {
        String[] cells = new String[9];
        for (int i=0;i<9;i++) {
            cells[i] = getRandomMarker();
        }
        return cells;
    }

    private static String getRandomMarker() {
        Random random = new Random();
        if (random.nextInt(2) == 0) {
            return "X";
        } else {
            return "O";
        }
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
