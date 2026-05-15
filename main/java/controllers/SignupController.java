package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import models.dto.SignupRequestDto;
import models.dto.SignupResponseDto;
import services.SignupService;

public class SignupController {
    private final SignupService signUpService = new SignupService();

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
    private Label messageLabel;

    @FXML
    private void handleSignup(){
        SignupRequestDto request = this.createRequestDto();

        SignupResponseDto response = this.signUpService.save(request);

//        logic ...
        if(!response.isCreated()){
            this.messageLabel.setText(response.getMessage());
        }

//        route to login

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
