package cn.appsys.controller.developer;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysql.jdbc.Constants;

import cn.appsys.pojo.DevUser;
import cn.appsys.service.developer.DevUserService;

@Controller
@RequestMapping("/dev")
public class DevLoginController {
	@Resource
	private DevUserService devUserService;
	
	@RequestMapping("/dologin")
	public String doLogin(@RequestParam String devCode,
			@RequestParam String devPassword,
			HttpServletRequest request,
			HttpSession session){
		DevUser user=null;
		try {
			user=devUserService.login(devCode, devPassword);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(null!=user){
			session.setAttribute(Constants user);
			return "redirect:/dev/flatform/main";
		}else{
			request.setAttribute("error", "输入不正确");
			return "devlogin";
		}
		return "devlogin";
	}
	
	
	
	
}
