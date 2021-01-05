package sample;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {
    @FXML Slider slider;
    @FXML Label label;

    public void show(){
        slider.valueProperty().addListener(((observable, oldValue, newValue) -> {
            label.setText(Double.toString(newValue.intValue()));
        }));
    }

}
