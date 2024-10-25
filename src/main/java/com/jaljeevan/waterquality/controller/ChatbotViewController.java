package com.jaljeevan.waterquality.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatbotViewController {

    @GetMapping("/chatbot")
    public String showChatbot() {
        return "chatbot"; // This will resolve to chatbot.html in the templates folder
    }
}


