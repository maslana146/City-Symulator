package com.bartoszmaslanka144091;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Cell extends StackPane {
    int x, y;
    String type;
    boolean availableForClients;
    boolean availableForSuppliers;
    int centerX;
    int centerY;

    Rectangle border = new Rectangle(50,50);


    public Cell(int x, int y, String type, boolean availableForClients, boolean availableForSuppliers) {
        this.x = x * 50;
        this.y = y * 50;
        this.type = type;
        this.availableForClients = availableForClients;
        this.availableForSuppliers = availableForSuppliers;
        this.centerX = this.x + 25;
        this.centerY = this.y + 25;
        border.setStroke(Color.LIGHTGRAY);


    }

    @Override
    public String toString() {
        return "Cell{" +
                "x=" + x +
                ", y=" + y +
                ", for clients=" + availableForClients +
                '}';
    }

    public int getCenterX() {
        return centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAvailableForClients(boolean availableForClients) {
        this.availableForClients = availableForClients;
    }

    public void setAvailableForSuppliers(boolean availableForSuppliers) {
        this.availableForSuppliers = availableForSuppliers;
    }

    public void setBorder(Rectangle border) {
        this.border = border;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getType() {
        return type;
    }

    public boolean isAvailableForClients() {
        return availableForClients;
    }

    public boolean isAvailableForSuppliers() {
        return availableForSuppliers;
    }
}
