package com.webapplication.dto.user;


import java.time.LocalDateTime;

public class SessionInfo {

    private final Integer userId;
    private LocalDateTime date;

    public SessionInfo(Integer userId, LocalDateTime date) {
        this.userId = userId;
        this.date = date;
    }

    public Integer getUserId() {
        return userId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

}