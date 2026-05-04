package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import models.dto.LoginRequestDto;
import models.dto.LoginResponseDto;
import services.AuthService;

public class LoginController {

    private final AuthService authService = new AuthService();

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;


    @FXML
    private void handleLogin(){
        String username = this.usernameField.getText();
        String password = this.passwordField.getText();

        LoginRequestDto loginDto = new LoginRequestDto(username, password);

        LoginResponseDto response = this.authService.login(loginDto);

//        logic ...
    }

    @FXML
    private void handleForgotPassword(){

    }
}
