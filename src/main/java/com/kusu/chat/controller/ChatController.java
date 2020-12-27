package com.kusu.chat.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kusu.chat.model.ChatForm;
import com.kusu.chat.service.MessageService;

@Controller
public class ChatController {
	
	@Autowired
	private MessageService chatService;

	@PostMapping(value="/chat")
	public String postChats(@ModelAttribute("chatForm")ChatForm inputParam, Model model, Principal principal) {
		if (!"Select".equals(inputParam.getMessageType())) {
			ChatForm deserialize = new ChatForm();
			deserialize.setMessageText(inputParam.getMessageText());
			deserialize.setMessageType(inputParam.getMessageType());
			deserialize.setUserName(principal.getName());
			chatService.createMessage(deserialize);
			model.addAttribute("chats", chatService.getChatList());
		}
		
    	
    	inputParam.setMessageText("");
    	inputParam.setMessageType("Select");
    	inputParam.setUserName("");
    	
    	return "chat";
	}
	
	@GetMapping(value="/chat")
    public String getChats(@ModelAttribute("chatForm")ChatForm inputParam,Model model, Principal principal) {
		model.addAttribute("loggeduser", principal.getName());
		model.addAttribute("chats", chatService.getChatList());
    	return "chat";
    }
	
}
