package Services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import DAO.jdbcTemplateUserinfoDao;
import DAO.userinfoDao;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import BeanModel.userinfo;

public class GetUserService {
	@Autowired
	//userinfoDao userinfodao;
	jdbcTemplateUserinfoDao userinfodao;
	
	public List<userinfo> getUser() throws ServiceException {

		List<userinfo> userinfolist=null;
		userinfolist=userinfodao.selectUser();
		return userinfolist;
/*		try {
 		Connection conn=null;
		conn = ConnectionProvider.getConnection();	
	
		} catch (SQLException e) {
			throw new ServiceException("메시지 목록 구하기 실패: " + e.getMessage(), e);
		} finally {
			JdbcUtil.close(conn);
		}*/
	}
	
	public userinfo getLoginUser(String id) throws ServiceException {
		userinfo Info=null;
		Info=userinfodao.selectById(id);
		return Info;		
		
		/*
		Connection conn=null;
		String userName="";
		ResultSet rs=null;
		try {
		conn = ConnectionProvider.getConnection();
				
		return rs;
		} catch (SQLException e) {
			throw new ServiceException("메시지 목록 구하기 실패: " + e.getMessage(), e);
		} finally {
			JdbcUtil.close(conn);
		}*/
	}
	
}
