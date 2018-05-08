package com.web.rnb.chatimpl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.rnb.chat.ChatDTO;
import com.web.rnb.chat.ChatService;

@Service
public class ChatServiceImpl implements ChatService {
	@Autowired
	ChatDAO cdao;
	
	@Override
	public void insertChat(ChatDTO cdto) {
		// TODO Auto-generated method stub
		cdao.insertChat(cdto);
	}

	@Override
	public List<ChatDTO> getListChat() {
		// TODO Auto-generated method stub
		List<ChatDTO> list=cdao.getListChat();
		return list;
	}

}
