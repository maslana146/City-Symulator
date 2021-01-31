package com.bartoszmaslanka144091.Controllers;

import javafx.fxml.FXML;

public class MainSettingsScreen {
    private MainScreen mainScreen;


    public void setMainScreen(MainScreen mainScreen) {
        this.mainScreen = mainScreen;
    }


    /**
     * back to menu
     */
    @FXML
    public void backMenu() {
        mainScreen.loadMenuScreen();

    }


}
