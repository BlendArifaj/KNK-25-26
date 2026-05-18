package app;


public enum ViewEnum{
    LOGIN_VIEW("/views/login-view.fxml"),
    HOME_VIEW("/views/home-view.fxml"),
    SIGNUP_VIEW("/views/signup-view.fxml"),
    CREATE_APPOINTMENT("/views/create-appointment-view.fxml");

    private String viewPath;

    ViewEnum(String viewPath){
        this.viewPath = viewPath;
    }

    public String value(){
        return this.viewPath;
    }
}

