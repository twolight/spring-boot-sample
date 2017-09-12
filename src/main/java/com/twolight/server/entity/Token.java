package com.twolight.server.entity;

public class Token {

    private long userId;
    private String authentication;

    public Token(long userId, String authentication) {
        this.userId = userId;
        this.authentication = authentication;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getAuthentication() {
        return authentication;
    }

    public void setAuthentication(String authentication) {
        this.authentication = authentication;
    }

    @Override
    public String toString() {
        return userId + "." + authentication;
    }
}
