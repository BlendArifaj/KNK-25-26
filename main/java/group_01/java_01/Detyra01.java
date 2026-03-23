package group_01.java_01;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class Detyra01 extends Application {

    @Override
    public void start(Stage stage){
        // Stage -> Scene -> Pane
        // StackPane, FlowPane, VBox, HBox, BorderPane, GridPane
        Pane pane = new VBox();
        HBox hbox1 = new HBox();
        HBox hbox2 = new HBox();

        Circle circle1 = new Circle(100, 100, 100);
        Circle circle2 = new Circle(100, 100, 100);
        Circle circle3 = new Circle(100, 100, 100);
        Circle circle4 = new Circle(100, 100, 100);
        Circle circle5 = new Circle(100, 100, 100);
        Circle circle6 = new Circle(100, 100, 100);
        Circle circle7 = new Circle(100, 100, 100);
        Circle circle8 = new Circle(100, 100, 100);

        pane.getChildren().addAll(hbox1, hbox2);
        hbox1.getChildren().addAll(circle1, circle2, circle3, circle4);
        hbox2.getChildren().addAll(circle5, circle6, circle7, circle8);


        Rectangle rect = new Rectangle(100, 100, 100, 50);
        rect.setFill(null);
        rect.setStroke(Color.GREEN);
        rect.setStrokeWidth(2);

        Line line = new Line(0,0, 150, 150);
        line.setStroke(Color.RED);
        line.setStrokeWidth(5);

        Polygon polygon = new Polygon(0,0, 100, 100, 150, 100, 200, 200, 320, 450);
        polygon.setFill(null);
        polygon.setStroke(Color.GRAY);
        polygon.setStrokeWidth(3);


        Polyline polyline = new Polyline(0,0, 100, 100, 150, 100, 200, 200, 80, 90);
        polyline.setFill(null);
        polyline.setStroke(Color.BROWN);
        polyline.setStrokeWidth(5);

        pane.getChildren().addAll(polyline, rect, line, polygon);

        Scene scene = new Scene(pane);

        stage.setScene(scene);
        stage.show();
    }
}
