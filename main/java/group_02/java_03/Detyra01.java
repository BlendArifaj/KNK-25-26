package group_02.java_03;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Detyra01 extends Application {
    // 1. Definimi i figures (psh. Rreth, Trekendesh, CustomShape)
    // 2. Definimi i event-it (cka do te ndodh)
    // 3. Definimi i kohes se animacionit
    // 4. Fillimi i animacionit

    public void start(Stage stage){
        Pane pane = new Pane();
        // 1. Figura
        Rectangle rect = new Rectangle(100, 100, 200, 100);

        // 2. Event-i
        EventHandler<ActionEvent> event = new RectangleColorleEventHandler(rect);
        EventHandler<ActionEvent> event2 = new RectangleMoveEventHandler(rect, 100, 500, 1);
        // 3. Definimi periodik
        KeyFrame keyFrame = new KeyFrame(Duration.millis(100), event);
        KeyFrame keyFrame2 = new KeyFrame(Duration.millis(10), event2);

        // 4. Animacioni
        Timeline animation = new Timeline(keyFrame);
        animation.setCycleCount(-1); // Animation.INDEFINITE
        animation.play();

        Timeline animation2 = new Timeline(keyFrame2);
        animation2.setCycleCount(Animation.INDEFINITE);
        animation2.play();

        pane.getChildren().addAll(rect);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }
}

class RectangleColorleEventHandler implements EventHandler<ActionEvent>{
    private Rectangle rect;

    public RectangleColorleEventHandler(Rectangle rect){
        this.rect = rect;
    }

    public void handle(ActionEvent e){
        Color color = new Color(Math.random(), Math.random(), Math.random(), 1);
        this.rect.setFill(color);
    }
}

class RectangleMoveEventHandler implements EventHandler<ActionEvent>{
    private Rectangle rect;
    private int min;
    private int max;
    private int step;
    private int directionX; // -1, 0, 1
    private int directionY; // -1, 0, 1
    private boolean direction;

    public RectangleMoveEventHandler(Rectangle rect, int min, int max, int step){
        this.rect = rect;
        this.min = min;
        this.max = max;
        this.step = step;
        this.directionX = 1;
        this.directionY = 0;
        this.direction = true;
    }

    public void handle(ActionEvent e){
        double x = this.rect.getX();
        double y = this.rect.getY();

        if(x <= min && y <= min){ // A
            this.direction = !this.direction;
            if(direction){
                this.directionX = 1;
                this.directionY = 0;
            }else{
                this.directionX = 0;
                this.directionY = 1;
            }
        }else if(x >= max && y <= min){ // B
            if(direction){
                this.directionX = 0;
                this.directionY = 1;
            }else{
                this.directionX = -1;
                this.directionY = 0;
            }

        }else if(x >= max && y >= max){ // C
//            this.directionX = -1;
//            this.directionY = -1;
            if(direction){
                this.directionX = -1;
                this.directionY = 0;
            }else{
                this.directionX = 0;
                this.directionY = -1;
            }

        }else if(x <= min && y >= max){ // D
            if(direction){
                this.directionX = 0;
                this.directionY = -1;
            }else{
                this.directionX = 1;
                this.directionY = 0;
            }

        }

        this.rect.setX(x + this.step * this.directionX);
        this.rect.setY(y + this.step * this.directionY);
    }
}