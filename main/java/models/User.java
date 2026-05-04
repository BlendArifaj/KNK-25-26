package models;

public class User {
    private int id;
    private String username;
    private String salt;
    private String saltedHash;

    public User(int id, String username, String salt, String saltedHash) {
        this.id = id;
        this.username = username;
        this.salt = salt;
        this.saltedHash = saltedHash;
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
