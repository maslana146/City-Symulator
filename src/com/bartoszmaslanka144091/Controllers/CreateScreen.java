package com.bartoszmaslanka144091.Controllers;

import com.bartoszmaslanka144091.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class CreateScreen {

    Program program = Program.getInstance();
    @FXML
    Label resultLabel;

    @FXML
    CheckBox clientIsSick;
    @FXML
    CheckBox clientWearsMask;
    @FXML
    CheckBox clientIsVaccinated;
    @FXML
    TextField clientBagCapacityField;
    @FXML
    TextField clientFirstNameField;
    @FXML
    TextField clientLastNameField;

    @FXML
    TextField supplierIdField;
    @FXML
    CheckBox supplierIsSick;
    @FXML
    CheckBox supplierWearsMask;
    @FXML
    CheckBox supplierIsVaccinated;
    @FXML
    TextField supplierBagCapacityField;
    @FXML
    TextField supplierCompanyNameField;
    @FXML
    TextField supplierCarBrandField;


    /**
     * @param string show information
     */
    public void showResult(String string) {
        resultLabel.textProperty().setValue(string);
    }


    /**
     * @param actionEvent create random client
     */
    public void createRandomClient(ActionEvent actionEvent) {
        int id = Generators.newId();
        boolean isSick = Generators.genBool();
        boolean wearsMask = Generators.genBool();
        boolean vac = Generators.genBool();
        float chanceToGetSick = Generators.genFloat(0, 1);
        int shopsToGetWell = program.getShopsToGetWell();
        int currentCapacity = 0;
        int maxCapacity = Generators.genInteger(1, 5);
        ObservableList<Product> bag = FXCollections.observableArrayList();
        String firstName = Generators.firstName();
        String lastName = Generators.lastName();
        Client client = new Client(id, isSick, wearsMask, vac, chanceToGetSick, shopsToGetWell,
                currentCapacity, maxCapacity, bag, firstName, lastName);
        if (!client.getIsSick()) {
            client.setShopsToGetWell(0);
        }
//        Client client = new Client(id, isSick, wearsMask, vac, chanceToGetSick, shopsToGetWell, currentCapacity,
//                maxCapacity, bag, firstName, lastName);
//        System.out.println(client);
        boolean result = program.listOfClients.add(client);
        if (result) {
            showResult("Random Client was created successfully, Client ID: " + id);
            resultLabel.setTextFill(Color.WHITE);
            program.checkPerSick();
            program.checkVacSick();

        } else {
            showResult("Something goes wrong");
            resultLabel.setTextFill(Color.RED);
        }

    }

    /**
     * @param actionEvent create random supplier
     */
    public void createRandomSupplier(ActionEvent actionEvent) {
        int id = Generators.newId();
        boolean isSick = Generators.genBool();
        boolean wearsMask = Generators.genBool();
        boolean vac = Generators.genBool();
        float chanceToGetSick = Generators.genFloat(0, 1);
        int shopsToGetWell = program.getShopsToGetWell();
        int currentCapacity = 0;
        int maxCapacity = Generators.genInteger(3, 6);
        ObservableList<Product> bag = FXCollections.observableArrayList();
        ArrayList<StaticObject> listOfStops = new ArrayList<StaticObject>();
        String companyName = Generators.brandName();
        String carBrand = Generators.carName();
        float fuelConsumption = Generators.genFloat(0, 1);
        Supplier supplier = new Supplier(id, isSick, wearsMask, vac, chanceToGetSick, shopsToGetWell, currentCapacity,
                maxCapacity, bag, companyName, carBrand, listOfStops, fuelConsumption, (float) 1.0, (float) 1.0);
//        System.out.println(supplier);
        if (!supplier.getIsSick()) {
            supplier.setShopsToGetWell(0);
        }
        boolean result = program.listOfSuppliers.add(supplier);
        if (result) {
            showResult("Random Supplier was created successfully, Supplier ID: " + id);
            resultLabel.setTextFill(Color.WHITE);
            program.checkPerSick();
            program.checkVacSick();

        } else {
            showResult("Something goes wrong");
            resultLabel.setTextFill(Color.RED);
        }
    }


    /**
     * @param actionEvent create client with specific attributes
     */
    public void createClient(ActionEvent actionEvent) {
        clientBagCapacityField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    clientBagCapacityField.setText(newValue.replaceAll("[^\\d]", ""));
                    showResult("Bag capacity must be an Integer");
                    resultLabel.setTextFill(Color.WHITE);
                }
            }
        });
        if ((clientFirstNameField.getText() == null || clientFirstNameField.getText().trim().isEmpty()) ||
                (clientLastNameField.getText() == null || clientLastNameField.getText().trim().isEmpty()) ||
                (clientBagCapacityField.getText() == null || clientBagCapacityField.getText().trim().isEmpty())
        ) {
            showResult("All fields must be fill");
            resultLabel.setTextFill(Color.WHITE);
        } else {
            int id = Generators.newId();
            boolean isSick = clientIsSick.isSelected();
            boolean wearsMask = clientWearsMask.isSelected();
            boolean isVac = clientIsVaccinated.isSelected();
            float chanceToGetSick = Generators.genFloat(0, 1);
            int shopsToGetWell = program.getShopsToGetWell();
            int currentCapacity = 0;
            int maxCapacity = Integer.parseInt(clientBagCapacityField.getText());
            ObservableList<Product> bag = FXCollections.observableArrayList();
            String firstName = clientFirstNameField.getText();
            String lastBrand = clientLastNameField.getText();
            Client client = new Client(id, isSick, wearsMask, isVac, chanceToGetSick, shopsToGetWell, currentCapacity,
                    maxCapacity, bag, firstName, lastBrand);
//            System.out.println(client);
            if (!client.getIsSick()) {
                client.setShopsToGetWell(0);
            }
            boolean result = program.listOfClients.add(client);
            if (result) {
                showResult("Client was created successfully, Client ID: " + id);
                resultLabel.setTextFill(Color.WHITE);
                program.checkPerSick();
                program.checkVacSick();

                clientBagCapacityField.clear();
                clientFirstNameField.clear();
                clientLastNameField.clear();
            } else {
                showResult("Something goes wrong");
                resultLabel.setTextFill(Color.RED);
            }


        }

    }

    /**
     * @param actionEvent create supplier with speciffic attributes
     */
    public void createSupplier(ActionEvent actionEvent) {
        supplierBagCapacityField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    supplierBagCapacityField.setText(newValue.replaceAll("[^\\d]", ""));
                    showResult("Bag capacity must be an Integer");
                    resultLabel.setTextFill(Color.WHITE);
                }
            }
        });
        if ((supplierCarBrandField.getText() == null || supplierCarBrandField.getText().trim().isEmpty()) ||
                (supplierCompanyNameField.getText() == null || supplierCompanyNameField.getText().trim().isEmpty()) ||
                (supplierBagCapacityField.getText() == null || supplierBagCapacityField.getText().trim().isEmpty())
        ) {
            showResult("All fields must be fill");
            resultLabel.setTextFill(Color.WHITE);
        } else {
            int id = Generators.newId();
            boolean isSick = supplierIsSick.isSelected();
            boolean wearsMask = supplierWearsMask.isSelected();
            boolean isVac = supplierIsVaccinated.isSelected();
            float chanceToGetSick = Generators.genFloat(0, 1);
            int shopsToGetWell = program.getShopsToGetWell();
            int currentCapacity = 0;
            int maxCapacity = Integer.parseInt(supplierBagCapacityField.getText());
            ObservableList<Product> bag = FXCollections.observableArrayList();
            String companyName = supplierCompanyNameField.getText();
            String carBrand = supplierCarBrandField.getText();
            ArrayList<StaticObject> listOfStops = new ArrayList<StaticObject>();
            float fuelConsumption = Generators.genFloat(0, 1);
            Supplier supplier = new Supplier(id, isSick, wearsMask, isVac, chanceToGetSick, shopsToGetWell, currentCapacity,
                    maxCapacity, bag, companyName, carBrand, listOfStops, fuelConsumption, (float) 1.0, (float) 1.0);
//            System.out.println(supplier);
            if (!supplier.getIsSick()) {
                supplier.setShopsToGetWell(0);
            }
            boolean result = program.listOfSuppliers.add(supplier);
            if (result) {
                showResult("Supplier was created successfully, Supplier ID: " + id);
                resultLabel.setTextFill(Color.WHITE);
                program.checkPerSick();
                program.checkVacSick();
                supplierBagCapacityField.clear();
                supplierCompanyNameField.clear();
                supplierCarBrandField.clear();
            } else {
                showResult("Something goes wrong");
                resultLabel.setTextFill(Color.RED);
            }


        }

    }

}
