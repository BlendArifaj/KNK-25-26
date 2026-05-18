package controllers;

import app.Router;
import app.SessionManager;
import app.ViewEnum;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

public class HomeController {

    @FXML
    private Pane contentPane;

    @FXML
    private void handleBtnClick(){
        Router.navigateContentTo(ViewEnum.CREATE_APPOINTMENT, this.contentPane);
    }
}
