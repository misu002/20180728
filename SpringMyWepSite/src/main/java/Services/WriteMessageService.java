package Services;

import java.sql.Connection;
import java.sql.SQLException;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import DAO.MessageDao;
import DAO.MessageDaoInterface;
import BeanModel.Message;
import jdbc.connection.ConnectionProvider;

public class WriteMessageService {
	@Autowired
	//MessageDao messageDao;
	
	private SqlSessionTemplate template;
	private MessageDaoInterface messageDao;

	public int write(Message message) throws ServiceException {
		messageDao=template.getMapper(MessageDaoInterface.class);
		int resultCnt=messageDao.insert(message);
		return resultCnt;
/*		Connection conn=null;
		try {
			conn=ConnectionProvider.getConnection();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ServiceException("메시지 등록 실패: " + e.getMessage(), e);
		}*/
	}
}
