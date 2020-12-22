package com.kusu.chat;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kusu.chat.model.ChatForm;

@Service
public class MessageService {

	private List<ChatForm> chatsList = new ArrayList<ChatForm>();

	public List<ChatForm> getChatsList() {
		return chatsList;
	}

	public void setChatsList(List<ChatForm> chatsList) {
		this.chatsList = chatsList;
	}
	
}
