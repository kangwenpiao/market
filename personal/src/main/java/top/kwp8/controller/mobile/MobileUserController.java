package top.kwp8.controller.mobile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import top.kwp8.entity.User;
import top.kwp8.service.UserService;
import top.kwp8.utils.OutPrint;

@RequestMapping("mobile")
@Controller
public class MobileUserController {
	@Autowired
	private UserService userService;
	@RequestMapping("/user.do")
	public void login(User user,HttpServletRequest request,HttpServletResponse response){
		User u = userService.selectUser(user);
		if(u == null){
			OutPrint.returnResultFail(response, "登录失败");
			return;
		}
		request.getSession().setAttribute("user", user);
		OutPrint.returnResultSuccess(response, "登录成功");
	}
}
