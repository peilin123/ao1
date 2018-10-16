package com.bwf.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bwf.entity.Menu;
import com.bwf.entity.User;
import com.bwf.service.IUserService;
import com.bwf.utils.StringUtils;


@Controller
@RequestMapping("user")
public class UserController {
	Logger logger=LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	IUserService userService;
	
	@GetMapping("login")
	public String loginIn(Integer error, ModelMap modelMap){
		modelMap.addAttribute("error", error);
		return "login/login";
	}
	@PostMapping("index")
	public String check(User user,HttpSession session){
		//logger.info("{},{}",user.getUsername(),user.getPassword());
		//给登入的password加密
		user.setPassword(StringUtils.md5(user.getPassword())); 
		logger.info(user.getPassword());
		User Okuser=userService.login(user);
		if(Okuser==null){
			logger.info("登录失败，用户名或密码错误");
			
			// 带着错误信息， 跳转到 登录页面
			return "redirect:/user/login?error=1";
		}
		else{
		// 登录成功
		logger.info("登录成功");
		//写入 session 
		session.setAttribute("Okuser", Okuser );
		return "redirect:/index";
		}
	}
	
	// 退出登录
		@GetMapping("logout")
		public String logout( HttpSession session ){
			session.removeAttribute("Okuser");
			//session.invalidate();
			return "redirect:/user/login";
		}
		
		@GetMapping("manager")
		public String userManager(ModelMap modelMap,Integer pageCount  ){
			Integer fenYeShu=10;
			if(pageCount==null){
				//pageCount 当前页码
				pageCount=1;
			}
			List<User> allUser=userService.getAllUser(pageCount,fenYeShu);
			modelMap.addAttribute("allUser", allUser);
			//分页
			Integer pages = userService.getPages(fenYeShu);
			modelMap.addAttribute("pages", pages);
			return "user/manager";
		}
		
		@GetMapping("delete")
		public String userDelete(Integer userId){
			//System.out.println("userId:"+userId);
			return "redirect:/user/manager";
		}
		
		@GetMapping("add")
		public String userAdd(ModelMap modelMap){
			List<User> allUsers=userService.getAllUsers();
			modelMap.addAttribute("allUsers", allUsers);
			return "user/add";
		}
		
		@PostMapping("doAdd")
		public String userSave(User user){
			userService.saveUser(user);
			
			return "redirect:/user/manager";
		}
		
		@GetMapping("edit")
		public String getUserEdit(Integer userId,ModelMap modelMap){
			//根据编辑的userID，进数据库查出user信息
			User user1=userService.getUserByUserId(userId);
			modelMap.addAttribute("user1", user1);
			//获取所有用户信息
			List<User> allUsers=userService.getAllUsers();
			modelMap.addAttribute("allUsers", allUsers);
			return "user/edit";
		}
		
		@GetMapping("doEdit")
		public String userEdit(User user){
			//将编辑后的user写入数据库
			userService.updateUser(user);
			
			return "redirect:/user/manager";
		}

}
