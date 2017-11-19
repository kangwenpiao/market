package top.kwp8.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import top.kwp8.dao.ChatDao;
import top.kwp8.entity.Chat;
import top.kwp8.entity.view.ChatView;
import top.kwp8.service.ChatService;
import top.kwp8.utils.Grid;
import top.kwp8.utils.Utils;
@Service
public class ChatServiceImpl implements ChatService {
	@Autowired
	private ChatDao chatDao;
	@Override
	public void saveChat(Chat chat) {
		String sql = "insert chat(username,content,createtime) value(?,?,?)";
		chatDao.save(sql, chat.getUsername(),chat.getContent(),chat.getCreatetime());
	}
	@Override
	public List<ChatView> selectlist(Grid grid) {
		Integer start = (grid.getPage()-1)*grid.getRows();
		String sql ="select * from chat order by createtime desc limit ?,? ";
		List<Chat> list =  chatDao.selectListByPage(sql, Chat.class, start,grid.getRows());
		List<ChatView> chatlist = Lists.newArrayList();
		for (Chat chat : list) {
			ChatView cv = new ChatView();
			BeanUtils.copyProperties(chat, cv,new String[]{"createtime"});
			cv.setCreatetime(Utils.getDateString(chat.getCreatetime()));
			chatlist.add(cv);
		}
		return chatlist;
	}
	@Override
	public List<Chat> selectlist() {
		String sql ="select * from chat order by createtime desc";
		return chatDao.selectList(sql, Chat.class);
	}
	@Override
	public Long getChatCount(Object... objects) {
		String sql  = "select count(*) from chat";
		return chatDao.selCount(sql, objects);
	}
	@Override
	public void delById(Integer id) {
		if(id != null){
			String sql = "delete from chat where id = ?";
			chatDao.update(sql, id);
		}else{
			String sql = "delete from chat";
			chatDao.update(sql);
		}
	}
}
