package cn.appsys.controller.backend;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysql.jdbc.Constants;

import cn.appsys.pojo.BackendUser;
import cn.appsys.service.backend.BackendUserService;

@Controller
@RequestMapping("/manager")
public class UserLoginController {
	@Resource
	private BackendUserService backendUserService;
	
	@RequestMapping("/dologin")
	public String doLogin(@RequestParam String userCode,
			@RequestParam String userPassword,
			HttpServletRequest request,
			HttpSession session){
		BackendUser user=null;
		try {
			user=backendUserService.login(userCode,userPassword);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (null!=user) {
			session.setAttribute(Constants user);
			return "redirect:/manager/backend/main";
		} else {
			request.setAttribute("error", "输入不正确");
			return "backendlogin";
		}
	}
}
