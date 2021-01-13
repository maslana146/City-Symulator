package com.bartoszmaslanka144091.Controllers;

import com.bartoszmaslanka144091.Cell;
import com.bartoszmaslanka144091.Map;
import com.bartoszmaslanka144091.PathCreator;
import com.bartoszmaslanka144091.Program;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class WorldScreen {

    public Canvas worldCanvas;
    public Pane worldPane;
    Program program = Program.getInstance();
    static int numCols = 10;
    static int numRows = 10;
    static int cellWidth = 50;
    static int cellHeight = 50;
    static int speed = 5;
    Cell[][] grid = new Cell[numCols][numRows];


    @FXML
    public void initialize() {

        GraphicsContext gc = worldCanvas.getGraphicsContext2D();
        Map.createCells();
        Map.paintMap(gc);

        Cell[][] grid = Map.getGrid();
//        List<Cell> list = PathCreator.findPath(grid[0][0], grid[9][9], grid);
        Circle circle = new Circle(0, 0, 12.5, Color.RED);
        worldPane.getChildren().addAll(circle);
//        Path path = (Path) PathCreator.createPath(list);
        PathCreator.moveObject(grid,circle,grid[0][5],grid[9][5]);

//        System.out.println("elo");
//        for (PathElement element : path.getElements()) {
//            System.out.println(element);
//        }
//        Circle circle = new Circle(0, 0, 12.5, Color.RED);
//        worldPane.getChildren().addAll(circle);
//        PathTransition pathTransition = new PathTransition(Duration.seconds(8), path, circle);
//        EventHandler<MouseEvent> eventEventHandler = new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                circle.setFill(Color.BISQUE);
//            }
//        };
//        circle.addEventFilter(MouseEvent.MOUSE_CLICKED,eventEventHandler);
//        pathTransition.play();


    }
}
