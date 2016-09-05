package sample;

import javafx.application.Application;
import javafx.concurrent.Worker;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Main extends Application {

    @FXML
//    public Controller controller = new Controller();



    @Override
    public void start(Stage primaryStage) throws Exception{
       //root is default scene constructed from sampleExp.fxml
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("VK Music Player");
//        location.textProperty().bind(controller.engine.locationProperty());
        primaryStage.setScene(new Scene(root, primaryStage.getWidth(), primaryStage.getHeight()));
        primaryStage.show();
//        System.out.println(controller.engine.getLocation());
    }

    public static void main(String[] args) {
        launch(args);
    }

}
