package com.bartoszmaslanka144091;

import javafx.application.Application;
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
//        primaryStage.setResizable(false);
        primaryStage.setMaxHeight(530);
        primaryStage.setMaxWidth(800);
        primaryStage.setMinHeight(530);
        primaryStage.setMinWidth(800);

        primaryStage.show();
    }


    public static void main(String[] args) {
        Program program = Program.getInstance();
        for (int i = 0; i < 3; i++) {
            Wholesale wholesale = new Wholesale(Generators.genString(5), Generators.genString(5),
                    Generators.genInteger(5, 10), Generators.genInteger(5, 10), false, false);

            program.listOfWholesales.add(wholesale);

        }
        for (int i = 0; i < 10; i++) {
            RetailShop retailShop = new RetailShop(Generators.genString(5), Generators.genString(5),
                    Generators.genInteger(5, 10), Generators.genInteger(5, 10), false, false);
            retailShop.createStartProducts();
            program.listOfRetailShops.add(retailShop);

        }
        //TODO ogarnij tą muze
//        final Task task = new Task() {
//            @Override
//            protected Object call() throws Exception {
//                int s = INDEFINITE;
//                AudioClip audio = new AudioClip(getClass().getResource("/com/bartoszmaslanka144091/resource/Volume Alpha - 03 - Subwoofer Lullaby.mp3").toExternalForm());
//                audio.setVolume(0.5f);
//                audio.setCycleCount(s);
//                audio.play();
//                return null;
//            }
//        };
//        Thread thread = new Thread(task);
//        thread.start();


        launch(args);
    }
}

