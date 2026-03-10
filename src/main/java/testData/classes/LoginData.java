package testData.classes;

import utils.Reader;

public class LoginData {
    private String username;
    private String password;

    // Constructor
    public LoginData(String filename) {
        this.username = Reader.json(filename).get("username").toString();
        this.password = Reader.json(filename).get("password").toString();
    }

    // Getter username
    public String getUsername() {
        return username;
    }

    // Getter password
    public String getPassword() {
        return password;
    }

    // Setter username
    public void setUsername(String username) {
        this.username = username;
    }

    // Setter password
    public void setPassword(String password) {
        this.password = password;
    }
}
