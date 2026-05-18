package controllers;

import app.Router;
import app.ViewEnum;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import models.dto.LoginRequestDto;
import models.dto.LoginResponseDto;
import services.LoginService;

import java.util.Locale;

public class LoginController {

    private final LoginService loginService = new LoginService();

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;


    @FXML
    private void handleLogin(){

        String username = this.usernameField.getText();
        String password = this.passwordField.getText();

        LoginRequestDto loginDto = new LoginRequestDto(username, password);

        LoginResponseDto response = this.loginService.login(loginDto);


        Router.navigateTo(ViewEnum.HOME_VIEW);

        if(response.isLogin()){
//            SessionManager.login(response.getUser());
        }
//        logic ...
    }

    @FXML
    private void handleForgotPassword(){

    }
}
