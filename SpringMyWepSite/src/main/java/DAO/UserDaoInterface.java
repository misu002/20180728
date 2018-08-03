package DAO;

import java.util.Date;
import java.util.List;

import BeanModel.userinfo;

public interface UserDaoInterface {
	
	public userinfo selectById(String id);
	public int insertUser(userinfo info);
	public List<userinfo> selectUser();
	public List<userinfo> selectUserByBirth(Date first,Date second);
	
}
