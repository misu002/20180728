package Services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import DAO.userinfoDao;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import BeanModel.userinfo;

public class GetUserService {
	@Autowired
	userinfoDao userinfodao;
	
	public List<userinfo> getUser() throws ServiceException {
		Connection conn=null;
		List<userinfo> userinfolist=null;
		try {
		conn = ConnectionProvider.getConnection();
		userinfolist=userinfodao.selectUser(conn);
		return userinfolist;
		} catch (SQLException e) {
			throw new ServiceException("메시지 목록 구하기 실패: " + e.getMessage(), e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
	
	public ResultSet getLoginUser(String id) throws ServiceException {
		Connection conn=null;
		String userName="";
		ResultSet rs=null;
		try {
		conn = ConnectionProvider.getConnection();
		rs=userinfodao.selectLoginUser(conn,id);		
		return rs;
		} catch (SQLException e) {
			throw new ServiceException("메시지 목록 구하기 실패: " + e.getMessage(), e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
	
}
