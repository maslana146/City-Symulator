package com.bartoszmaslanka144091;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import java.awt.event.MouseEvent;
import java.util.concurrent.TimeUnit;

public class MovingObject extends Circle implements Runnable {
    Client client = null;
    Supplier supplier = null;
    Cell currentCell = Map.grid[9][1];

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

    public MovingObject(double centerX, double centerY, double radius, Paint fill, Client client, Supplier supplier) {
        super(centerX, centerY, radius, fill);
        this.client = client;
        this.supplier = supplier;
    }

    public void onClick(MouseEvent event) {

    }

    public void setCurrentCell() {
        Cell[][] grid = Map.getGrid();
        int x = (int) (getTranslateX() - 12) / 25;
        int y = (int) (getTranslateY() - 12) / 25;
        System.out.println("To jes curr cel; " + x + " " + y);
        this.currentCell = grid[x][y];
    }


    public Cell getCurrentCell() {
        return currentCell;
    }

    @Override
    public void run() {
        while (true) {
            int time = Generators.genInteger(4,10);
            this.getClient().setNextshop();
            PathCreator.moveObject(Map.getGrid(), this, this.getCurrentCell(), this.getClient().getNextshop().getGoToCell(),time);
            try {
                TimeUnit.SECONDS.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
