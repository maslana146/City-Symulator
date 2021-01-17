package com.bartoszmaslanka144091.Controllers;

import com.bartoszmaslanka144091.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WorldScreen {

    public Canvas worldCanvas;
    public Pane worldPane;
    public Pane informationWindow;
    public Label clientNameLabel;
    public Label clientLastNameLabel;
    public Label clientNextShopLabel;
    public Label clientIdLabel;
    public Button deleteButton;
    public TableView productsTable;
    public Label secodnLabel;
    public Label thirdLabel;
    public Label firstLabel;
    public Label fourthLabel;
    public Label removeLabel;
    public Label titleTab;
    Program program = Program.getInstance();
    static int numCols = 20;
    static int numRows = 20;
    static public ObservableList<StaticObject> staticObjects = FXCollections.observableArrayList();
    static public ObservableList<MovingObject> movingObjects = FXCollections.observableArrayList();
    static public ObservableList<Thread> threadObservableList = FXCollections.observableArrayList();
    MainWorldScreen mainWorldScreen = new MainWorldScreen();


    @FXML
    public void initialize() throws InterruptedException {

        deleteButton.setGraphic(new ImageView("/com/bartoszmaslanka144091/resource/iconmonstr-recycling-13-32.png"));

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
            System.out.println(supplier.getListOfStops());
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
        TimeUnit.SECONDS.sleep(2);

    }

    private void showInformationMovingObject(MovingObject obj) {
        obj.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (obj.getSupplier() == null) {
                    informationWindowVisable(obj);

                } else if (obj.getClient() == null) {
                    informationWindowVisable(obj);
                }
            }
        });
    }

    private void showInformationStaticObject(StaticObject obj) {
        obj.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("RetailsShop: " + obj.getRetailShop());
                System.out.println("WholeSale: " + obj.getWholesale());
            }
        });
    }

    public void informationWindowVisable(MovingObject object) {
        //TODO dodaj funkcji zmiany kierunku koljneo ruchu
        if (object.getSupplier() == null) {
            informationWindow.setVisible(true);
            firstLabel.setText("Id:");
            clientIdLabel.setText(String.valueOf(object.getClient().getId()));
            secodnLabel.setText("First name:");
            clientNameLabel.setText(object.getClient().getFirstName());
            thirdLabel.setText("Last name:");
            clientLastNameLabel.setText(object.getClient().getLastName());
            fourthLabel.setText("Next shop:");
            clientNextShopLabel.setText(object.getClient().getNextshop().getRetailShop().getName());
            titleTab.setText("CLIENT");
            removeLabel.setText("Remove client");
            deleteButton.setOnAction(new EventHandler<ActionEvent>() {
                                         @Override
                                         public void handle(ActionEvent event) {

                                             object.setVisible(false);
                                             object.stop();
                                             movingObjects.remove(object);
                                             program.listOfClients.remove(object.getClient());
                                             informationWindow.setVisible(false);

                                         }
                                     }

            );
            productsTable.getColumns().clear();
            TableColumn id = new TableColumn("ID");
            TableColumn name = new TableColumn("Name");
            TableColumn brand = new TableColumn("Brand");
            productsTable.getColumns().addAll(id, name, brand);
            id.setCellValueFactory(
                    new PropertyValueFactory<Product, Integer>("id")
            );
            name.setCellValueFactory(
                    new PropertyValueFactory<Product, String>("name")
            );
            brand.setCellValueFactory(
                    new PropertyValueFactory<Product, String>("brand")
            );
            productsTable.setItems(object.getClient().getBag());


        } else if (object.getClient() == null) {
            System.out.println(object.getSupplier().getListOfStops().get(0).getWholesale());
            informationWindow.setVisible(true);
            firstLabel.setText("Id:");
            clientIdLabel.setText(String.valueOf(object.getSupplier().getId()));
            secodnLabel.setText("Car brand:");
            clientNameLabel.setText(object.getSupplier().getCarBrand());
            thirdLabel.setText("Company name:");
            clientLastNameLabel.setText(object.getSupplier().getCompanyName());
            fourthLabel.setText("Next shop:");
            if (object.getSupplier().getNextShop().getWholesale() == null) {
                clientNextShopLabel.setText(object.getSupplier().getNextShop().getRetailShop().getName());
            } else if (object.getSupplier().getNextShop().getRetailShop() == null){
                clientNextShopLabel.setText(object.getSupplier().getNextShop().getWholesale().getName());
            }
            titleTab.setText("SUPPLIER");
            removeLabel.setText("Remove supplier");
            deleteButton.setOnAction(new EventHandler<ActionEvent>() {
                                         @Override
                                         public void handle(ActionEvent event) {

                                             object.setVisible(false);
                                             object.stop();
                                             movingObjects.remove(object);
                                             program.listOfSuppliers.remove(object.getSupplier());
                                             informationWindow.setVisible(false);

                                         }
                                     }

            );
            productsTable.getColumns().clear();
            TableColumn id = new TableColumn("ID");
            TableColumn name = new TableColumn("Name");
            TableColumn brand = new TableColumn("Brand");
            productsTable.getColumns().addAll(id, name, brand);
            id.setCellValueFactory(
                    new PropertyValueFactory<Product, Integer>("id")
            );
            name.setCellValueFactory(
                    new PropertyValueFactory<Product, String>("name")
            );
            brand.setCellValueFactory(
                    new PropertyValueFactory<Product, String>("brand")
            );
            productsTable.setItems(object.getSupplier().getBag());
        }
    }


    public void clearInformationWindow(MouseEvent mouseEvent) {
        informationWindow.setVisible(false);

    }
}
