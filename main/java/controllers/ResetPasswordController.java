package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import models.dto.ResetPasswordRequestDto;
import models.dto.ResetPasswordResponseDto;
import services.ResetPasswordService;

public class ResetPasswordController {
    private final ResetPasswordService resetPasswordService = new ResetPasswordService();

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField securityPinField;

    @FXML
    private PasswordField newPasswordField;

    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private Label messageLabel;

    @FXML
    private void handleResetPassword(){
        ResetPasswordRequestDto requestDto = this.createRequestDto();

        ResetPasswordResponseDto response = this.resetPasswordService.reset(requestDto);

        if(!response.isSuccess()){
            this.messageLabel.setText(response.getMessage());
//            logic ...
        }
//        logic ...
    }

    private ResetPasswordRequestDto createRequestDto(){
        String username = this.usernameField.getText();
        String securityPin = this.securityPinField.getText();
        String newPassword = this.newPasswordField.getText();
        String confirmPassword = this.confirmPasswordField.getText();

        return new ResetPasswordRequestDto(
                username, securityPin, newPassword, confirmPassword
        );
    }
    @FXML
    private void handleBackToLogin(){

    }
}
