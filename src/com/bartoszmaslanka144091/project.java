package com.bartoszmaslanka144091;

import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class project {


    @FXML Slider slider;
    @FXML
    public void show(){
        int sliderValue = (int) slider.getValue();
        System.out.println(sliderValue + "");

    }

}