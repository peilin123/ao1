package com.bwf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("test")
public class UserController {
	@RequestMapping("a")
	public String test(){
		System.out.println("okl");
		return "test/a";
	}

}
