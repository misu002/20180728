package VariousView;

import java.util.Date;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import BeanModel.userinfo;
import DAO.UserDaoInterface;

@Controller
@RequestMapping("/UserSearch/xls")
public class ExcelUserSearchController {

	@Autowired
	private SqlSessionTemplate template;
	private UserDaoInterface userinfodao;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String getForm() {
		return "UserSearch";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView getExel(@RequestParam("firstDate") Date first,@RequestParam("secondDate") Date second) {
		List<userinfo> userinfolist=null;
		userinfodao = template.getMapper(UserDaoInterface.class);
		userinfolist=userinfodao.selectUserByBirth(first, second);
		return new ModelAndView("ExcelUser","ExcelUser",userinfolist);		
	}
	
	
}
