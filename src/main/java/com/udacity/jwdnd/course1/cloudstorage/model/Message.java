package com.udacity.jwdnd.course1.cloudstorage.model;

public class Message {
    private String text,username;

    public Message(String text, String username) {
        this.text = text;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
