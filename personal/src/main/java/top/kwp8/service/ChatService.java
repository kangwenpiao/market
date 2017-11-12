package top.kwp8.service;

import java.util.List;

import top.kwp8.entity.Chat;
import top.kwp8.entity.view.ChatView;
import top.kwp8.utils.Grid;

public interface ChatService {

	void saveChat(Chat chat);
	
	List<ChatView> selectlist(Grid grid);
	
	List<Chat> selectlist();
	
	Long getChatCount(Object... objects);
}
