package top.kwp8.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("admin")
@Controller
public class IndexController {
	
	@RequestMapping("/index.jhtml")
	public String Index(){
		return "index";
	}
	@RequestMapping("/welcome.jhtml")
	public String welcome(){
		return "welcome";
	}
}
