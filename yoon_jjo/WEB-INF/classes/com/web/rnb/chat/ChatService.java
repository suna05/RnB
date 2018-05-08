package com.web.rnb.chat;

import java.util.List;

public interface ChatService {

	void insertChat(ChatDTO cdto);

	List<ChatDTO> getListChat();

}