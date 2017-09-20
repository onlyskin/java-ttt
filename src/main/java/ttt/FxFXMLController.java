package ttt;

import java.util.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

public class FxFXMLController
{
    @FXML
	public List<BoardSquare> squares = Arrays.asList(
            new BoardSquare(0, 0, getRandomMarker()),
            new BoardSquare(0, 1, getRandomMarker()),
            new BoardSquare(0, 2, getRandomMarker()),
            new BoardSquare(1, 0, getRandomMarker()),
            new BoardSquare(1, 1, getRandomMarker()),
            new BoardSquare(1, 2, getRandomMarker()),
	        new BoardSquare(2, 0, getRandomMarker()),
            new BoardSquare(2, 1, getRandomMarker()),
            new BoardSquare(2, 2, getRandomMarker())
    );

	@FXML
    private ObservableList<BoardSquare> boardSquares = FXCollections.observableList(squares);

	private static String getRandomMarker() {
	    int value = new Random().nextInt(2);
	    if (value == 0) {
	        return "X";
        } else {
	        return "O";
        }
    }
}
