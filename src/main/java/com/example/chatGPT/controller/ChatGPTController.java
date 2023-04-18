package com.example.chatGPT.controller;

import com.example.chatGPT.entity.ChatGPTRequest;
import com.example.chatGPT.entity.ChatGPTResponse;
import com.example.chatGPT.service.ChatGPTService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatGPTController {
    private final ChatGPTService chatGPTService;

    public ChatGPTController() {
        this.chatGPTService = new ChatGPTService();
    }
    @CrossOrigin
    @PostMapping("/chat")
    public String chat(@RequestBody String userInput) {
        String chatGptResponse = chatGPTService.getAnswer(userInput);
        // Add any custom logic here to preprocess user input or post-process the API's response
        return chatGptResponse;
    }

    @PostMapping("/test")
    public String chat() {
        return "Hello world";
    }

}
