package com.bartoszmaslanka144091;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Cell extends StackPane {
    int x, y;
    String type;
    boolean availableForClients;
    boolean availableForSuppliers;

    Rectangle border = new Rectangle(50,50);


    public Cell(int x, int y, String type, boolean availableForClients, boolean availableForSuppliers) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.availableForClients = availableForClients;
        this.availableForSuppliers = availableForSuppliers;

        border.setStroke(Color.LIGHTGRAY);
        setTranslateX(x * 50);
        setTranslateY(y * 50);
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
