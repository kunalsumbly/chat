package com.kusu.chat.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kusu.chat.mapper.MessageMapper;
import com.kusu.chat.model.ChatForm;

@Service
public class MessageService {

	private final MessageMapper messageMapper;
	
	public MessageService(MessageMapper mapper) {
		this.messageMapper= mapper;
	}
	
	public int createMessage(ChatForm chat) {
		return messageMapper.insertChat(chat);
	}
	
	
	public List<ChatForm> getChatList() {
		return messageMapper.getAllChats();
	}
}
