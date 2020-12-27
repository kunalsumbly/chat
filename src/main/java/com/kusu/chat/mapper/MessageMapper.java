package com.kusu.chat.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.kusu.chat.model.ChatForm;

@Mapper
public interface MessageMapper {
	
	@Insert("INSERT INTO MESSAGES (username, messagetext, messagetype) VALUES (#{userName}, #{messageText}, #{messageType})")
    @Options(useGeneratedKeys = true, keyProperty = "chatId")
	int insertChat(ChatForm chat);
	
	@Select("SELECT * FROM MESSAGES where username = #{username}")
    List<ChatForm> getAllChats(String username);

}
