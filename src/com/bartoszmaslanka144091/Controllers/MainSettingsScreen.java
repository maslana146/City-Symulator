package com.bartoszmaslanka144091.Controllers;

import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;


import java.net.URL;
import java.text.NumberFormat;
import java.util.ResourceBundle;

public class MainSettingsScreen{
    private MainScreen mainScreen;
    @FXML
    Slider popSickSlider;
    @FXML
    Slider popVacSlider;
    @FXML
    Slider shopsToGetWellSlider;
    @FXML
    Slider chanToGetSickVacSlider;
    @FXML
    Slider chanToGetSickMaskSlider;

    @FXML
    Label popSicklabel;
    @FXML
    Label popVaclabel;
    @FXML
    Label shopsToGetWelllabel;
    @FXML
    Label chanToGetSickVaclabel;
    @FXML
    Label chanToGetSickMasklabel;






    public void showLabel(Slider slider, Label label){
        slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                label.textProperty().setValue(String.valueOf(newValue.intValue() + "%"));

            }
        });

        }



    public void setMainScreen(MainScreen mainScreen) {
        this.mainScreen = mainScreen;
    }



    @FXML
    public void backMenu() {
        mainScreen.loadMenuScreen();

    }


    public void setPopulationSick(MouseEvent mouseEvent) {
        showLabel(popSickSlider,popSicklabel);
    }

    public void setPopulationVac(MouseEvent mouseEvent) {
        showLabel(popVacSlider,popVaclabel);
    }

    public void setChanceToGetSickVac(MouseEvent mouseEvent) {
        showLabel(chanToGetSickVacSlider,chanToGetSickVaclabel);
    }

    public void setChanceToGetSickMask(MouseEvent mouseEvent) {
        showLabel(chanToGetSickMaskSlider,chanToGetSickMasklabel);
    }

    public void setShopsToGetWell(MouseEvent mouseEvent) {
        showLabel(shopsToGetWellSlider,shopsToGetWelllabel);
    }
}
