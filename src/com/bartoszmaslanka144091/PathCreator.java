package com.bartoszmaslanka144091;

import javafx.animation.PathTransition;
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;


public class PathCreator {
    public static List<Cell> findPath(Cell start, Cell end, Cell[][] grid) {
        List<Cell> visited = new ArrayList<Cell>();
        List<Cell> path = new ArrayList<Cell>();
        boolean success = false;
        Cell nextMove = start;
        while (!success) {
            List<Cell> neighbors = getNeighbors(grid, nextMove);
            double minDist = 1000;
            if (nextMove == end) {
                success = true;
                return path;
            }
            for (Cell cell : neighbors) {
                if (visited.contains(cell)) {
                    continue;
                } else {
                    int cellX = cell.getX() / 50;
                    int cellY = cell.getY() / 50;
                    double newMinDist = euclideanDist(cellX, cellY, end.getX(), end.getY());
                    visited.add(cell);
                    if (newMinDist < minDist) {
                        minDist = newMinDist;
                        nextMove = cell;
                    }
                }
            }
            path.add(nextMove);

        }
        return path;
    }

    public static double euclideanDist(int startX, int startY, int endX, int endY) {
        double distance;
        distance = Math.sqrt(Math.pow((startX - endX), 2) + Math.pow((startY - endY), 2));
        return distance;
    }

    public static boolean isValidCell(Cell[][] grid, int x, int y) {
        return !(x < 0 || x >= grid.length || y < 0 || y >= grid.length) && (grid[x][y].availableForClients);
    }

    public static List<Cell> getNeighbors(Cell[][] grid, Cell cell) {
        List<Cell> neighbors = new ArrayList<Cell>();

        if (isValidCell(grid, cell.getX() / 50 - 1, cell.getY() / 50)) {
            neighbors.add(grid[cell.getX() / 50 - 1][cell.getY() / 50]);
        }

        if (isValidCell(grid, cell.getX() / 50 + 1, cell.getY() / 50)) {
            neighbors.add(grid[cell.getX() / 50 + 1][cell.getY() / 50]);
        }

        if (isValidCell(grid, cell.getX() / 50, cell.getY() / 50 - 1)) {
            neighbors.add(grid[cell.getX() / 50][cell.getY() / 50 - 1]);
        }

        if (isValidCell(grid, cell.getX() / 50, cell.getY() / 50 + 1)) {
            neighbors.add(grid[cell.getX() / 50][cell.getY() / 50 + 1]);
        }

        return neighbors;
    }

    public static Path createPath(List<Cell> list) {
        javafx.scene.shape.Path path = new javafx.scene.shape.Path();
        MoveTo start = new MoveTo(list.get(0).getCenterX(), list.get(0).getCenterY());
        path.getElements().add(start);
        for (int i = 1; i < list.size(); i++) {
            path.getElements().add(new LineTo(list.get(i).getCenterX(), list.get(i).getCenterY()));
        }
        return path;

    }
    public static void moveObject(Cell[][] grid, Circle obj,Cell start, Cell end){
        List<Cell> listOfCells = findPath(start,end,grid);
        Path path = createPath(listOfCells);
        PathTransition animation = new PathTransition(Duration.seconds(7),path,obj);
        animation.play();

    }
}
