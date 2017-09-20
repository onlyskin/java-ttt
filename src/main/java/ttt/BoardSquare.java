package ttt;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class BoardSquare extends StackPane {
    @FXML
    private String row;

    @FXML
    private String column;

    @FXML
    private String marker;

    public BoardSquare(int row, int column, String marker) {
        this.row = Integer.toString(row);
        this.column = Integer.toString(column);
        this.marker = marker;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "BoardSquare.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
