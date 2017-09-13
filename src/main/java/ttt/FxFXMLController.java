package ttt;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class FxFXMLController 
{
    @FXML
    private Text text;

	@FXML
	private URL location;

	@FXML
	private ResourceBundle resources;
	
	public FxFXMLController() 
	{
	}
	
	@FXML
	private void initialize() {
	    text.setText("test");
	}
}
