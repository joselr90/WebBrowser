package com.example.webbrowser;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController {

    @FXML
    private TextField adressBar;
    @FXML
    private Button load;
    @FXML
    private WebView webView;
    private WebEngine engine;
    String basic="http://";
    @FXML

    private Button backbutton;

    public void init(){
    adressBar.setText(basic);
    engine = webView.getEngine();
        adressBar.setOnKeyPressed(ke -> {
            if (ke.getCode().equals(KeyCode.ENTER)) {
                engine.load(adressBar.getText());
            }
        });

        //get current url
        engine.locationProperty().addListener((observable, oldValue, newValue) -> {
            adressBar.setText(newValue);

        }
        );
}
    @FXML
    public void loadPage(ActionEvent actionEvent) {


        engine.load(adressBar.getText());

    }

    @FXML
    public void backPage(ActionEvent actionEvent) {
        engine.getHistory().go(-1);
    }


}