package models.dto;

public class LoginResponseDto {
    private boolean login;
    private String message;

    public LoginResponseDto(boolean login, String message) {
        this.login = login;
        this.message = message;
    }

    public LoginResponseDto(boolean login) {
        this.login = login;
        this.message = "";
    }

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
