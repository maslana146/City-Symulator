package com.bartoszmaslanka144091.Controllers;

import com.bartoszmaslanka144091.Client;
import com.bartoszmaslanka144091.Program;
import com.bartoszmaslanka144091.Supplier;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Iterator;

public class TableScreen {
    @FXML
    ComboBox comboSwitch;

    @FXML
    TableView mainTableView;
    Program program = Program.getInstance();
    @FXML
    TextField deleteField;
    @FXML
    Label showResult;

    @FXML
    public void initialize() {
        ObservableList<String> list = FXCollections.observableArrayList("Clients", "Suppliers");
        comboSwitch.getItems().addAll(list);
        deleteField.setPromptText("Enter the id...");
        comboSwitch.getSelectionModel().selectFirst();
        switchTable();
    }

    public void switchTable() {
        if (comboSwitch.getValue() == "Clients") {
            mainTableView.getColumns().clear();
            TableColumn id = new TableColumn("ID");
            TableColumn isSick = new TableColumn("Is sick");
            TableColumn isVac = new TableColumn("Is vaccinated");
            TableColumn wearsMask = new TableColumn("Wears mask");
            TableColumn firstNameCol = new TableColumn("First Name");
            TableColumn lastNameCol = new TableColumn("Last Name");

            mainTableView.getColumns().addAll(id, isSick, isVac, wearsMask, firstNameCol, lastNameCol);

            id.setCellValueFactory(
                    new PropertyValueFactory<Client, Integer>("id")
            );
            isSick.setCellValueFactory(
                    new PropertyValueFactory<Client, Boolean>("isSick")
            );
            // zamiana true/false na sick/healthy
//        isSick.setCellValueFactory(tc -> new TableCell<Client,Boolean>(){
//            @Override
//            protected void updateItem(Boolean item, boolean empty){
//                super.updateItem(item, empty);
//                setText(empty ? null:
//                        item.booleanValue() ? "SICK" : "HEALTHY");
//            }
//        });
            isVac.setCellValueFactory(
                    new PropertyValueFactory<Client, Boolean>("vaccinated")
            );

            wearsMask.setCellValueFactory(
                    new PropertyValueFactory<Client, Boolean>("wearsMask")
            );

            firstNameCol.setCellValueFactory(
                    new PropertyValueFactory<Client, String>("firstName")
            );
            lastNameCol.setCellValueFactory(
                    new PropertyValueFactory<Client, String>("lastName")
            );
            mainTableView.setItems(program.listOfClients);


        } else if (comboSwitch.getValue() == "Suppliers") {
            mainTableView.getColumns().clear();
            TableColumn id = new TableColumn("ID");
            TableColumn isSick = new TableColumn("Is sick");
            TableColumn isVac = new TableColumn("Is vaccinated");
            TableColumn wearsMask = new TableColumn("Wears mask");
            TableColumn companyName = new TableColumn("Company Name");
            TableColumn carBrand = new TableColumn("Car Brand");

            mainTableView.getColumns().addAll(id, isSick, isVac, wearsMask, companyName, carBrand);

            id.setCellValueFactory(
                    new PropertyValueFactory<Supplier, Integer>("id")
            );
            isSick.setCellValueFactory(
                    new PropertyValueFactory<Supplier, Boolean>("isSick")
            );
            // zamiana true/false na sick/healthy
//        isSick.setCellValueFactory(tc -> new TableCell<Client,Boolean>(){
//            @Override
//            protected void updateItem(Boolean item, boolean empty){
//                super.updateItem(item, empty);
//                setText(empty ? null:
//                        item.booleanValue() ? "SICK" : "HEALTHY");
//            }
//        });

            isVac.setCellValueFactory(
                    new PropertyValueFactory<Client, Boolean>("vaccinated")
            );
            wearsMask.setCellValueFactory(
                    new PropertyValueFactory<Supplier, Boolean>("wearsMask")
            );

            companyName.setCellValueFactory(
                    new PropertyValueFactory<Supplier, String>("companyName")
            );
            carBrand.setCellValueFactory(
                    new PropertyValueFactory<Client, String>("carBrand")
            );
            mainTableView.setItems(program.listOfSuppliers);
        }

    }


    public void deleteObject(ActionEvent actionEvent) {

        if (deleteField.getText().isEmpty()) {
            showResult.setText("Enter ID!");
            showResult.setAlignment(Pos.CENTER);
            return;
        } else {
            int idx = Integer.parseInt(deleteField.getText());
            boolean check = false;
            if (comboSwitch.getValue() == "Clients") {
                for (Iterator<Client> iterator = program.listOfClients.iterator(); iterator.hasNext(); ) {
                    if (iterator.next().getId() == idx) {
                        iterator.remove();
                        check = true;
                    }

                }
            } else if (comboSwitch.getValue() == "Suppliers") {
                for (Iterator<Supplier> iterator = program.listOfSuppliers.iterator(); iterator.hasNext(); ) {
                    if (iterator.next().getId() == idx) {
                        iterator.remove();
                        check = true;
                    }
                }

            }
            if (check) {
                deleteField.clear();
                showResult.setText("");
            } else {
                showResult.setText("No object with id: " + idx);
                deleteField.clear();
            }
        }
    }

    public void refreshTable(ActionEvent actionEvent) {
        mainTableView.refresh();
    }
}



