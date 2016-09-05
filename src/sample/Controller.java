package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import javax.swing.plaf.nimbus.State;

public class Controller{
    Label location = new Label();

    @FXML
    public WebView webView = new WebView();
    public WebEngine engine;

    @FXML
    public void WebViewStatusChange(){
        if (webView.isVisible()==false) {
            webView.setVisible(true);
        } else {
            webView.setVisible(false);

        }
    }




    @FXML
    public void GetURL() {

        System.out.println(engine.getLocation());
    }

    public void GetURL2() {
        System.out.println("Expetimental: listener event");
        System.out.println(engine.getLocation());
    }


    @FXML
    public void initialize() {
        engine =  webView.getEngine();
        engine.load("https://www.google.ru/");


        engine.getLoadWorker().stateProperty().addListener(new ChangeListener<Worker.State>() {
            @Override
            public void changed(ObservableValue<? extends Worker.State> ov, Worker.State oldState, Worker.State newState) {
                if (newState  == Worker.State.SUCCEEDED)
                    if (engine.getLocation().contains("access_token")){
                        //code here
                        System.out.println(engine.getLocation());
                        GetURL2();
                    }}
        });
   }

    public void urlChange(){
//        location.textProperty().bind(engine.locationProperty());


    }


}
