package com.buybuddy.chatbot.dto;

public class ChatBotRequest {
    private String message;

    public ChatBotRequest() {
        // No-args constructor needed by Jackson
    }

    public ChatBotRequest(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

