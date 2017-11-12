package top.kwp8.controller.mobile;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import top.kwp8.entity.Chat;
import top.kwp8.entity.view.ChatView;
import top.kwp8.service.ChatService;
import top.kwp8.utils.Grid;
import top.kwp8.utils.OutPrint;


@RequestMapping("mobile")
@Controller
public class MobileChatController {
	@Autowired
	private ChatService chatService;
	@RequestMapping("/addchat.do")
	public void addChat(Chat chat,HttpServletResponse response){
		if(StringUtils.isBlank(chat.getContent())){
			OutPrint.returnResultFail(response, "请输入留言内容");
			return;
		}
		if(chat.getContent().length() > 400){
			OutPrint.returnResultFail(response, "留言内容太长，只限400字");
			return;
		}
		chat.setCreatetime(System.currentTimeMillis());
		chat.setUsername("普通用户");
		chatService.saveChat(chat);
		OutPrint.returnResultSuccess(response, "留言成功");
	}
	@RequestMapping("/getchat.do")
	public void getChatInfo(Grid grid,HttpServletResponse response){
		List<ChatView> list = chatService.selectlist(grid);
		OutPrint.outResultResSuc(response, list, "查询聊天列表成功");
	}
}
