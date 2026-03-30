package group_01.java_02;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class Detyra01 extends Application {
    public void start(Stage stage){
//        Pane -> Scene -> Stage

        Circle circle = new Circle(100, 100, 50);
//
        Rectangle rectangle = new Rectangle(0,0, 120, 120);
        rectangle.setFill(Color.BLUE);
        Triangle triangle = new Triangle(100);
        triangle.setFill(Color.YELLOW);
        triangle.setStroke(Color.GREEN);
        triangle.setRotate(90);

        CustomRect cr = new CustomRect(300, 200);
        Group group = new Group();
        int n = 8;
        for(int i = 0; i< n; i++){
//            0 - 45 (i = 0)
//            90 - 135 (i = 1) 1 * 2 * 45 = 90
//            180 - 225 (i = 2) 2 * 2 * 45 = 180
//            270 - 315 (i = 3) 3 * 2 * 45 = 270
            int angle = 360 / (2 * n);
            Arc arc = new Arc(100, 100, 100, 100, i * 2 * angle, angle);

            arc.setType(ArcType.ROUND);
            group.getChildren().addAll(arc);
        }
//        int c = 100;
//        Polygon triangle = new Polygon(
//           c/2, 0, c, c, 0, c
//        );
        Pane pane = new Pane(group);
//        pane.getChildren().addAll(triangle)
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }
}


class CustomRect extends Pane{
    private int width;
    private int height;
    public CustomRect(int width, int height){
        this.width = width;
        this.height = height;
        this.draw();
    }
    private void draw(){
        Rectangle rectangle = new Rectangle(0,0, this.width, this.height);
        rectangle.setFill(this.getRandomColor());
        Polygon triangle = new Polygon(
                0,0, this.width, this.height * 0.5, 0, this.height
        );
        triangle.setFill(this.getRandomColor());
        this.getChildren().clear();
        this.getChildren().addAll(rectangle, triangle);
    }

    private Color getRandomColor(){
        return new Color(Math.random(), Math.random(), Math.random(), Math.random());
    }
}
class Triangle extends Polygon{
    private int c;
    public Triangle(int c){
        super(c/2, 0, c, c, 0, c);
        this.c = c;
    }
    public int getC(){
        return this.c;
    }
}