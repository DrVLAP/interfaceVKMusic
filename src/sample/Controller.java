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
        System.out.println("Release: button event");
        System.out.println(engine.getLocation());
    }

    public void GetURLMethod() {
        System.out.println("Release: listener event:");
        System.out.println(engine.getLocation());

    }

    @FXML
    public void initialize() {
        engine =  webView.getEngine();
        engine.load("https://oauth.vk.com/authorize?client_id=1&display=mobile&redirect_uri=https://oauth.vk.com/blank.html&scope=audio&response_type=token&v=3.0&revoke=0");

        //There is a listener of changing url in webView. If comment/delete string with condition about "access_token"
        // it will show all changes. With this string it will work only if url contains "access_token"
        engine.getLoadWorker().stateProperty().addListener(new ChangeListener<Worker.State>() {
            @Override
            public void changed(ObservableValue<? extends Worker.State> ov, Worker.State oldState, Worker.State newState) {
                if (newState  == Worker.State.SUCCEEDED)
                    if (engine.getLocation().contains("access_token")){
                        //code here
//                        System.out.println(engine.getLocation());
                        GetURLMethod();
                    }
            }
        });
   }


}
