package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(
                getClass().getResource("/views/login-view.fxml")
        );
        Pane pane = fxmlLoader.load();

        Scene scene = new Scene(pane);

        stage.setScene(scene);
        stage.show();
    }
}
