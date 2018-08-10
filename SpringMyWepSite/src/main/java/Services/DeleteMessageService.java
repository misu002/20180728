package Services;

import java.sql.Connection;
import java.sql.SQLException;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import DAO.MessageDao;
import DAO.MessageDaoInterface;
import DAO.UserDaoInterface;
import BeanModel.Message;
import BeanModel.userinfo;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

public class DeleteMessageService {
	@Autowired
	//MessageDao messageDao;	
	private SqlSessionTemplate template;
	
	private MessageDaoInterface messageDao;
	private UserDaoInterface userDao;

	public int deleteMessage(String userId, String guest_name ,int message_id) throws ServiceException, InvalidMessagePassowrdException,
			MessageNotFoundException{
		messageDao=template.getMapper(MessageDaoInterface.class);
		//메세지 작성자의 이름 : guest_name
		userDao=template.getMapper(UserDaoInterface.class);
		
		//현재 로그인한 회원의 이름 구하기
		userinfo info=userDao.selectById(userId);
		int resultCnt=0;
		if (info.getName() == null) {
			return resultCnt;
		}else if(info.getName().equals(guest_name)) {
			resultCnt=messageDao.delete(message_id);
		}else {
			return resultCnt;
		}
		return resultCnt;
		
		/*Connection conn = null;
		
		
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			//1.메세지검색

				conn.commit();
			}else {
				throw new InvalidMessagePassowrdException();
			}
			
			//if (!message.hasPassword()) {throw new InvalidMessagePassowrdException();}
			//if (!message.getPassword().equals(password)) {throw new InvalidMessagePassowrdException();}
//			messageDao.delete(conn, messageId);
//			conn.commit();
			}catch (SQLException ex) {
				
				JdbcUtil.rollback(conn);
				throw new ServiceException("삭제 처리 중 에러가 발생했습니다:“ + ex.getMessage(), ex", ex);
				
			}catch (InvalidMessagePassowrdException ex) {
				
				JdbcUtil.rollback(conn);
				throw ex;
				
			}catch (MessageNotFoundException ex) {
				
				JdbcUtil.rollback(conn);
				throw ex;
				
			} finally {
				
				if (conn != null) {
				try {
					conn.setAutoCommit(false);				
				}catch (SQLException e) { }
					JdbcUtil.close(conn);
			}
			}*/
			
		
	}
	
	
}
