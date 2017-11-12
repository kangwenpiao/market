package top.kwp8.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin")
@Controller
public class LoginController {

	@RequestMapping("/loginPage.jhtml")
	public String loginPage() {
		return "login";
	}
	
	public String login(String mobile,String password){
		
		return "";
	}
}
