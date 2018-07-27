package com.bitcamp.mywebsite;

import java.sql.ResultSet;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import Services.GetUserService;
import Services.ServiceException;

@Controller
public class MypageController {
	@Autowired
	GetUserService getUserService;
	
	
	@RequestMapping("Mypage")
	public String getMypage(HttpSession session,Model model) throws ServiceException {
		ResultSet rs=null;
		String id=(String) session.getAttribute("id");
		rs=getUserService.getLoginUser(id);
		model.addAttribute("rs",rs);
		return "mypage";
	}
}
