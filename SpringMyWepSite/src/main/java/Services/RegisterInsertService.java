package Services;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import DAO.MybatisUserDao;
import DAO.UserDaoInterface;
import DAO.jdbcTemplateUserinfoDao;
import DAO.userinfoDao;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import BeanModel.userinfo;

public class RegisterInsertService {
	@Autowired
	//userinfoDao UserinfoDao;
	//jdbcTemplateUserinfoDao UserinfoDao;
	//MybatisUserDao UserinfoDao;
	private SqlSessionTemplate template;
	
	private UserDaoInterface UserinfoDao;
	
	@Transactional
	public int register(userinfo userinfo,HttpServletRequest request)  throws ServiceException, IllegalStateException, IOException  {
		Connection conn=null;		
		//DB 저장용 파일이름,물리적저장 
		String imgName="";
		//물리적인 저장
		//1.저장 경로 설정
		String uploadUri="/resources/uploadFile/memberPhoto";
		//2.시스템의 물리적인 경로
		String dir=request.getSession().getServletContext().getRealPath(uploadUri);
		//사용자의 업로드 파일을 물리적으로 저장
		if(!userinfo.getPhotoFile().isEmpty()) {
			//imgName=System.currentTimeMillis()+userinfo.getPhotoFile().getOriginalFilename();
			imgName=userinfo.getId()+"_"+userinfo.getPhotoFile().getOriginalFilename();
			userinfo.getPhotoFile().transferTo(new File(dir,imgName));
			userinfo.setImgname(imgName);			
		}	
		System.out.println(dir);
		UserinfoDao=template.getMapper(UserDaoInterface.class);
		int resultCnt=UserinfoDao.insertUser(userinfo);
		return resultCnt;
		
		
/*		try {
			conn=ConnectionProvider.getConnection();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ServiceException("메시지 목록 구하기 실패: " + e.getMessage(), e);
		}finally {		
			JdbcUtil.close(conn);
		}*/
	}
	
}
