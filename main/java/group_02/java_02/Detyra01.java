package group_02.java_02;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Detyra01 extends Application {
    public void start(Stage stage){
//        Stage -> Scene -> Pane
        Pane pane = new Pane();

        int c = 100;
        Triangle triangle = new Triangle(c);
        triangle.setFill(null);
        triangle.setStroke(Color.GREEN);
        triangle.setStrokeWidth(5);
        triangle.setRotate(45);

//        Polygon triangle = new Polygon(c/2, 0, c, c, 0, c);
//        pane.getChildren().addAll(triangle);


//        Figura 2
//        StackPane stackPane = new StackPane();
//        Rectangle r1 = new Rectangle(0,0, 200, 100);
//        r1.setFill(Color.BLUE);
//
//        double c2 = 100 / Math.sqrt(2);
//        Rectangle r2 = new Rectangle(0,0, c2, c2);
//        r2.setFill(Color.YELLOW);
//        r2.setRotate(45);
//
//        stackPane.getChildren().addAll(r1, r2);

        CustomShape customShape = new CustomShape(200, 100);

        CustomShape2 customShape2 = new CustomShape2(3, 100);
        int n = 6;
        Group group = new Group();
        for(int i =0; i < n; i++){
            double length = 360 / (n * 2);
            Arc arc = new Arc(100, 100, 100, 100, 2 * length * i , length);
            arc.setType(ArcType.ROUND);
            group.getChildren().add(arc);
        }


        pane.getChildren().add(group);

        Scene scene = new Scene(pane);

        stage.setScene(scene);
        stage.show();
    }

}

class Triangle extends Polygon{
    private int c;
    public Triangle(int c){
        super(c/2, 0, c, c, 0, c);
        this.c = c;
    }
}

class CustomShape extends StackPane{
    private int width;
    private int height;

    public CustomShape(int width, int height){
        this.width = width;
        this.height = height;
        this.draw();
    }

    private void draw(){
        Rectangle r1 = new Rectangle(0,0, this.width, this.height);
        r1.setFill(Color.BLUE);

        double c2 = this.height / Math.sqrt(2);
        Rectangle r2 = new Rectangle(0, 0, c2, c2);
        r2.setRotate(45);
        r2.setFill(Color.YELLOW);
        this.getChildren().addAll(r1, r2);
    }
}

class CustomShape2 extends Pane{
    private int n;
    private double width;
    private double height;

    public CustomShape2(int n, double height){
        this.n = n;
        this.width = n * height;
        this.height = height;
        this.draw();
    }

    private void draw(){
        Rectangle r1 = new Rectangle(0,0, this.width, this.height);
        r1.setFill(Color.BLUE);

        HBox hBox = new HBox(30);
        double c2 = this.height / Math.sqrt(2);
        for(int i = 0; i < this.n; i++){

            Rectangle r2 = new Rectangle(0, 0, c2, c2);
            r2.setFill(Color.YELLOW);
            r2.setRotate(45);
            hBox.getChildren().addAll(r2);
        }

        this.getChildren().addAll(r1, hBox);
    }
}