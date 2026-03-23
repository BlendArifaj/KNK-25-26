package group_02.java_01;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Detyra01 extends Application {

    public void start(Stage stage){
        // Stage -> Scene -> Pane
        // Pane -> StackPane, FlowPane, VBox, HBox, GridPane, BorderPane
        Pane pane = new Pane();
        Pane pane2 = new Pane();
        pane = new StackPane();
        pane = new FlowPane(Orientation.VERTICAL);
        pane = new VBox();
        pane = new HBox();

        Circle circle = new Circle();
        circle.setCenterX(100);
        circle.setCenterY(200);
        circle.setRadius(50);

        Rectangle rectangle = new Rectangle(0,0, 250, 130);
        rectangle.setFill(null);
        rectangle.setStroke(Color.GREEN);
        rectangle.setStrokeWidth(3);

        Line line = new Line(0,0, 300, 300);

        pane.getChildren().addAll(circle, rectangle, line, pane2);

        Scene scene = new Scene(pane);

        stage.setScene(scene);
        stage.show();
    }
}
