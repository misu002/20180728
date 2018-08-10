package VariousView;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="userInfo-list")

public class XmluserInfoList {
	private List<XmlUserinfo> userList;
	
	
	public XmluserInfoList() {}

	public XmluserInfoList(List<XmlUserinfo> userList) {
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
