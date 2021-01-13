package com.bartoszmaslanka144091;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Map {
    static int numCols = 10;
    static int numRows = 10;
    static int cellSize = 50;
    static Cell[][] grid = new Cell[numRows][numCols];

    public static Cell[][] getGrid() {
        return grid;
    }

    public static void createCells() {
        for (int i = 0; i < numCols; i++) {
            for (int j = 0; j < numRows; j++) {
                Cell cell = new Cell(i, j, "--", false, false);
                grid[i][j] = cell;
                if (i == 0) {
                    grid[i][j].setAvailableForClients(true);

                }
                if (j == 9) {
                    grid[i][j].setAvailableForClients(true);

                }
//                System.out.println(grid[i][j]);
            }
        }
        grid[1][4].setAvailableForClients(true);
        grid[2][4].setAvailableForClients(true);
        grid[3][4].setAvailableForClients(true);
        grid[4][4].setAvailableForClients(true);
        grid[4][5].setAvailableForClients(true);
        grid[4][6].setAvailableForClients(true);
        grid[4][7].setAvailableForClients(true);
        grid[4][8].setAvailableForClients(true);
        grid[4][9].setAvailableForClients(true);
        grid[5][4].setAvailableForClients(true);
        grid[6][4].setAvailableForClients(true);
        grid[7][4].setAvailableForClients(true);
        grid[8][4].setAvailableForClients(true);
        grid[9][4].setAvailableForClients(true);
        grid[9][5].setAvailableForClients(true);
        grid[9][6].setAvailableForClients(true);
        grid[9][7].setAvailableForClients(true);
        grid[9][8].setAvailableForClients(true);


    }

    public static void paintMap(GraphicsContext graphicsContext) {
        for (int i = 0; i < numCols; i++) {
            for (int j = 0; j < numRows; j++) {
                if (grid[i][j].availableForClients) {
                    graphicsContext.setFill(Color.GREEN);
                    graphicsContext.fillRect(grid[i][j].getX(), grid[i][j].getY(), 500, 500);
                } else {
                    graphicsContext.setFill(Color.LIGHTGOLDENRODYELLOW);
                    graphicsContext.fillRect(grid[i][j].getX(), grid[i][j].getY(), 500, 500);
                }
            }
        }

    }
//TODO dodaj funkcje wyswietlajaca patha( ruszjacy sie obiekt

}
