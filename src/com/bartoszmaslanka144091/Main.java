package com.bartoszmaslanka144091;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/bartoszmaslanka144091/resource/mainScreen.fxml"));
        StackPane stackPane = loader.load();
        Scene scene = new Scene(stackPane, 800, 500);
        primaryStage.setTitle("Sym-java");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        Program program = Program.getInstance();
        for (int i =0;i<3;i++){
            ObservableList<Product> products = FXCollections.observableArrayList();
            Wholesale wholesale = new Wholesale(Generators.genString(5),
                    Generators.genString(5),Generators.genInteger(5,10),
                    Generators.genInteger(5,10),products,0,false,false
                    );
            program.listOfWholesales.add(wholesale);

        }
        for (int i =0;i<10;i++){
            ObservableList<Product> products = FXCollections.observableArrayList();
            RetailShop retailShop = new RetailShop(Generators.genString(5),
                    Generators.genString(5),Generators.genInteger(5,10),
                    Generators.genInteger(5,10),products,0,false,false
            );
            program.listOfRetailShops.add(retailShop);

        }


        launch(args);
    }
}

