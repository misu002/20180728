package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import BeanModel.Message;

public interface MessageDaoInterface {

	public int insert(Message message);
	public int selectCount();
	public List<Message> selectList(@Param("firstRow") int firstRow, @Param("endRow") int endRow);
	public int delete(int messageId);
	
}
