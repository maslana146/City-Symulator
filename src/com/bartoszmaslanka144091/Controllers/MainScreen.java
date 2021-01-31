package com.bartoszmaslanka144091.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class MainScreen {
    @FXML private StackPane mainStackPane;

    @FXML
    public void initialize(){
        loadMenuScreen();
    }

    /**
     * loads fxml
     */
    public void loadMenuScreen() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/bartoszmaslanka144091/resource/menuScreen.fxml"));
        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        MenuScreen menuScreen = loader.getController();
        menuScreen.setMainScreen(this);
        setScreen(pane);
    }

    public void setScreen(Pane pane) {
        mainStackPane.getChildren().clear();
        mainStackPane.getChildren().add(pane);
    }
}
