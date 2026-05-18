package app;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Router {

    private static Stage stage;

    private Router() {}

    public static void setStage(Stage stage) {
        Router.stage = stage;
    }

    private static Pane loadPane(String viewPath) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    Router.class.getResource(viewPath)
            );

            return loader.load();

        } catch (IOException e) {
            throw new RuntimeException("Failed to load view: " + viewPath, e);
        }
    }

    public static void navigateTo(ViewEnum view) {
        Pane pane = loadPane(view.value());

        stage.setScene(new Scene(pane));
    }

    public static void navigateContentTo(ViewEnum view, Pane content) {
        Pane pane = loadPane(view.value());

        content.getChildren().setAll(pane);
    }


}