package ru.parsentev.models;

/**
 * Created by art on 20.06.16.
 */
public class Message extends Base {

    private User user;
    private String text;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
