package com.bitcamp.mywebsite;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


import BeanModel.userinfo;
import Services.GetUserService;
import Services.MailSenderService;
import Services.RegisterInsertService;
import Services.ServiceException;

@Controller
public class RegisterController {
	@Autowired
	RegisterInsertService registerInsertService ;
	
	@Autowired
	MailSenderService mailSenderService;
	
	@Autowired
	GetUserService userDao;
	
	@RequestMapping("/goAgreeForm")
	public String goAgreeForm() {
		return "NaverAgree";
	}
	
	
	@RequestMapping("/GoRegister")
	public String goRegister() {
		return "registerForm";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String Register(userinfo info,Model model,HttpServletRequest request) throws ServiceException, IllegalStateException, IOException {
		int resultCnt = 0;		
		resultCnt=registerInsertService.register(info,request);
		model.addAttribute("resultCnt",resultCnt);
		
		//회원가입을 끝낸후에 인증메일 발송
		if(resultCnt>0) {
			mailSenderService.htmlMailSend(info);
			return "sendMail";
		}else{
			return "index";
		}		
	}
	
	@ResponseBody
	@RequestMapping(value="/idChk",produces = "text/plain;charset=utf8")
	public String idChk(@RequestParam("chkId") String chkId) throws ServiceException {
//		boolean isThere=false;
		//my sql in으로 해서 있으면 값이 어떻게나오나
		System.out.println(chkId);
		List<userinfo> userlist = userDao.getUser();
		for (userinfo userinfo : userlist) {
			if(userinfo.getId().equals(chkId)) {
				return "true";
			}
		}
		return "false";		
	}
	
	
}
