package com.bartoszmaslanka144091;

import com.bartoszmaslanka144091.Controllers.WorldScreen;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.List;

public class MovingObject extends Circle implements Runnable {
    private volatile boolean running = true;
    Client client = null;
    Supplier supplier = null;
    Cell currentCell = Map.grid[8][9];
    StaticObject visitingShop;

    public MovingObject(double centerX, double centerY, double radius, Paint fill) {
        super(centerX, centerY, radius, fill);

    }

    public StaticObject getVisitingShop() {
        return visitingShop;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setCurrentCell() {
        Cell[][] grid = Map.getGrid();
        int x = (int) ((getTranslateX()) - 12) / 25;
        int y = (int) ((getTranslateY()) - 12) / 25;
        this.currentCell = grid[x][y];
    }


    public Cell getCurrentCell() {
        return currentCell;
    }

    public void swapItems() {

        List<Product> deleteList = new ArrayList<>();
        if (this.client == null) {
            if (visitingShop.getWholesale() == null) {
                visitingShop.getRetailShop().setPeopleCapacity(visitingShop.getRetailShop().getPeopleCapacity() + 1);
                for (Product product : this.supplier.bag) {
                    if (visitingShop.getRetailShop().getStorageCapacity() < visitingShop.getRetailShop().getMaxStorageCapacity()){
                        visitingShop.getRetailShop().getAvailableProducts().add(product);
                        visitingShop.getRetailShop().setStorageCapacity((visitingShop.getRetailShop().getStorageCapacity()));
                        deleteList.add(product);
                        this.supplier.currentCapacity -=1;

                    }
                }
                this.supplier.bag.removeAll(deleteList);
            } else if (visitingShop.getRetailShop() == null) {
                visitingShop.getWholesale().setPeopleCapacity(visitingShop.getWholesale().getPeopleCapacity() + 1);
                for (Product product : visitingShop.wholesale.availableProducts) {
                    if (this.supplier.currentCapacity < this.supplier.maxCapacity) {
                        deleteList.add(product);
                        this.supplier.getBag().add(product);
                        this.supplier.currentCapacity += 1;
                    }
                }
                visitingShop.getWholesale().getStorageCapacity();
                visitingShop.getWholesale().availableProducts.removeAll(deleteList);
            }


        } else if (this.supplier == null) {
            visitingShop.getRetailShop().setPeopleCapacity(visitingShop.getRetailShop().getPeopleCapacity() + 1);
            for (Product product : visitingShop.getRetailShop().getAvailableProducts()) {
                if (this.client.currentCapacity < this.client.maxCapacity) {
                    float p = Generators.genFloat(0, 1);
                    System.out.println();
                    if (p <= product.chance_to_take) {
                        deleteList.add(product);
//                        System.out.println(deleteList);
//                        visitingShop.getRetailShop().getAvailableProducts().remove();
//                        System.out.println("Dodano"+product);
                        this.client.getBag().add(product);
                        this.client.currentCapacity += 1;
                    }
                } else break;
            }
            visitingShop.getRetailShop().availableProducts.removeAll(deleteList);
        }


    }

    public void setVisitingShop(Cell cell) {
        for (StaticObject staticObject : WorldScreen.staticObjects) {
            if (staticObject.getGoToCell().getX() == cell.getX() && staticObject.getGoToCell().getY() == cell.getY()) {
                this.visitingShop = staticObject;

            }
        }
    }

    @Override
    public void run() {
        while (running) {
            this.setVisible(true);
            int time = Generators.genInteger(6, 10);
            if (supplier == null) {
                this.getClient().setNextshop();
                PathCreator.moveObject(Map.getGrid(), this, this.getCurrentCell(), this.getClient().getNextshop().getGoToCell(), time);

            } else if (client == null) {
                this.getSupplier().addNextShop();
                this.getSupplier().getNewNextShop();
                PathCreator.moveObject(Map.getGrid(), this, this.getCurrentCell(), this.getSupplier().getNextShop().getGoToCell(), time);
            }
            try {
                Thread.sleep((time * 2000) + (Generators.genInteger(1, 3) * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (this.getVisitingShop().getRetailShop() == null) {
                this.getVisitingShop().getWholesale().setPeopleCapacity(getVisitingShop().getWholesale().getPeopleCapacity() - 1);
            } else if (this.getVisitingShop().getWholesale() == null) {
                this.getVisitingShop().getRetailShop().setPeopleCapacity(getVisitingShop().getRetailShop().getPeopleCapacity() - 1);
            }
        }
    }

    public void stop() {
        this.running = false;

    }
}
