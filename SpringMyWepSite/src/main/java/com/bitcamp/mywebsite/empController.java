package com.bitcamp.mywebsite;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import BeanModel.emp_info;

@Controller
public class empController {
	
	@RequestMapping("/empList")
	public String empList() {
		return "empList";
	}
	@RequestMapping("/empInsertForm")
	public String empInsertForm() {
		return "empInsertForm";
	}
	@RequestMapping("/empInsert")
	public String empInsert() {
		return "empInsert";
	}
}
