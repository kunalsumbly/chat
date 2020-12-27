package com.kusu.chat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kusu.chat.model.MessageForm;
import com.kusu.chat.service.MessageListService;

@Controller
@RequestMapping("/home")
public class HomeController {

    private MessageListService messageListService;

    public HomeController(MessageListService messageListService) {
        this.messageListService = messageListService;
    }

    @GetMapping()
    public String getHomePage(MessageForm messageForm, Model model) {
        model.addAttribute("greetings", this.messageListService.getMessages());
        return "home";
    }

    @PostMapping()
    public String addMessage(MessageForm messageForm, Model model) {
        messageListService.addMessage(messageForm.getText());
        model.addAttribute("greetings", messageListService.getMessages());
        messageForm.setText("");
        return "home";
    }

}
