package com.bartoszmaslanka144091.Controllers;

import javafx.event.ActionEvent;

public class MainWorldScreen {




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
