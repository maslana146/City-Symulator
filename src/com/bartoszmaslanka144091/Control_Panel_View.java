package com.bartoszmaslanka144091;

import javafx.application.Application;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class Control_Panel_View extends Application {
    Stage window;
    TableView<Client> clientsTable;
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        TableColumn<Client,String> idColumn = new TableColumn<>("Id");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Client,String> firstNameColumn = new TableColumn<>("First name");
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        TableColumn<Client,String> lastNameColumn = new TableColumn<>("Last name");
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        clientsTable = new TableView<>();
//        clientsTable.setItems(Control_panel.list);
    }
    public static void main(String[] args) {
        Control_panel controlPanel = new Control_panel();
        int i = 0;
//        while (controlPanel.listOfClients.size() < 3){
//            Client client = new Client(i,Boolean.FALSE,false,false,199.33F,
//                    3,2,3,new ObservableList<Product>(),"abbs",
//                    "abbc");
//            controlPanel.listOfClients.add(client);
//        }
//        launch(args);
    }
}
