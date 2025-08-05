package com.buybuddy.chatbot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.buybuddy.chatbot.dto.ChatBotRequest;
import com.buybuddy.chatbot.dto.ChatBotResponse;
import com.buybuddy.chatbot.service.ChatBotService;

@RestController
@RequestMapping("/api/chat")
@CrossOrigin
public class ChatBotController {

    @Autowired
    private ChatBotService chatService;

    @PostMapping
    public ChatBotResponse getChatReply(@RequestBody ChatBotRequest chatBotRequest) {
        String reply = chatService.getChatResponse(chatBotRequest.getMessage());
        return new ChatBotResponse(reply);
    }
}