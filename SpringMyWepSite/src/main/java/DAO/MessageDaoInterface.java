package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import BeanModel.Message;

public interface MessageDaoInterface {

	public int insert(Message message);
	public int selectCount();
	public List<Message> selectList(int firstRow, int endRow);
	public int delete(int messageId);
	public Message selectbyId(int messageId); 
	
}
