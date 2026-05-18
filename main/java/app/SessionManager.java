package app;

import models.User;

public class SessionManager {
    private static User currentUser;

    private SessionManager(){}

    public static void login(User user){
        SessionManager.currentUser = user;
    }

    public static void logout(){
        SessionManager.currentUser = null;
    }

    public static User getCurrentUser(){
        return SessionManager.currentUser;
    }
}
