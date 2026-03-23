package group_04.java_01;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class Detyra01 extends Application {

    public void start(Stage stage){
//        Stage -> Scene -> Pane -> Node
//        Pane -> StackPane, FlowPane, VBox, HBox, BorderPane, GridPane
        Pane pane = new Pane();

        pane = new StackPane();
        pane = new FlowPane(Orientation.VERTICAL);
        pane = new VBox();
        pane = new HBox();

//        Polygon, Polyline, Circle, Rectangle, Line, Arc, Ellipse
        Polygon polygon = new Polygon(0,0, 100, 100, 150, 100, 200, 300);
        polygon.setFill(null);
        polygon.setStroke(Color.GREEN);
        polygon.setStrokeWidth(3);

        Circle circle = new Circle(100, 100, 50);

        Shape rectangle = new Rectangle(150, 150, 200, 150);

        Line line = new Line(0,0, 400, 400);

        pane.getChildren().addAll(polygon, circle, rectangle, line);


        Pane mainPane = new VBox();
        Pane row1 = new HBox();
        Pane row2 = new HBox();

        mainPane.getChildren().addAll(row1, row2);


        Scene scene = new Scene(pane);

        stage.setScene(scene);
        stage.show();
    }
}
