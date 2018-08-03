package Services;

import java.sql.Connection;
import java.sql.SQLException;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import DAO.MessageDao;
import DAO.MessageDaoInterface;
import BeanModel.Message;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

public class DeleteMessageService {
	@Autowired
	//MessageDao messageDao;	
	private SqlSessionTemplate template;
	
	private MessageDaoInterface messageDao;

	public void deleteMessage(int messageId, String GuestName) throws ServiceException, InvalidMessagePassowrdException,
			MessageNotFoundException{
		messageDao=template.getMapper(MessageDaoInterface.class);
		Message message = messageDao.selectbyId(messageId);
		String guestName=message.getGuestName();
		
		if (guestName == null) {
			
		}else if(guestName.equals(GuestName)) {
			messageDao.delete(messageId);
		}
		
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
