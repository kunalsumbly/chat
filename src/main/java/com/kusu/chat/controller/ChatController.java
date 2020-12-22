package com.kusu.chat.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.SerializationUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kusu.chat.MessageService;
import com.kusu.chat.model.ChatForm;

@Controller
public class ChatController {
	
	@Autowired
	private MessageService chatService;

	@PostMapping(value="/chat")
	public String postChats(@ModelAttribute("chatForm")ChatForm inputParam, Model model) {
		if (!"Select".equals(inputParam.getMessageType())) {
			ChatForm deserialize = new ChatForm();
			deserialize.setMessageText(inputParam.getMessageText());
			deserialize.setMessageType(inputParam.getMessageType());
			deserialize.setUserName(inputParam.getUserName());
			chatService.getChatsList().add(deserialize);
			model.addAttribute("chats", chatService.getChatsList());
		}
		
    	
    	inputParam.setMessageText("");
    	inputParam.setMessageType("Select");
    	inputParam.setUserName("");
    	
    	return "chat";
	}
	
	@GetMapping(value="/chat")
    public String getChats(@ModelAttribute("chatForm")ChatForm inputParam,Model model) {
		model.addAttribute("chats", chatService.getChatsList());
    	return "chat";
    }
	
}
