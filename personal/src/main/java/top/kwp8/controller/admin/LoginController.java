package top.kwp8.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import top.kwp8.entity.Admin;
import top.kwp8.utils.ValidCodeServlet;

@RequestMapping("/login")
@Controller
public class LoginController {

	// private static final Logger log = LoggerFactory.getLogger(LoginController.class);

	@RequestMapping("/loginPage.jhtml")
	public String loginPage() {
		return "login";
	}

	@RequestMapping("/dologin.do")
	public ModelAndView onSubmit(Admin admin, String valiCode, HttpServletRequest request,RedirectAttributes attributes) {
//		ModelMap attributes = new ModelMap();  
		if (StringUtils.isBlank(admin.getName())) {
			attributes.addFlashAttribute("name", "用户名为空");
		}else if (StringUtils.isBlank(admin.getPassword())) {
			attributes.addFlashAttribute("password", "密码为空");
		}else if (StringUtils.isBlank(valiCode)) {
			attributes.addFlashAttribute("valiInfo", "验证码为空");
		}
		String sessionCode = (String) request.getSession().getAttribute(ValidCodeServlet.SESSION_VALID_CODE);
		if (StringUtils.isNotBlank(valiCode) && !valiCode.equals(sessionCode)) {
			attributes.addFlashAttribute("valiInfo", "验证码不正确");
		}
		UsernamePasswordToken token = new UsernamePasswordToken(admin.getName(), admin.getPassword());
		try {
			SecurityUtils.getSubject().login(token);
		} catch (AuthenticationException e) {
			e.printStackTrace();
//			return new ModelAndView("forward:/login/loginPage.jhtml",attributes);
			attributes.addFlashAttribute("loginInfo","账号或密码有误");
			return new ModelAndView("redirect:/login/loginPage.jhtml");
		}
		return new ModelAndView("redirect:/admin/index.jhtml");
	}
	@RequestMapping("/loginout.do")
	public ModelAndView loginOut() {
		SecurityUtils.getSubject().logout();
		return new ModelAndView("redirect:/login/loginPage.jhtml");
	}
}
