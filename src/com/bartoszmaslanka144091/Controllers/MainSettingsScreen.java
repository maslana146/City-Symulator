package com.bartoszmaslanka144091.Controllers;

import javafx.event.Event;
import javafx.fxml.FXML;

public class MainSettingsScreen {
    private MainScreen mainScreen;


    public void setMainScreen(MainScreen mainScreen) {
        this.mainScreen = mainScreen;
    }


    @FXML
    public void backMenu() {
        mainScreen.loadMenuScreen();

    }

    public void initSettings(Event event) {

    }


}
