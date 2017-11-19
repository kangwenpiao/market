package top.kwp8.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import top.kwp8.entity.view.ChatView;
import top.kwp8.service.ChatService;
import top.kwp8.utils.Grid;
import top.kwp8.utils.OutPrint;
import top.kwp8.utils.Page;

@RequestMapping("admin")
@Controller
public class ChatController {

	@Autowired
	private ChatService chatService;
	@RequestMapping("/chatpage.do")
	public String chatpage(Model model){
		Integer pageSize = 10;
		Long count = chatService.getChatCount();
		Long betw = count % pageSize;
		Long page = betw == 0 ? count/pageSize : count / pageSize +1;  
		model.addAttribute("page", page);
		return "chat";
	}
	@RequestMapping("/getpagelist.do")
	public void getPageList(Grid grid,HttpServletResponse response){
		List<ChatView> list = chatService.selectlist(grid);
		Long count = chatService.getChatCount();
		Page<ChatView> page = new Page<>(count, list);
		OutPrint.outResultResSucGrid(response, page);
	}
	@RequestMapping("/delById.do")
	public void delchat(Integer id,HttpServletResponse response){
		chatService.delById(id);
		OutPrint.returnResultSuccess(response, "删除成功");
	}
}
