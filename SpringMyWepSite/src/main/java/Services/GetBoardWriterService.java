package Services;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import BeanModel.userinfo;
import DAO.MybatisUserDao;
import DAO.userinfoDao;
import Services.ServiceException;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

public class GetBoardWriterService {
	@Autowired
	//userinfoDao UserinfoDao;
	MybatisUserDao Userinfodao;
	
	public userinfo getBoardWriter(String id) throws ServiceException{
		userinfo info= null;
		info=Userinfodao.selectById(id);
		return info;
		
		
/*		Connection conn=null;
		String pw="";
		try {
			conn=ConnectionProvider.getConnection();

			if(Userinfodao!=null) {

			}else {
				return "Not working";
			}			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ServiceException("메시지 등록 실패: " + e.getMessage(), e);
		}finally {
			JdbcUtil.close(conn);
		}*/

	}
}
