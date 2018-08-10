package com.bitcamp.mywebsite;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import BeanModel.Message;
import BeanModel.MessageListView;
import BeanModel.userinfo;
import Services.DeleteMessageService;
import Services.GetMessageListService;
import Services.GetUserService;
import Services.InvalidMessagePassowrdException;
import Services.MessageNotFoundException;
import Services.ServiceException;
import Services.WriteMessageService;

@Controller
public class MessageController {
	@Autowired
	GetMessageListService messageListService;
	
	@Autowired
	WriteMessageService writeMessageService;
	
	@Autowired
	DeleteMessageService deleteMessageService;
	
	@Autowired
	GetUserService getUserService;
	
	@RequestMapping("MList")
	public String getMList(@RequestParam(value="page", defaultValue="1") String pageNumberStr
			,Model model,HttpSession session) throws ServiceException {
    	int pageNumber=1;
    	if(pageNumberStr!=null){
    		pageNumber = Integer.parseInt(pageNumberStr);
    	} 	    	
    	MessageListView viewData = messageListService.getMessageList(pageNumber);  
    	model.addAttribute("viewData", viewData);
		return "MList";
	}
	
	@RequestMapping(value = "MWrite", method =RequestMethod.GET)
	public String getMWrite(Model model,HttpSession session) throws ServiceException {
		String id=(String)session.getAttribute("id");
		userinfo info=getUserService.getLoginUser(id);
		model.addAttribute("userName",info.getName());
		return "MWrite";
	}
	
	@RequestMapping(value = "MWrite", method =RequestMethod.POST)
	public String Write(Model model,Message message) throws ServiceException{
    	int resultCnt=writeMessageService.write(message);
    	model.addAttribute("resultCnt",resultCnt);

    	return "writeMessage";
	}

	
	@RequestMapping("/deleteMessage")
	public String getMdelete(@RequestParam("guest_name") String guest_name
			,@RequestParam("message_id") int message_id
			, HttpSession session
			,Model model) throws ServiceException, InvalidMessagePassowrdException, MessageNotFoundException {
		//메세지 작성자의 이름과 로그인한 유저의 이름 비교후
		//모델에 값 넣어서
		//jsp에서 c태그로 값비교후 나오는 화면을 두개로 해야하나
		String userId=(String) session.getAttribute("id");
		
		int resultCnt=deleteMessageService.deleteMessage(userId, guest_name,message_id);
		
		model.addAttribute("resultCnt",resultCnt);
		
		return "deleteMessage";
	}
	
	
}
