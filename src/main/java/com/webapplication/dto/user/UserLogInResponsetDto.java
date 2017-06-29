package com.webapplication.dto.user;


import java.util.UUID;

public class UserLogInResponsetDto {

    private String username;

    private UUID authToken;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UUID getAuthToken() {
        return authToken;
    }

    public void setAuthToken(UUID authToken) {
        this.authToken = authToken;
    }
}
