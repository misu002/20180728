package com.bitcamp.mywebsite;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import BeanModel.MemberInfo;
import BeanModel.userinfo;
import Services.GetUserService;
import Services.ServiceException;

@Controller

public class LoginController {
	@Autowired
	GetUserService getUserService;

	@RequestMapping("member/login/login")
	public ModelAndView goLogin(@CookieValue(value = "CookieId", defaultValue = "0") String CookieId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("CookieId", CookieId);
		mav.setViewName("loginForm");
		return mav;
	}

	@RequestMapping("member/login/LoginAccess")
	public String LoginAction(MemberInfo info, HttpServletResponse response, HttpServletRequest request,Model model)
			throws ServiceException {
		String id = info.getId();
		String pw = info.getPassword();
		userinfo Userinfo = getUserService.getLoginUser(id);
		model.addAttribute("Userinfo",Userinfo);
		String DBpw = getUserService.getLoginUser(id).getPw();
		String isRem = request.getParameter("remember");
		
		HttpSession session = request.getSession(false);
		if (pw.equals(DBpw)) {
			session.setAttribute("id", info.getId());
			if (isRem == null) {
				Cookie cookie = new Cookie("CookieId", null);
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			} else if (isRem.equals("on")) {
				response.addCookie(new Cookie("CookieId", id));
			}
			//이거때문에 마이페이지에 아무것도 안보임 안보이면 인증메일 
			if(Userinfo.getConfirm().equals("N")) {
				return "mypage";
			}
		} else {
			return "loginForm";
		}
		return "index";
	}

	@RequestMapping("member/login/Logout")
	public String Logout(HttpSession session) {

		session.invalidate();
		// "redirect:/"컨텍스트 경로를 이미 포함하고 있다
		return "index";
	}
}
