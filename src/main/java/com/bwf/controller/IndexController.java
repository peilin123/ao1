package com.bwf.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bwf.entity.User;

@Controller
public class IndexController {
	@RequestMapping("index")
	public String index(ModelMap modelMap,HttpSession session){
		User Okuser=(User)session.getAttribute("Okuser");
		String icon=Okuser.getIcon();
		modelMap.addAttribute("icon", icon);
		return "index";
	}
	
	@RequestMapping("admin_home")
	public String home(){
		return "admin_home";
	}
	
	@RequestMapping("error")
	public String homeError(){
		return "error";
	}

}
