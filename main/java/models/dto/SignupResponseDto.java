package models.dto;

public class SignupResponseDto {
    private boolean created;
    private String message;

    public SignupResponseDto(boolean created, String message) {
        this.created = created;
        this.message = message;
    }

    public SignupResponseDto(boolean created) {
        this.created = created;
        this.message = "";
    }

    public boolean isCreated() {
        return created;
    }

    public void setCreated(boolean created) {
        this.created = created;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
