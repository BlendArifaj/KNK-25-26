package group_01.java_03;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Detyra01 extends Application {
//    1. Defino objektin
//    2. Defino eventin -
//    3. Defino kohen e shkaktimit te eventit
//    4. Krijo dhe fillo animacionin

    public void start(Stage stage){
        Pane pane = new Pane();
//        1. Definimi i objektit
        Circle circle = new Circle(100, 100, 50);

//        2. Definimi i eventit
        EventHandler<ActionEvent> event = new CircleColorEventHandler(circle);
//        EventHandler<ActionEvent> event2 = new CircleRadiusEventHandler(circle, 100, 500, 1);
        EventHandler<ActionEvent> event2 = new CircleMoveEventHandler(circle, 100, 500, 100, 500, 1);

//        3. Definimi i kohes se shkaktimit te eventit
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(2), event);
        KeyFrame keyFrame2 = new KeyFrame(Duration.millis(5), event2);

//        4. Krijo dhe fillo animacionin
        Timeline animacionin = new Timeline(keyFrame);
        animacionin.setCycleCount(Animation.INDEFINITE); // -1
        animacionin.play();

        Timeline animation2 = new Timeline(keyFrame2);
        animation2.setCycleCount(-1);
        animation2.play();

        pane.getChildren().add(circle);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }
}

class CircleColorEventHandler implements EventHandler<ActionEvent>{
    private Circle circle;

    public CircleColorEventHandler(Circle circle){
        this.circle = circle;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Color color = new Color(Math.random(), Math.random(), Math.random(), 1);
        this.circle.setFill(color);
    }
}

class CircleRadiusEventHandler implements EventHandler<ActionEvent>{
    private Circle circle;
    private int step;
    private int maxRadius;
    private int minRadius;
    private int sign;

    public CircleRadiusEventHandler(Circle circle, int minRadius, int maxRadius, int step){
        this.circle = circle;
        this.step = step;
        this.minRadius = minRadius;
        this.maxRadius = maxRadius;
        this.sign = 1;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
//
        double radius = this.circle.getRadius();
        if(radius >= this.maxRadius){
            this.sign = -1;
        } else if (radius <= this.minRadius) {
            this.sign = 1;
        }
        this.circle.setRadius(radius + this.step * this.sign);
    }
}

class CircleMoveEventHandler implements EventHandler<ActionEvent>{
    private Circle circle;
    private int step;
    private int maxX;
    private int minX;
    private int maxY;
    private int minY;
    private int signX;
    private int signY;

    public CircleMoveEventHandler(Circle circle, int minX, int maxX, int minY, int maxY, int step){
        this.circle = circle;
        this.step = step;
        this.minX = minX;
        this.maxX = maxX;
        this.minY = minY;
        this.maxY = maxY;
        this.signX = 1;
        this.signY = 0;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
//
        double x = this.circle.getCenterX();
        double y = this.circle.getCenterY();

        if(x <= this.minX && y <= this.minY){
            this.signX = 1;
            this.signY = 0;
        } else if (x >= this.maxX && y <= this.minY) {
            this.signX = 0;
            this.signY = 1;
        } else if( x >= this.maxX && y >= this.maxY){
            this.signX = -1;
            this.signY = -1;
        }
        this.circle.setCenterX(x + this.step * this.signX);
        this.circle.setCenterY(y + this.step * this.signY);
    }
}