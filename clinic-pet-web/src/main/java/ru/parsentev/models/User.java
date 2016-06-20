package ru.parsentev.models;

/**
 * Created by art on 25.05.16.
 */
public class User extends Base {

    private String login;
    private String email;

    public User(){

    }

    public User(int id, String login, String email) {
        this.id = id;
        this.login = login;
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login){
        this.login = login;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }
}
