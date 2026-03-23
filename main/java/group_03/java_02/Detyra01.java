package group_03.java_02;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class Detyra01 extends Application {
    public void start(Stage stage){
//        Stage -> Scene -> Pane
        Pane pane = new Pane();

//        Triangle triangle = new Triangle(100);
        int c = 100;
//        Polygon triangle = new Polygon(0, c, c / 2, 0, c, c);
        Triangle triangle = new Triangle(c);
        triangle.setFill(null);
        triangle.setStroke(Color.BLUE);
        triangle.setRotate(90);
        pane.getChildren().addAll(triangle);


//        Figura 2:
        StackPane stackPane = new StackPane();
        int r = 200;
        Rectangle rect = new Rectangle(0,0, r, r);
        rect.setFill(Color.BLUE);
        int r2 = r / 2;
        Circle circle = new Circle(0, 0, r2);
        circle.setFill(Color.GREEN);
        stackPane.getChildren().addAll(rect, circle);

        CustomShape customShape1 = new CustomShape(200);
        CustomShape2 customShape2 = new CustomShape2(200, 5);
//
        pane.getChildren().add(customShape2);


        pane.getChildren().clear();
        int n = 4;
        double length = 180 / n;
        Group group = new Group();
        for(int i = 0; i < n; i++){
            Arc arc = new Arc(300, 300, 200, 200, i * length * 2, length);
            arc.setType(ArcType.ROUND);
            group.getChildren().addAll(arc);
        }
        pane.getChildren().addAll(group);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }
}

class Triangle extends Polygon{
    private int c;
    public Triangle(int c){
        super(0, c, c / 2, 0, c, c);
        this.c = c;
    }

    public Triangle(int c, int x, int y){
        super(x, c, c / 2, y, c, c);
        this.c = c;
    }
}

class CustomShape extends StackPane{
    private int r;
    public CustomShape(int r){
        super();
        this.r = r;
        this.draw();
    }

    private Color getRandomColor(){
        return new Color(Math.random(), Math.random(), Math.random(), 1);
    }

    private void draw(){
        Rectangle rect = new Rectangle(0, 0, this.r, this.r);
        rect.setFill(this.getRandomColor());
        int r2 = this.r / 2;
        Circle circle = new Circle(0, 0, r2);
        circle.setFill(this.getRandomColor());
        this.getChildren().addAll(rect, circle);
    }
}

class CustomShape2 extends StackPane{
    private int r;
    private int n;
    public CustomShape2(int r, int n){
        super();
        this.r = r;
        this.n = n;
        this.draw();
    }

    private Color getRandomColor(){
        return new Color(Math.random(), Math.random(), Math.random(), 1);
    }

    private void draw(){
        Rectangle rect = new Rectangle(0, 0, this.r * this.n, this.r);
        rect.setFill(this.getRandomColor());

        int r2 = this.r / 2;

        // Figura 3
        HBox hBox = new HBox();
        for(int i = 0; i < this.n; i++){
            Circle circle = new Circle(0, 0, r2);
            circle.setFill(this.getRandomColor());
            hBox.getChildren().add(circle);
        }
        //
        this.getChildren().addAll(rect, hBox);
    }
}