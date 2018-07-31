package com.bitcamp.mywebsite;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


import BeanModel.userinfo;
import Services.RegisterInsertService;
import Services.ServiceException;

@Controller
public class RegisterController {
	@Autowired
	RegisterInsertService register ;
	
	@RequestMapping("/GoRegister")
	public String goRegister() {
		return "registerForm";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String Register(userinfo info,Model model,HttpServletRequest request) throws ServiceException, IllegalStateException, IOException {
		int resultCnt = 0;		
		resultCnt=register.register(info,request);
		model.addAttribute("resultCnt",resultCnt);
		return "index";
	}
	
}
