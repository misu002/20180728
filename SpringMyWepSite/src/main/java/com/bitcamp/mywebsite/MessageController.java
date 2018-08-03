package com.bitcamp.mywebsite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import BeanModel.MessageListView;
import Services.GetMessageListService;
import Services.ServiceException;

@Controller
public class MessageController {
	@Autowired
	GetMessageListService messageListService;
	
	@RequestMapping("/MList")
	public String getMList(@RequestParam("id") String id,@RequestParam("page") String pageNumberStr
			,Model model) throws ServiceException {
    	int pageNumber=1;
    	if(pageNumberStr!=null){
    		pageNumber = Integer.parseInt(pageNumberStr);
    	} 	
    	
    	MessageListView viewData = messageListService.getMessageList(pageNumber);
    	model.addAttribute("viewData", viewData);
		return "MList";
	}
	@RequestMapping("/MWrite")
	public String getMWrite() {
		return "MWrite";
	}
}
