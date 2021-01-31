package com.bartoszmaslanka144091;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class Map {
    static int numCols = 20;
    static int numRows = 20;
    static int cellSize = 25;
    static Cell[][] grid = new Cell[numRows][numCols];
    static List<Cell> shopCells;

    /**
     * @return getter
     */
    public static Cell[][] getGrid() {
        return grid;
    }

    /**
     * @param shopCells setter
     */
    public static void setShopCells(List<Cell> shopCells) {
        Map.shopCells = shopCells;
    }

    /**
     * @return getter
     */
    public static List<Cell> getShopCells() {
        List<Cell> cells = new ArrayList<Cell>();
        for (Cell[] row : grid) {
            for (Cell cell : row) {
                if (cell.isThereShop) {
                    cells.add(cell);
                }
            }
        }
        setShopCells(cells);
        return cells;
    }

    /**
     * creates grid map and sets available for client/suppliers
     */
    public static void createCells() {
        for (int i = 0; i < numCols; i++) {
            for (int j = 0; j < numRows; j++) {
                Cell cell = new Cell(i, j, "--", false, false);
                grid[i][j] = cell;
                if (i == 1 && j != 0 && j != 19) {
                    grid[i][j].setAvailableForClients(true);

                }
                if (i == 18 && j != 0 && j != 19) {
                    grid[i][j].setAvailableForClients(true);

                }
                if (j == 1 && i != 0 && i != 19) {
                    grid[i][j].setAvailableForClients(true);

                }
                if (j == 18 && i != 0 && i != 19) {
                    grid[i][j].setAvailableForClients(true);

                }

                if (i == 2 && j > 2 && j < 17) {
                    grid[i][j].setAvailableForSuppliers(true);

                }
                if (i == 17 && j > 2 && j < 17) {
                    grid[i][j].setAvailableForSuppliers(true);

                }
                if (j == 2 && i > 2 && i < 17) {
                    grid[i][j].setAvailableForSuppliers(true);

                }
                if (j == 17 && i > 2 && i < 17) {
                    grid[i][j].setAvailableForSuppliers(true);
                }

                if (j == 9 && i != 0 && i != 19 && i != 1 && i != 18) {
                    grid[i][j].setAvailableForSuppliers(true);
                }
                if (i == 9 && j != 0 && j != 19 && j != 1 && j != 18) {
                    grid[i][j].setAvailableForSuppliers(true);
                }
                if (i == 8 && j != 0 && j != 19) {
                    grid[i][j].setAvailableForClients(true);
                }
                if (i == 10 && j != 0 && j != 19) {
                    grid[i][j].setAvailableForClients(true);
                }
                if (j == 10 && i != 0 && i != 19) {
                    grid[i][j].setAvailableForClients(true);
                }
                if (j == 8 && i != 0 && i != 19) {
                    grid[i][j].setAvailableForClients(true);
                }
            }
        }

        grid[3][3].setAvailableForSuppliers(true);
        grid[16][16].setAvailableForSuppliers(true);
        grid[16][3].setAvailableForSuppliers(true);
        grid[3][16].setAvailableForSuppliers(true);

        grid[2][2].setThereShop(true);
        grid[2][17].setThereShop(true);
        grid[17][2].setThereShop(true);
        grid[17][17].setThereShop(true);
        grid[0][5].setThereShop(true);
        grid[4][11].setThereShop(true);
        grid[7][4].setThereShop(true);
        grid[7][7].setThereShop(true);
        grid[7][15].setThereShop(true);
        grid[11][7].setThereShop(true);
        grid[11][13].setThereShop(true);
        grid[12][19].setThereShop(true);
        grid[14][11].setThereShop(true);

        grid[17][17].setAvailableForSuppliers(true);
        grid[17][17].setAvailableForClients(true);
        grid[17][2].setAvailableForSuppliers(true);
        grid[17][2].setAvailableForClients(true);
        grid[2][2].setAvailableForSuppliers(true);
        grid[2][2].setAvailableForClients(true);
        grid[2][17].setAvailableForSuppliers(true);
        grid[2][17].setAvailableForClients(true);


        grid[12][18].setAvailableForSuppliers(true);
        grid[1][5].setAvailableForSuppliers(true);
        grid[4][10].setAvailableForSuppliers(true);
        grid[8][4].setAvailableForSuppliers(true);
        grid[8][7].setAvailableForSuppliers(true);
        grid[8][15].setAvailableForSuppliers(true);
        grid[10][7].setAvailableForSuppliers(true);
        grid[10][13].setAvailableForSuppliers(true);
        grid[14][10].setAvailableForSuppliers(true);
    }


    /**
     * @param graphicsContext color map function
     */
    public static void paintMap(GraphicsContext graphicsContext) {
        for (int i = 0; i < numCols; i++) {
            for (int j = 0; j < numRows; j++) {
                if (grid[i][j].availableForClients && !grid[i][j].availableForSuppliers) {
//                    graphicsContext.setFill(Color.LIGHTGOLDENRODYELLOW);
//                    graphicsContext.fillRect(grid[i][j].getX(), grid[i][j].getY(), 500, 500);
                    graphicsContext.drawImage(new Image("/com/bartoszmaslanka144091/resource/road_pane.png"),grid[i][j].getX(), grid[i][j].getY(),25,25);


                } else if (grid[i][j].availableForSuppliers && !grid[i][j].availableForClients) {
                    graphicsContext.drawImage(new Image("/com/bartoszmaslanka144091/resource/test_block.png"),grid[i][j].getX(), grid[i][j].getY(),25,25);
//                    graphicsContext.drawImage(new Image("/com/bartoszmaslanka144091/resource/stone_plane.png"),grid[i][j].getX(), grid[i][j].getY(),image.);
//                    graphicsContext.setFill(Color.GRAY);
//                    graphicsContext.fillRect(grid[i][j].getX(), grid[i][j].getY(), 500, 500);

                } else if (grid[i][j].availableForSuppliers && grid[i][j].availableForClients) {
                    graphicsContext.setFill(Color.LIGHTGRAY);
                    graphicsContext.fillRect(grid[i][j].getX(), grid[i][j].getY(), 500, 500);

                } else if (grid[i][j].isThereShop) {
                    graphicsContext.setFill(Color.BLACK);
                    graphicsContext.fillRect(grid[i][j].getX(), grid[i][j].getY(), 500, 500);

                } else {
                    graphicsContext.drawImage(new Image("/com/bartoszmaslanka144091/resource/grass.png"),grid[i][j].getX(), grid[i][j].getY(),25,25);
//                    graphicsContext.setFill(Color.GREEN);
//                    graphicsContext.fillRect(grid[i][j].getX(), grid[i][j].getY(), 500, 500);
                }
            }
        }

    }


}
