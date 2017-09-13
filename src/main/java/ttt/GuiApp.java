package ttt;

import java.io.FileInputStream;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GuiApp extends Application
{
    public static void main(String[] args) 
    {
        Application.launch(args);
    }
    
    @Override
    public void start(Stage stage) throws IOException
    {
        VBox root = (VBox) FXMLLoader.load(getClass().getResource("GuiApp.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("An FXML GUI App with a Controller");
        stage.show();
        stage.minWidthProperty().bind(scene.heightProperty());
        stage.minHeightProperty().bind(scene.widthProperty());
    }
}
