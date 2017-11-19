package top.kwp8.controller.mobile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import top.kwp8.entity.User;
import top.kwp8.service.UserService;
import top.kwp8.utils.OutPrint;
import top.kwp8.utils.ThreadContextHolder;
import top.kwp8.utils.Utils;
import top.kwp8.utils.ValidCodeServlet;

@RequestMapping("mobile")
@Controller
public class MobileUserController {
	@Autowired
	private UserService userService;
	@RequestMapping("/login.do")
	public void login(User user,HttpServletRequest request,HttpServletResponse response){
		User u = userService.selectUser(user);
		if(u == null){
			OutPrint.returnResultFail(response, "登录失败");
			return;
		}
		request.getSession().setAttribute("user", user);
		OutPrint.returnResultSuccess(response, "登录成功");
	}
	@RequestMapping("/register.do")
	public void register(User user,String valiCode,HttpServletRequest request,HttpServletResponse response){
		if(StringUtils.isBlank(user.getMobile()) || Utils.checkMobile(user.getMobile())){
			OutPrint.returnResultFail(response, "请输入正确的手机号");
			return;
		}else if(StringUtils.isBlank(user.getPassword())){
			OutPrint.returnResultFail(response, "请输入密码");
			return;
		}else if(StringUtils.isBlank(valiCode)){
			OutPrint.returnResultFail(response, "请输入图形码");
			return;
		}
		String valid_code = (String) ThreadContextHolder.getHttpSession().getAttribute(ValidCodeServlet.SESSION_VALID_CODE);
	}
}
