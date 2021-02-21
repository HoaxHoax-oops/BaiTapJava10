package com.myclass.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Scope("prototype")
@RequestMapping("/category")
public class CategoryController {
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String index() {
		return "category/index";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add() {
		return "category/add";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit() {
		return "category/edit";
	}
}
