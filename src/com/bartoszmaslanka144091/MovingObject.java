package com.bartoszmaslanka144091;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import java.awt.event.MouseEvent;

public class MovingObject extends Circle {
    Client client = null;
    Supplier supplier = null;

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

    public void onClick(MouseEvent event){

    }
    public Cell getCurrentCell(){
        Cell[][] grid = Map.getGrid();
        int x = (int)(getTranslateX()-12)/25;
        int y = (int)(getTranslateY()-12)/25;
        System.out.println("To jes curr cel; "+x+" "+y);
        return grid[x][y];
    }
}
