package VariousView;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import DAO.UserDaoInterface;

@Controller
@RequestMapping("UserSearch/pdf")
public class XmlUserSearchController {
	@Autowired
	private SqlSessionTemplate template;
	private UserDaoInterface userinfodao;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public UserinfoList listXml() {
		return getUserinfoList();
	}

	@RequestMapping(method=RequestMethod.POST)
	private UserinfoList getUserinfoList() {
		List<XmlUserinfo> userList=null;
		userinfodao = template.getMapper(UserDaoInterface.class);
		userList=userinfodao.selectUserByBirth(first, second);
		return userList;
	}


}
