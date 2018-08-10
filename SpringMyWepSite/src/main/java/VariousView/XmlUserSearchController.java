package VariousView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import DAO.UserDaoInterface;

@Controller
@RequestMapping("/UserSearch/xml")
public class XmlUserSearchController {
	@Autowired
	private SqlSessionTemplate template;
	private UserDaoInterface userinfodao;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String listXml() {
		return "UserSearch";
	}

	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	private XmluserInfoList getUserinfoList(@RequestParam("firstDate") Date first,@RequestParam("secondDate") Date second) {
		List<XmlUserinfo> userList=new ArrayList<XmlUserinfo>();
		userinfodao = template.getMapper(UserDaoInterface.class);
		userList=userinfodao.selectUserByBirthXml(first, second);
		return new XmluserInfoList(userList);
	}
	
}
