package com.bartoszmaslanka144091.Controllers;

import com.bartoszmaslanka144091.Cell;
import com.bartoszmaslanka144091.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

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
    public Label titleTab;
    public Pane staticInformationWindow;
    public Label shopTitle;
    public Label shopNameLabel;
    public Label shopAddressLabel;
    public Label capacityProdLabel;
    public Label capacityPerLabel;
    public TableView productsTable1;
    public Button createProd;
    public ToggleButton saleButton;
    public Label vacLabel;
    public Label vacResultLabel;
    public Label sickLabel;
    public Label sickResultLabel;
    Program program = Program.getInstance();
    public boolean created = false;
    static int numCols = 20;
    static int numRows = 20;
    static public ObservableList<StaticObject> staticObjects = FXCollections.observableArrayList();
    static public ObservableList<MovingObject> movingObjects = FXCollections.observableArrayList();
    static public ObservableList<Thread> threadObservableList = FXCollections.observableArrayList();
    MainWorldScreen mainWorldScreen = new MainWorldScreen();


    @FXML
    public void initialize() throws InterruptedException {
            GraphicsContext gc = worldCanvas.getGraphicsContext2D();
            Map.createCells();
            Map.paintMap(gc);

            Cell[][] grid = Map.getGrid();


            List<Cell> shopCells = Map.getShopCells();
            List<Cell> goToCells = new ArrayList<Cell>();
            goToCells.add(grid[1][5]);
            goToCells.add(grid[2][2]);
            goToCells.add(grid[2][17]);
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
                wholesale.setPeopleCapacity(0);
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
//            System.out.println(retailShop.getAvailableProducts());
                retailShop.setPeopleCapacity(0);
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
//        TimeUnit.SECONDS.sleep(2);

    }

    private void showInformationMovingObject(MovingObject obj) {
        obj.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                informationWindowVisable(obj);

            }
        });
    }

    private void showInformationStaticObject(StaticObject obj) {
        obj.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                shopInformationWindow(obj);

            }
        });
    }

    public void shopInformationWindow(StaticObject object) {
        informationWindow.setVisible(false);
        staticInformationWindow.setVisible(true);

        if (object.getRetailShop() == null) {
            shopNameLabel.setText(object.getWholesale().getName());
            shopAddressLabel.setText(object.getWholesale().getAddress());
            capacityProdLabel.setText(String.valueOf(object.getWholesale().getStorageCapacity()) + '/' + object.getWholesale().getMaxStorageCapacity());
            capacityPerLabel.setText(String.valueOf(object.getWholesale().getPeopleCapacity()) + '/' + object.getWholesale().getMaxClientCapacity());
            shopTitle.setText("WHOLESALE");
            saleButton.setOnAction(new EventHandler<ActionEvent>() {
                                       @Override
                                       public void handle(ActionEvent event) {

                                           object.getWholesale().setIs_sale(saleButton.isSelected());
                                       }
                                   }

            );
            createProd.setVisible(true);
            createProd.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    object.getWholesale().createProduct();
                    capacityProdLabel.setText(String.valueOf(object.getWholesale().getStorageCapacity()) + '/' + object.getWholesale().getMaxStorageCapacity());

                }
            });
            productsTable1.getColumns().clear();
            TableColumn id = new TableColumn("ID");
            TableColumn name = new TableColumn("Name");
            TableColumn brand = new TableColumn("Brand");
            productsTable1.getColumns().addAll(id, name, brand);
            id.setCellValueFactory(
                    new PropertyValueFactory<Product, Integer>("id")
            );
            name.setCellValueFactory(
                    new PropertyValueFactory<Product, String>("name")
            );
            brand.setCellValueFactory(
                    new PropertyValueFactory<Product, String>("brand")
            );
            productsTable1.setItems(object.getWholesale().getAvailableProducts());


        } else if (object.getWholesale() == null) {
//            System.out.println(object.getRetailShop().isSale());
            shopNameLabel.setText(object.getRetailShop().getName());
            shopAddressLabel.setText(object.getRetailShop().getAddress());
            capacityProdLabel.setText(String.valueOf(object.getRetailShop().getStorageCapacity()) + '/' + object.getRetailShop().getMaxStorageCapacity());
            capacityPerLabel.setText(String.valueOf(object.getRetailShop().getPeopleCapacity()) + '/' + object.getRetailShop().getMaxClientCapacity());
            shopTitle.setText("RETAILSHOP");
            saleButton.setSelected(object.getRetailShop().isSale());
            saleButton.setOnAction(new EventHandler<ActionEvent>() {
                                       @Override
                                       public void handle(ActionEvent event) {
                                           object.getRetailShop().setIs_sale(saleButton.isSelected());
                                           shopInformationWindow(object);
                                       }
                                   }

            );
            createProd.setVisible(false);
            productsTable1.getColumns().clear();
            TableColumn id = new TableColumn("ID");
            TableColumn name = new TableColumn("Name");
            TableColumn brand = new TableColumn("Brand");
            TableColumn chance = new TableColumn("Chance to take");
            productsTable1.getColumns().addAll(id, name, brand, chance);
            id.setCellValueFactory(
                    new PropertyValueFactory<Product, Integer>("id")
            );
            name.setCellValueFactory(
                    new PropertyValueFactory<Product, String>("name")
            );
            brand.setCellValueFactory(
                    new PropertyValueFactory<Product, String>("brand")
            );
            chance.setCellValueFactory(
                    new PropertyValueFactory<Product, Float>("chance_to_take")
            );
            productsTable1.setItems(object.getRetailShop().getAvailableProducts());
        }

    }

    public void informationWindowVisable(MovingObject object) {
        staticInformationWindow.setVisible(false);
        informationWindow.setVisible(true);

//        System.out.println(object.getClient().getMaxCapacity());
        //TODO dodaj funkcji zmiany kierunku koljneo ruchu
        if (object.getSupplier() == null) {
            System.out.println(object.getClient().getShopsToGetWell());
//            System.out.println(object.getClient().getIsSick());
//            System.out.println("max: "+object.getClient().getMaxCapacity()+" current: "+object.getClient().getCurrentCapacity());
            firstLabel.setText("Id:");
            clientIdLabel.setText(String.valueOf(object.getClient().getId()));
            secodnLabel.setText("First name:");
            clientNameLabel.setText(object.getClient().getFirstName());
            thirdLabel.setText("Last name:");
            clientLastNameLabel.setText(object.getClient().getLastName());
            fourthLabel.setText("Next shop:");
            clientNextShopLabel.setText(object.getClient().getNextshop().getRetailShop().getName());
            vacLabel.setText("Is vaccinated:");
            vacResultLabel.setText(String.valueOf(object.getClient().getVaccinated()));
            sickLabel.setText("Is sick:");
            sickResultLabel.setText(String.valueOf(object.getClient().getIsSick()));
            titleTab.setText("CLIENT");
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
//            System.out.println(object.getSupplier().getIsSick());

//            System.out.println("max: "+object.getSupplier().getMaxCapacity()+" current: "+object.getSupplier().getCurrentCapacity());

            firstLabel.setText("Id:");
            clientIdLabel.setText(String.valueOf(object.getSupplier().getId()));
            secodnLabel.setText("Car brand:");
            clientNameLabel.setText(object.getSupplier().getCarBrand());
            thirdLabel.setText("Company name:");
            clientLastNameLabel.setText(object.getSupplier().getCompanyName());
            vacLabel.setText("Is vaccinated:");
            vacResultLabel.setText(String.valueOf(object.getSupplier().getVaccinated()));
            sickLabel.setText("Is sick:");
            sickResultLabel.setText(String.valueOf(object.getSupplier().getIsSick()));
            fourthLabel.setText("Next shop:");
            if (object.getSupplier().getNextShop().getWholesale() == null) {
                clientNextShopLabel.setText(object.getSupplier().getNextShop().getRetailShop().getName());
            } else if (object.getSupplier().getNextShop().getRetailShop() == null) {
                clientNextShopLabel.setText(object.getSupplier().getNextShop().getWholesale().getName());
            }
            titleTab.setText("SUPPLIER");
            deleteButton.setOnAction(new EventHandler<ActionEvent>() {
                                         @Override
                                         public void handle(ActionEvent event) {

                                             object.setVisible(false);
                                             object.stop();

                                             threadObservableList.remove(object);
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
        staticInformationWindow.setVisible(false);

    }

    public void pause(ActionEvent actionEvent) throws InterruptedException {
        System.out.println(threadObservableList);
//        for (Thread thread:threadObservableList){
//            thread.suspend();
//            //TODO zatrzymuje wstaw do initialize if jestli sie juz raz zrobilo a jesli nie to zrob caly intialize
//        }

    }

    public void go(ActionEvent actionEvent) {
        for (Thread thread : threadObservableList) {
            thread.resume();
            //TODO zatrzymuje wstaw do initialize if jestli sie juz raz zrobilo a jesli nie to zrob caly intialize
        }
    }
}
