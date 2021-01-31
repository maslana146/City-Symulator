package com.bartoszmaslanka144091;

import javafx.animation.PathTransition;
import javafx.application.Platform;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;


public class PathCreator {


    /**
     * main path finding function
     * @param start start cell
     * @param end end cell
     * @param grid map
     * @param obj object
     * @return
     */
    public static List<Cell> findPath(Cell start, Cell end, Cell[][] grid, MovingObject obj) {
        List<Cell> visited = new ArrayList<Cell>();
        List<Cell> path = new ArrayList<Cell>();
        visited.add(start);
        path.add(start);
        boolean success = false;
        Cell nextMove = start;
        if (start == end) {
            return path;
        }
        int x = 0;
        while (!success) {
            x += 1;
            if (x > 100) {
//                System.out.println("PathERROR");
                Platform.exit();
                break;
            }

            List<Cell> neighbors = getNeighbors(grid, nextMove, obj);
            double minDist = 1000;
            if (nextMove.getX() == end.getX() && nextMove.getY() == end.getY()) {
                success = true;
                return path;
            }
            for (Cell cell : neighbors) {
                if (visited.contains(cell)) {
                    continue;
                } else {
                    int cellX = cell.getX() / Map.cellSize;
                    int cellY = cell.getY() / Map.cellSize;
                    double newMinDist = euclideanDist(cellX, cellY, end.getX() / Map.cellSize, end.getY() / Map.cellSize);
                    if (newMinDist < minDist) {
                        if (cell.getX() == end.getX() && cell.getY() == end.getY()) {
                            path.add(cell);
                            return path;
                        }
                        List<Cell> check = getNeighbors(grid, cell, obj);
                        //check.size() <= 1 &&
                        if (check.size() > 1) {
                            minDist = newMinDist;
                            nextMove = cell;
                            visited.add(cell);
                        }
                    }
                }
            }
            path.add(nextMove);

        }
        return path;
    }

    /**
     * calculates euclidean distance between two points
     * @param startX
     * @param startY
     * @param endX
     * @param endY
     * @return
     */
    public static double euclideanDist(int startX, int startY, int endX, int endY) {
        double distance;
        distance = Math.sqrt(Math.pow((startX - endX), 2) + Math.pow((startY - endY), 2));
        return distance;
    }

    /**
     * checks if the cell is valid ( available for object )
     * @param grid
     * @param x
     * @param y
     * @param obj
     * @return
     */
    public static boolean isValidCell(Cell[][] grid, int x, int y, MovingObject obj) {
        if (obj.getClient() == null) {
            return !(x < 0 || x >= grid.length || y < 0 || y >= grid.length) && (grid[x][y].availableForSuppliers);
        } else {
            return !(x < 0 || x >= grid.length || y < 0 || y >= grid.length) && (grid[x][y].availableForClients);
        }
    }

    /**
     * returns list of available neighbours cells
     * @param grid
     * @param cell
     * @param obj
     * @return
     */
    public static List<Cell> getNeighbors(Cell[][] grid, Cell cell, MovingObject obj) {
        List<Cell> neighbors = new ArrayList<Cell>();

        if (isValidCell(grid, cell.getX() / Map.cellSize - 1, cell.getY() / Map.cellSize, obj)) {
            neighbors.add(grid[cell.getX() / Map.cellSize - 1][cell.getY() / Map.cellSize]);
        }

        if (isValidCell(grid, cell.getX() / Map.cellSize + 1, cell.getY() / Map.cellSize, obj)) {
            neighbors.add(grid[cell.getX() / Map.cellSize + 1][cell.getY() / Map.cellSize]);
        }

        if (isValidCell(grid, cell.getX() / Map.cellSize, cell.getY() / Map.cellSize - 1, obj)) {
            neighbors.add(grid[cell.getX() / Map.cellSize][cell.getY() / Map.cellSize - 1]);
        }

        if (isValidCell(grid, cell.getX() / Map.cellSize, cell.getY() / Map.cellSize + 1, obj)) {
            neighbors.add(grid[cell.getX() / Map.cellSize][cell.getY() / Map.cellSize + 1]);
        }

        return neighbors;
    }

    /** transofrm path to scene.shape.path moves
     * @param list
     * @return
     */
    public static Path createPath(List<Cell> list) {
        javafx.scene.shape.Path path = new javafx.scene.shape.Path();
        MoveTo start = new MoveTo(list.get(0).getCenterX(), list.get(0).getCenterY());
        path.getElements().add(start);
        for (int i = 1; i < list.size(); i++) {
            path.getElements().add(new LineTo(list.get(i).getCenterX(), list.get(i).getCenterY()));
        }
        return path;

    }

    /**
     * move object function which start animation and set some other functions on finisched
     * @param grid
     * @param obj
     * @param start
     * @param end
     * @param time
     */
    public static void moveObject(Cell[][] grid, MovingObject obj, Cell start, Cell end, int time) {
        List<Cell> listOfCells = findPath(start, end, grid,obj);
        Path path = createPath(listOfCells);
        PathTransition animation = new PathTransition(Duration.seconds(time), path, obj);
        animation.setOnFinished(event -> {


            obj.setCurrentCell();
            obj.setVisitingShop(obj.getCurrentCell());

            obj.action();
            obj.coronaVirus();
        });
        animation.play();


    }
}
