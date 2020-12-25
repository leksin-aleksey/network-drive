package org.geekbrains.networkstorage.user;

public class UserAuth {
    private String login;
    private String password;

    public UserAuth(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public User authenticate(){
        /* TODO DB check */
        return new User(1, getLogin());
    }
}
