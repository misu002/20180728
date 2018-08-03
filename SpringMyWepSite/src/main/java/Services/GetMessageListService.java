package Services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import DAO.MessageDao;
import DAO.MessageDaoInterface;
import BeanModel.Message;
import BeanModel.MessageListView;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

public class GetMessageListService {
	@Autowired
	//MessageDao messageDao;
	private SqlSessionTemplate template;
	MessageDaoInterface messageDao;
	


	// 한 페이지에 보여줄 메시지의 수
	private static final int MESSAGE_COUNT_PER_PAGE = 3;
	
	public MessageListView getMessageList(int pageNumber) throws ServiceException {
		
		
		int currentPageNumber = 1;		
		messageDao=template.getMapper(MessageDaoInterface.class);
		
		if(pageNumber>0) {
			currentPageNumber = pageNumber;
		}
		
		int messageTotalCount = messageDao.selectCount();
		List<Message> messageList = null;
		int firstRow = 0;
		int endRow = 0;
		
			if (messageTotalCount > 0) {
				firstRow = (currentPageNumber - 1) * MESSAGE_COUNT_PER_PAGE + 1;
				endRow = firstRow + MESSAGE_COUNT_PER_PAGE - 1;
				messageList = messageDao.selectList(firstRow, endRow);
			} else {
				currentPageNumber = 0;
				messageList = Collections.emptyList();
			}
			return new MessageListView(messageList, messageTotalCount, currentPageNumber, MESSAGE_COUNT_PER_PAGE,
					firstRow, endRow);
		
/*		try {
			Connection conn = null;
		conn = ConnectionProvider.getConnection();
		//전체 게시물 구하기
		

		} catch (SQLException e) {
			throw new ServiceException("메시지 목록 구하기 실패: " + e.getMessage(), e);
		} finally {
			JdbcUtil.close(conn);
		}*/
		
		

	}
	
	
}
