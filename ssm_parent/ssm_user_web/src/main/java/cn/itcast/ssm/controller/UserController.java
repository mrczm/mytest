package cn.itcast.ssm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.druid.util.StringUtils;

import cn.itcast.ssm.domain.Users;
import cn.itcast.ssm.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserService userService;
	
	/**
	 * 跳转到注册页面
	 */
	@RequestMapping("toRegister")
	public String toRegister() {
		return "register";
	}
	
	/**
	 * 跳转到登录页面
	 */
	@RequestMapping("toLogin")
	public String toLogin() {
		return "login";
	}
	
	/**
	 * 用户注册
	 */
	@RequestMapping("doRegister")
	public String doRegister(Users user,Model model) {
		Users dbUser = userService.findUserByName(user.getUsername());
		if(dbUser != null) {
			model.addAttribute("message", "用户名已被注册");
			model.addAttribute("user", user);
			return "forward:toRegister";
		}
		userService.register(user);
		return "registerSucc";
	}
	
	/**
	 * 用户登录
	 */
	@RequestMapping("doLogin")
	public String login(Users user, HttpSession session,Model model) {
		model.addAttribute("user", user);
		if(user.getUsername().trim().equals("")) {
			model.addAttribute("message1", "用户名不能为空");
			return "forward:toLogin";
		}
		if( user.getPassword().trim().equals("")) {
			model.addAttribute("message2", "密码不能为空");
			return "forward:toLogin";
		}
		Users dbUser = userService.findUserByName(user.getUsername());
		if(dbUser == null) {
			model.addAttribute("message1", "用户名不存在");
			return "forward:toLogin";
		}
		session.setAttribute("user", dbUser);
		model.addAttribute("user", dbUser);
		return "success";
	}
	
	/**
	 * 直接访问成功页面
	 */
	@RequestMapping("success")
	public String success() {
		return "success";
	}
}















