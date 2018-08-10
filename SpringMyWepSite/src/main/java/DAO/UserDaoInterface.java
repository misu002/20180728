package DAO;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import BeanModel.userinfo;
import VariousView.XmlUserinfo;

public interface UserDaoInterface {
	
	public userinfo selectById(String id);
	public int insertUser(userinfo info);
	public List<userinfo> selectUser();
	public List<userinfo> selectUserByBirth(Date first,Date second);
	public List<XmlUserinfo> selectUserByBirthXml(Date first,Date second);
	public int updateById(String userId);
	public int updateTmpPw(@Param("userId") String userId,@Param("tmpPw")String tmpPw);
	public int updateChangePw(@Param("userId") String userId, @Param("changePw") String changePw);
}
