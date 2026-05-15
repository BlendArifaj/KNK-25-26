package models.dto;

public class ResetPasswordResponseDto {
    private boolean success;
    private String message;

    public ResetPasswordResponseDto(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public ResetPasswordResponseDto(boolean success) {
        this.success = success;
        this.message = "";
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
