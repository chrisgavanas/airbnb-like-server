package com.main.webapplication.error;


public enum UserError {

    USERNAME_ALREADY_EXISTS("Username already exists");

    private String description;

    private UserError(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
