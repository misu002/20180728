package VariousView;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="UserList")
public class UserinfoList {
	
	@XmlElement(name="user")
	private List<XmlUserinfo> userList;
	
	
	public UserinfoList() {}
	public UserinfoList(List<XmlUserinfo> userList) {
		super();
		this.userList = userList;
	}

	public List<XmlUserinfo> getUserList() {
		return userList;
	}

	public void setUserList(List<XmlUserinfo> userList) {
		this.userList = userList;
	}
	
}
