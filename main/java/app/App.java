package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Router.setStage(stage);

        Router.navigateTo(ViewEnum.LOGIN_VIEW);


        stage.show();
    }
}
