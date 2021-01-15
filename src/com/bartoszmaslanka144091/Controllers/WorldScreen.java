package com.bartoszmaslanka144091.Controllers;

import com.bartoszmaslanka144091.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WorldScreen {

    public Canvas worldCanvas;
    public Pane worldPane;
    Program program = Program.getInstance();
    static int numCols = 20;
    static int numRows = 20;
    static public ObservableList<StaticObject> staticObjects = FXCollections.observableArrayList();
    static public ObservableList<MovingObject> movingObjects = FXCollections.observableArrayList();
    static public ObservableList<Thread> threadObservableList = FXCollections.observableArrayList();

    @FXML
    public void initialize() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
//        Timeline timeline = new Timeline();
//        int id = Generators.newId();
//        boolean isSick = Generators.genBool();
//        boolean wearsMask = Generators.genBool();
//        boolean vac = Generators.genBool();
//        float chanceToGetSick = Generators.genFloat(0, 1);
//        int shopsToGetWell = Generators.genInteger(0, 5);
//        int currentCapacity = 0;
//        int maxCapacity = Generators.genInteger(0, 5);
//        ArrayList<Product> bag = new ArrayList<Product>();
//        String firstName = Generators.firstName();
//        String lastName = Generators.lastName();
//        Client dupa = new Client(id, isSick, wearsMask, vac, chanceToGetSick, shopsToGetWell, currentCapacity,
//                maxCapacity, bag, firstName, lastName);
//        program.listOfClients.add(dupa);

        GraphicsContext gc = worldCanvas.getGraphicsContext2D();
        Map.createCells();
        Map.paintMap(gc);

        Cell[][] grid = Map.getGrid();


        List<Cell> shopCells = Map.getShopCells();
        List<Cell> goToCells = new ArrayList<Cell>();
        goToCells.add(grid[1][5]);
        goToCells.add(grid[2][17]);
        goToCells.add(grid[2][2]);
        goToCells.add(grid[4][10]);
        goToCells.add(grid[8][4]);
        goToCells.add(grid[8][7]);
        goToCells.add(grid[8][15]);
        goToCells.add(grid[10][7]);
        goToCells.add(grid[10][13]);
        goToCells.add(grid[12][18]);
        goToCells.add(grid[14][10]);
        goToCells.add(grid[17][2]);
        goToCells.add(grid[17][17]);
        for (Wholesale wholesale : program.listOfWholesales) {
            Cell goToCell = goToCells.get(0);
            goToCells.remove(0);
            Cell shopCell = shopCells.get(0);
            shopCells.remove(0);
            StaticObject staticObject = new StaticObject(shopCell.getX(), shopCell.getY(), 25, 25);
            staticObject.setFill(Color.YELLOW);
            staticObject.setStroke(Color.BLACK);
            staticObject.setWholesale(wholesale);
            staticObject.setCell(shopCell);
            staticObject.setGoToCell(goToCell);
            showInformationStaticObject(staticObject);
            staticObjects.add(staticObject);
            worldPane.getChildren().add(staticObject);
        }
        for (RetailShop retailShop : program.listOfRetailShops) {
            Cell goToCell = goToCells.get(0);
            goToCells.remove(0);
            Cell shopCell = shopCells.get(0);
            shopCells.remove(0);
            StaticObject staticObject = new StaticObject(shopCell.getX(), shopCell.getY(), 25, 25);
            staticObject.setFill(Color.RED);
            staticObject.setStroke(Color.BLACK);
            staticObject.setRetailShop(retailShop);
            staticObject.setCell(shopCell);
            staticObject.setGoToCell(goToCell);
            showInformationStaticObject(staticObject);

            worldPane.getChildren().add(staticObject);
            staticObjects.add(staticObject);
        }
        for (Client client : program.listOfClients) {
            client.setNextshop();
            MovingObject object = new MovingObject(0, 0, 12.5, Color.HOTPINK);
            object.setClient(client);
            object.setStroke(Color.BLACK);
            worldPane.getChildren().add(object);
            Thread obj = new Thread(object);
            threadObservableList.add(obj);
            movingObjects.add(object);
            showInformationMovingObject(object);
            obj.setDaemon(true);
            obj.start();

        }
        for (Supplier supplier : program.listOfSuppliers) {
            supplier.newListOfStops();
            MovingObject object = new MovingObject(0, 0, 12.5, Color.BROWN);
            object.setSupplier(supplier);
            object.setStroke(Color.BLACK);
            worldPane.getChildren().add(object);
            Thread obj = new Thread(object);
            threadObservableList.add(obj);
            movingObjects.add(object);
            showInformationMovingObject(object);
            obj.setDaemon(true);
            obj.start();

        }



    }

    private void showInformationMovingObject(MovingObject obj) {
        obj.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (obj.getSupplier() == null){
                    System.out.println(obj.getClient().getFirstName());
                    System.out.println(obj.getClient().getLastName());
                    System.out.println(obj.getClient().getNextshop());

                }else if(obj.getClient() == null){
                    System.out.println(obj.getSupplier().getCarBrand());
                    System.out.println(obj.getSupplier().getCompanyName());
                    System.out.println(obj.getSupplier().getListOfStops());
                }
                //TODO wstaw ifa by dzieli na suppow i clientow

//                System.out.println(obj.getClient().getFirstName());
//                obj.getClient().setIsSick(!obj.getClient().getIsSick());
//                System.out.println(obj.getClient().getIsSick());
//                System.out.println(obj.getTranslateX());
//                System.out.println(obj.getTranslateY());
//                obj.getCurrentCell();
//                System.out.println(obj.getClient().getNextshop());


//                    System.out.println(obj.getSupplier().getCarBrand());
//                    System.out.println(obj.getSupplier().getIsSick());
//
            }
        });
    }
    private void showInformationStaticObject(StaticObject obj) {
        obj.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("RetailsShop: "+obj.getRetailShop());
                System.out.println("WholeSale: "+obj.getWholesale());
//                System.out.println(obj.getTranslateX());
//                System.out.println(obj.getTranslateY());
//                obj.getCurrentCell();
//                System.out.println(obj.getClient().getNextshop());


//                    System.out.println(obj.getSupplier().getCarBrand());
//                    System.out.println(obj.getSupplier().getIsSick());
//
            }
        });
    }
}
