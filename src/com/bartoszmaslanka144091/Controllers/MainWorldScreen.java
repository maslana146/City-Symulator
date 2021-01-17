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
    //TODO obczaj dlaczego to do kurwy jest null!!!
//    public void clientTabVisable(){
//        System.out.println(clientBox.getLayoutX());
//        boolean value = clientBox.isVisible();
//        clientBox.setVisible(!value);
//    }
}
