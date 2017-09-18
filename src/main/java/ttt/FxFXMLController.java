package ttt;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class FxFXMLController
{
    @FXML
    private Text text1;

    @FXML
    private Text text2;

    @FXML
    private Text text3;

    @FXML
    private Text text4;

    @FXML
    private Text text5;

    @FXML
    private Text text6;

    @FXML
    private Text text7;

    @FXML
    private Text text8;

	@FXML
	private Text text9;

	@FXML
	private URL location;

	@FXML
	private ResourceBundle resources;

    @FXML
    private Rectangle rect1;

    @FXML
    private Rectangle rect2;

    @FXML
    private Rectangle rect3;

    @FXML
    private Rectangle rect4;

    @FXML
    private Rectangle rect5;

    @FXML
    private Rectangle rect6;

    @FXML
    private Rectangle rect7;

    @FXML
    private Rectangle rect8;

	@FXML
    private Rectangle rect9;

    private Random random;

	public FxFXMLController()
	{
	    this.random = new Random();
	}

	private String getRandomMarker() {
	    int value = random.nextInt(2);
	    if (value == 0) {
	        return "X";
        } else {
	        return "O";
        }
    }

	@FXML
	private void initialize() {
	    text1.setText(getRandomMarker());
        text2.setText(getRandomMarker());
        text3.setText(getRandomMarker());
        text4.setText(getRandomMarker());
        text5.setText(getRandomMarker());
        text6.setText(getRandomMarker());
        text7.setText(getRandomMarker());
        text8.setText(getRandomMarker());
        text9.setText(getRandomMarker());
	}
}
