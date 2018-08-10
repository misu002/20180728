package com.bitcamp.mywebsite;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import BeanModel.userinfo;
import Services.GetUserService;
import Services.ServiceException;

@Controller
public class MypageController {
	@Autowired
	GetUserService getUserService;
	
	
	@RequestMapping("/member/Mypage")
	public String getMypage(HttpSession session,Model model) throws ServiceException {
		userinfo Info=null;
		String id=(String) session.getAttribute("id");
		Info=getUserService.getLoginUser(id);
		model.addAttribute("Userinfo",Info);
		return "mypage";
	}
	
	@RequestMapping("/userinfolist")
	public String getUserList(Model model) throws ServiceException {
		List<userinfo> userlist = getUserService.getUser();
		model.addAttribute("userlist", userlist);
		return "userinfolist";
	}
}
