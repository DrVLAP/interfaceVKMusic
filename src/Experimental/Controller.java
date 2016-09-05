package Experimental;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.concurrent.Worker.State;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

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
    public void GetURLExp(ActionEvent event) {
        System.out.println("Expetimental");
        System.out.println(engine.getLocation());
    }

    public void GetURL2() {
        System.out.println("Expetimental: listener event");
        System.out.println(engine.getLocation());
    }

    @FXML
    public void initialize() {
        engine =  webView.getEngine();
        engine.load("https://oauth.vk.com/authorize?client_id=1&display=mobile&redirect_uri=https://oauth.vk.com/blank.html&scope=audio&response_type=token&v=3.0&revoke=0");
//        location.textProperty().bind(engine.locationProperty());
//        System.out.println(engine.getLocation());
//        if (engine.getLocation().contains("access_token")) {
//            //code here
//            System.out.println("URL Changed");
//        }
//        System.out.println(engine.locationProperty());
        engine.getLoadWorker().stateProperty().addListener(new ChangeListener<State>() {
            @Override
            public void changed(ObservableValue<? extends Worker.State> ov, State oldState, State newState) {
                if (newState  == Worker.State.SUCCEEDED)
                    if (engine.getLocation().contains("access_token")){
                        //code here
                        System.out.println(engine.getLocation());
                        GetURL2();
                    }}
        });


   }

    public void urlChange(){
        System.out.println();

    }

}
