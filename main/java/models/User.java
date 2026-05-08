package models;

public class User {
    private int id;
    private String fullName;
    private String email;
    private String username;
    private String salt;
    private String saltedHash;
    private String role;

    public User(int id, String username, String salt, String saltedHash) {
        this.id = id;
        this.username = username;
        this.salt = salt;
        this.saltedHash = saltedHash;
    }

    public User(int id, String fullName, String email, String username, String salt, String saltedHash) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.username = username;
        this.salt = salt;
        this.saltedHash = saltedHash;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getSaltedHash() {
        return saltedHash;
    }

    public void setSaltedHash(String saltedHash) {
        this.saltedHash = saltedHash;
    }
}
