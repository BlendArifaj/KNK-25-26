package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import models.dto.LoginRequestDto;
import models.dto.LoginResponseDto;
import services.LoginService;

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


        if(response.isLogin()){

        }
//        logic ...
    }

    @FXML
    private void handleForgotPassword(){

    }
}
