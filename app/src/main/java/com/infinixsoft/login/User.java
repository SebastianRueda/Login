package com.infinixsoft.login;

public class User {
    private String user;
    private String email;
    private String password;
    private boolean logged;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getLogged() {
        return logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }

    public User() {
    }

    public User(String user, String email, String password) {
        this.user = user;
        this.email = email;
        this.password = password;
        this.logged = false;
    }

    public User(String user, String email, String password, boolean logged) {
        this.user = user;
        this.email = email;
        this.password = password;
        this.logged = logged;
    }
}
