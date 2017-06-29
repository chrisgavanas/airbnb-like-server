package com.webapplication.dto.user;


import java.time.LocalDate;

public class SessionInfo {

    private final Integer userId;
    private LocalDate date;

    public SessionInfo(Integer userId, LocalDate date) {
        this.userId = userId;
        this.date = date;
    }

    public Integer getUserId() {
        return userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

}