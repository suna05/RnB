package com.web.rnb.chatimpl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.rnb.chat.ChatDTO;

@Repository("ChatDAO")
public class ChatDAO{
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insertChat(ChatDTO cdto) {
		mybatis.insert("ChatDAO.insertChat",cdto);
	}
	public List<ChatDTO> getListChat(){
		return mybatis.selectList("ChatDAO.getListChat");
	}
}
