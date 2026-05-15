package models.dto;

public class ResetPasswordRequestDto {
    private String username;
    private String securityPin;
    private String newPassword;
    private String confirmPassword;

    public ResetPasswordRequestDto(String username, String securityPin, String newPassword, String confirmPassword) {
        this.username = username;
        this.securityPin = securityPin;
        this.newPassword = newPassword;
        this.confirmPassword = confirmPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSecurityPin() {
        return securityPin;
    }

    public void setSecurityPin(String securityPin) {
        this.securityPin = securityPin;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
