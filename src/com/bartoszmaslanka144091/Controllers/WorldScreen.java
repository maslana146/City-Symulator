package com.bartoszmaslanka144091.Controllers;

import com.bartoszmaslanka144091.Cell;
import com.bartoszmaslanka144091.Program;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

public class WorldScreen {

    public Pane worldPane;
    Program program = Program.getInstance();
    static int numCols = 10;
    static int numRows = 10;
    static int cellWidth = 50;
    static int cellHeight = 50;
    Cell[][] grid = new Cell[numCols][numRows];

    @FXML
    public void initialize() {
        for (int y = 0;y <numCols;y++){
            for (int x = 0; x < numRows; x++){
                Cell cell = new Cell(x,y,"-",true,true);
            }
        }
    }



































    }
//        GraphicsContext gc = worldCanvas.getGraphicsContext2D();
//        for (int i = 0; i < worldCanvas.widthProperty().intValue(); i += 50) {
//            for (int j = 0; j < worldCanvas.widthProperty().intValue(); j += 50) {
////                Cell cell = new Cell(i, j, null);
////                cellList.add(cell);
//            }
//        }
//        Path path = createPath();
//        Animation animation = createPathAnimation(path, Duration.seconds(1));
//        animation.play();
//    }
//
//    private Path createPath() {
//        Path path = new Path();
//        path.setStroke(Color.RED);
//        path.setStrokeWidth(10);
//        path.getElements().addAll(new MoveTo(50, 250), new LineTo(150,100),new LineTo(250,250),
//                new MoveTo(200,175), new LineTo(100, 175));
//        return path;
//    }
//
//
//    private Animation createPathAnimation(Path path, Duration duration) {
//
//        GraphicsContext gc = worldCanvas.getGraphicsContext2D();
//
//        // move a node along a path. we want its position
//        Circle pen = new Circle(0, 0, 4);
//
//        // create path transition
//        PathTransition pathTransition = new PathTransition(duration, path, pen);
//        pathTransition.currentTimeProperty().addListener(new ChangeListener<Duration>() {
//
//            Location oldLocation = null;
//
//            /**
//             * Draw a line from the old location to the new location
//             */
//            @Override
//            public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) {
//
//                // skip starting at 0/0
//                if (oldValue == Duration.ZERO)
//                    return;
//
//                // get current location
//                double x = pen.getTranslateX();
//                double y = pen.getTranslateY();
//
//                // initialize the location
//                if (oldLocation == null) {
//                    oldLocation = new Location();
//                    oldLocation.x = x;
//                    oldLocation.y = y;
//                    return;
//                }
//
//                // draw line
//                gc.setStroke(Color.BLUE);
//                gc.setFill(Color.YELLOW);
//                gc.setLineWidth(4);
//                gc.strokeLine(oldLocation.x, oldLocation.y, x, y);
//
//                // update old location with current one
//                oldLocation.x = x;
//                oldLocation.y = y;
//            }
//        });
//
//        return pathTransition;
//    }
//
//
//    public static class Location {
//        double x;
//        double y;
//    }

//}
