package com.bartoszmaslanka144091.Controllers;

import com.bartoszmaslanka144091.MovingObject;
import javafx.event.ActionEvent;

public class MainWorldScreen {




    private MainScreen mainScreen;

    public void setMainScreen(MainScreen mainScreen) {
        this.mainScreen = mainScreen;
    }


    public void backMenu(ActionEvent actionEvent) {
        for (MovingObject movingObject:WorldScreen.movingObjects){
            movingObject.stop();
            WorldScreen.threadObservableList.remove(movingObject);


        }
        mainScreen.loadMenuScreen();

    }

}
