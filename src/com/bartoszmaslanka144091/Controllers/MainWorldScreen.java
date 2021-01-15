package com.bartoszmaslanka144091.Controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;

public class MainWorldScreen {
    public Label showTimeLine;
    private MainScreen mainScreen;

    public void setMainScreen(MainScreen mainScreen) {
        this.mainScreen = mainScreen;
    }


    public void backMenu(ActionEvent actionEvent) {
        for (Thread thread:WorldScreen.threadObservableList){

        }
        mainScreen.loadMenuScreen();

    }
}
