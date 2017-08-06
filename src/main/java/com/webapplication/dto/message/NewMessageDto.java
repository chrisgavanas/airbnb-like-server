package com.webapplication.dto.message;


import java.util.Date;

/**
 * Created by panagiotis on 7/8/2017.
 */
public class NewMessageDto {

    private Integer fromUserId;

    private Integer toUserId;

    private String messageText;

    public Integer getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(Integer fromUserId) {
        this.fromUserId = fromUserId;
    }

    public Integer getToUserId() {
        return toUserId;
    }

    public void setToUserId(Integer toUserId) {
        this.toUserId = toUserId;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
}
