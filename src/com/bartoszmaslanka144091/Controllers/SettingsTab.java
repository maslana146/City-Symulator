package com.bartoszmaslanka144091.Controllers;

import com.bartoszmaslanka144091.Program;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
//TODO coś sie jebie gdy  usune osobe i klikam save save save..
public class SettingsTab {
    Program program = Program.getInstance();
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

    @FXML
    ToggleButton lockdownButton;

    @FXML
    public void initialize() {
        popSicklabel.setText(String.valueOf(program.getPercentageSick()) + " %");
        popSickSlider.valueProperty().setValue(program.getPercentageSick());
        popVaclabel.setText(String.valueOf(program.getPercentageVaccinated()) + " %");
        popVacSlider.valueProperty().setValue(program.getPercentageVaccinated());
        shopsToGetWelllabel.setText(String.valueOf(program.getShopsToGetWell()) + " shops");
        shopsToGetWellSlider.valueProperty().setValue(program.getShopsToGetWell());
        chanToGetSickMasklabel.setText(String.valueOf((program.getGetSickWithMask())) + " %");
        chanToGetSickMaskSlider.valueProperty().setValue((program.getGetSickWithMask()));
        chanToGetSickVaclabel.setText(String.valueOf((program.getGetSickVaccinated())) + " %");
        chanToGetSickVacSlider.valueProperty().setValue((program.getGetSickVaccinated()));

    }

    public void setPopulationSick(MouseEvent mouseEvent) {
        popSickSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                popSicklabel.setText(String.valueOf(newValue.intValue() + " %"));
                program.setPercentageSick(newValue.intValue());

            }
        });

    }

    public void setPopulationVac(MouseEvent mouseEvent) {
        popVacSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                popVaclabel.setText(String.valueOf(newValue.intValue() + " %"));
                program.setPercentageVaccinated(newValue.intValue());


            }
        });

    }

    public void setChanceToGetSickVac(MouseEvent mouseEvent) {
        chanToGetSickVacSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                chanToGetSickVaclabel.setText(String.valueOf(newValue.intValue() + " %"));
                program.setGetSickVaccinated(newValue.intValue());
            }
        });
    }

    public void setChanceToGetSickMask(MouseEvent mouseEvent) {
        chanToGetSickMaskSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                chanToGetSickMasklabel.setText(String.valueOf(newValue.intValue() + " %"));
                program.setGetSickWithMask(newValue.intValue());
            }
        });
    }

    public void setShopsToGetWell(MouseEvent mouseEvent) {
        shopsToGetWellSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                shopsToGetWelllabel.setText(String.valueOf(newValue.intValue() + " shops"));
                program.setShopsToGetWell(newValue.intValue());
            }
        });
    }

    public void checkPer(ActionEvent actionEvent) {
        System.out.println(program.getPercentageSick());
        program.setPerSick();
    }

    public void initSettings() {
        program.checkVacSick();
        program.checkPerSick();
        initialize();

    }

    public void saveSettings(ActionEvent actionEvent) {
        program.setVacSick();
        program.setPerSick();
        program.setShopsToGetWell();
        
        initSettings();

    }

    public void lockdown(ActionEvent actionEvent) {
        program.setLockdown(lockdownButton.isSelected());

    }
}
