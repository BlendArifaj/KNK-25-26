package group_04.java_03;

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
import javafx.stage.Stage;
import javafx.util.Duration;
import org.w3c.dom.events.Event;

import java.security.Key;
import java.sql.Time;

public class Detyra01 extends Application {
    public void start(Stage stage){
//        1. Definimi i figures
//        2. Definimi i logjikes se animacionit
//        3. Definimi periodik
//        4. Fillimi i animacionit

        Circle circle = new Circle(100, 100, 50);

        EventHandler<ActionEvent> colorEvent = new CircleColorEventHandler(circle);
        EventHandler<ActionEvent> moveEvent = new CircleMoveEventHandler(circle,
                100, 400, 1);
        EventHandler<ActionEvent> radiusEvent = new CircleRadiusEventHandler(circle,
                300, 50);

        KeyFrame frame = new KeyFrame(Duration.seconds(1), colorEvent);
        KeyFrame frame2 = new KeyFrame(Duration.millis(10), moveEvent);
        KeyFrame frame3 = new KeyFrame(Duration.millis(100), radiusEvent);

        Timeline animation = new Timeline(frame);
        animation.setCycleCount(-1);
        animation.play();

        Timeline animation2 = new Timeline(frame2);
        animation2.setCycleCount(Animation.INDEFINITE);
        animation2.play();

        Timeline animation3 = new Timeline(frame3);
        animation3.setCycleCount(-1);
        animation3.play();

        Pane pane = new Pane(circle);
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
    public void handle(ActionEvent e){
        Color color = new Color(
                Math.random(), Math.random(), Math.random(), 1
        );
        this.circle.setFill(color);
    }
}

class CircleMoveEventHandler implements EventHandler<ActionEvent>{
    private Circle circle;
    private int startX;
    private int endX;
    private int step;

    public CircleMoveEventHandler(Circle circle, int startX, int endX, int step) {
        this.circle = circle;
        this.startX = startX;
        this.endX = endX;
        this.step = step;
    }

    public void handle(ActionEvent e){
        double x = this.circle.getCenterX();

        if(x > this.endX || x < this.startX){
            this.step *= -1;
        }

        this.circle.setCenterX(x + this.step);
    }
}

class CircleRadiusEventHandler implements EventHandler<ActionEvent>{
    private Circle circle;
    private int maxRadius;
    private int minRadius;
    private int step = 1;

    public CircleRadiusEventHandler(Circle circle, int maxRadius, int minRadius) {
        this.circle = circle;
        this.maxRadius = maxRadius;
        this.minRadius = minRadius;
    }

    public void handle(ActionEvent e){
        double radius = this.circle.getRadius();
        if(radius > maxRadius){
            step = -1;
        }else if(radius < minRadius ){
            step = 1;
        }
        this.circle.setRadius(radius + step);
    }
}