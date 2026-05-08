package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import models.dto.SignupRequestDto;

public class SignupController {
    @FXML
    private TextField fullNameField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private void handleSignup(){
//        ME kriju DTO-objektin me te dhenat nga View
        SignupRequestDto request = this.createRequestDto();

    }

    private SignupRequestDto createRequestDto(){
        String fullName = this.fullNameField.getText();
        String email = this.emailField.getText();
        String username = this.usernameField.getText();
        String password = this.passwordField.getText();
        String confirmPassword = this.confirmPasswordField.getText();

        return new SignupRequestDto(
                fullName,email, username, password, confirmPassword
        );
    }

    @FXML
    private void handleGoToLogin(){

    }
}
