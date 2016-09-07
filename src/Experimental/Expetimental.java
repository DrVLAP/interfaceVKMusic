package Experimental;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Expetimental extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
       //root is default scene constructed from sampleExp.fxml
        Parent root = FXMLLoader.load(getClass().getResource("sampleExp.fxml"));
        primaryStage.setTitle("VK Music Player");
        primaryStage.setScene(new Scene(root, primaryStage.getWidth(), primaryStage.getHeight()));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
