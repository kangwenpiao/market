package top.kwp8.controller.mobile;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/mobile")
@Controller
public class MobileAppController {

	@RequestMapping("/index.jhtml")
	public String index(){
		return "mobile/mobileIndex";
	}
}
