package com.kusu.chat.model;

public class ChatForm {

	private Integer chatId;
	private String userName;
	private String messageText;
	private String messageType;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMessageText() {
		return messageText;
	}
	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}
	public String getMessageType() {
		return messageType;
	}
	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}
	public Integer getChatId() {
		return chatId;
	}
	public void setChatId(Integer chatId) {
		this.chatId = chatId;
	}
	
}
