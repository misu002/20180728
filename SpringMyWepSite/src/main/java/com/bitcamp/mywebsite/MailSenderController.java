package com.bitcamp.mywebsite;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import BeanModel.userinfo;
import Services.GetUserService;
import Services.MailSenderService;
import Services.ServiceException;

@Controller
public class MailSenderController {
	@Autowired
	MailSenderService mailSenderService;
	@Autowired
	GetUserService getUserService;	
	
	//인증메일 안에서 아이디받아와서 컨펌스태터스 바꿔주기
	@RequestMapping("verified")
	public String verified(@RequestParam("userId") String userId) {
		int resultCnt=mailSenderService.confirmUpdateById(userId);
		if(resultCnt>0) {
			return "mailVerified";
		}else {
			return "index";
		}		
	}
	
	//재발송
	@ResponseBody
	@RequestMapping(value="reSend", produces = "text/plain;charset=utf8")
	public String reSend(HttpSession session,Model model) throws ServiceException, UnsupportedEncodingException {
		String id=(String)session.getAttribute("id");
		userinfo info=getUserService.getLoginUser(id);
		mailSenderService.htmlMailSend(info);
		return "인증 메일을 재발송 하였습니다.";		
	}
	
	
	//비밀번호 찾기 눌렀을때
	@RequestMapping(value="findPw", method=RequestMethod.GET)
	public String findPwForm() {
		return "findPwForm";
	}
	
	//임시비밀번호 담긴 메일 보내기
	@RequestMapping(value="findPw", method=RequestMethod.POST)
	public String findPw(@RequestParam("userId") String userId
			,@RequestParam("email") String email,Model model) throws ServiceException, UnsupportedEncodingException {
		String tmpPw="Catering"+((Math.random()*10000)+1);
		//userId,email받아서 모델에도 넣어야함
		model.addAttribute("userId",userId);
		model.addAttribute("email",email);
		//해당 아이디로 userinfo받아와서 그것과 email이 같은 회원에게서 나오면 임시비밀번호 보내기
		userinfo info=getUserService.getLoginUser(userId);
		if(info.getEmail().equals(email)) {
			mailSenderService.findMailSend(userId,email,tmpPw);
			int resultCnt=mailSenderService.tmpPwUpdate(userId,tmpPw);
			if(resultCnt>0) {
				return "findPw";
			}else {
				return "findPwForm";
			}			
		}else {
		return "findPwForm";
		}
	}
	
	//메일에서 비번 받고 폼으로 접근
	@RequestMapping(value="changePw",method=RequestMethod.GET)
	public String changePwForm(@RequestParam("userId") String userId,Model model) {
		model.addAttribute("userId",userId);
		//form에서 아이디 붙여서 보내기?
		return "changePwForm";
	}
	
	//메일에서 접근 후 비번 바꾸기
	@RequestMapping(value="changePw",method=RequestMethod.POST)
	public String changePw(@RequestParam("userId") String userId
			,@RequestParam("changePw") String changePw
			,@RequestParam("recentPw") String recentPw) throws ServiceException {		

		userinfo info=getUserService.getLoginUser(userId);
		//현재비밀번호가 맞으면
		if(info.getPw().equals(recentPw)) {
			//새로운 비밀번호로 업데이트 하고 다시 로그인 하세요
			int resultCnt=mailSenderService.changePwUpdate(userId, changePw);
			if(resultCnt>0) {
			return "changePw";
			}else {
				return "changePwForm";
			}
			
		}else {
			return "changePwForm";
		}	


		
		

	}
}

















