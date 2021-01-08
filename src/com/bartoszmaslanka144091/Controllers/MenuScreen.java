package com.bartoszmaslanka144091.Controllers;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class MenuScreen {

    private MainScreen mainScreen;

    public void setMainScreen(MainScreen mainScreen) {
        this.mainScreen = mainScreen;
    }

    @FXML
    public void openWorld() throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/bartoszmaslanka144091/resource/mainWorldScreen.fxml"));
        Pane pane = loader.load();

        MainWorldScreen mainWorldScreen = loader.getController();
        mainWorldScreen.setMainScreen(mainScreen);
        mainScreen.setScreen(pane);
    }
    @FXML
    public void openSettings() throws IOException {

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/bartoszmaslanka144091/resource/mainSettings.fxml"));
        Pane pane = loader.load();

        MainSettingsScreen mainSettingsScreen = loader.getController();
        mainSettingsScreen.setMainScreen(mainScreen);
        mainScreen.setScreen(pane);


    }
    @FXML
    public void exit(){
        Platform.exit();
    }

}
