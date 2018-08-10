package Services;

import java.io.UnsupportedEncodingException;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import javax.mail.internet.MimeMessage.RecipientType;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import BeanModel.userinfo;
import DAO.UserDaoInterface;

public class MailSenderService {
	@Autowired
	JavaMailSender mailSender;
	
	@Autowired
	GetUserService getUserService;
	
	@Autowired
	private SqlSessionTemplate template;
	
	private UserDaoInterface userDao;
	
	public void htmlMailSend(userinfo info) throws UnsupportedEncodingException {
		MimeMessage message = mailSender.createMimeMessage();
		
		try {
			MimeMessageHelper messageHelper=new MimeMessageHelper(message,true,"utf-8");
			messageHelper.setSubject("[인증] 안녕하세요! 회원가입을 축하드립니다!");
			//내용구성(HTML)
			String html="<h1>안녕하세요 "+info.getName()+"회원님</h1>회원가입을 진심으로 감사드립니다 <br>"
			+"이메일을 인증을 위해서는 아래 링크를 클릭해주세요 <br><br>"
			+"<a href=\"http://localhost/mywebsite/verified/?userId="+info.getId()+"\">사이트 가기</a>";	

			//내용설정 html로
			messageHelper.setText(html,true);			
			//보내는 사람의 메일 설정
			messageHelper.setFrom("misu00282@gmail.com","Catering Blog");			
			//받는 사람의 메일 설정
			messageHelper.setTo(new InternetAddress(info.getEmail(),info.getName(),"utf-8"));
			mailSender.send(message);
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public int confirmUpdateById(String userId) {
		userDao=template.getMapper(UserDaoInterface.class);
		int resultCnt=userDao.updateById(userId);
		return resultCnt;
	}
	
	//메일 보내고 해당 사용자의 비번도 바꾸기
	public void findMailSend(String userId, String email,String tmpPw) throws UnsupportedEncodingException {
		MimeMessage message = mailSender.createMimeMessage();

		try {
			MimeMessageHelper messageHelper=new MimeMessageHelper(message,true,"utf-8");
			messageHelper.setSubject("[인증] 안녕하세요! 회원가입을 축하드립니다!");
			//내용구성(HTML)
			String html="<h1>안녕하세요 "+userId+"회원님</h1>"
			+"임시 비밀번호는 다음과 같습니다 : "+tmpPw
			+"새로운 비밀번호를 지정하기 위해서는 아래 링크를 클릭해주세요 <br><br>"
			+"<a href=\"http://localhost/mywebsite/changePw/?userId="+userId+"\">사이트 가기</a>";	

			//내용설정 html로
			messageHelper.setText(html,true);			
			//보내는 사람의 메일 설정
			messageHelper.setFrom("misu00282@gmail.com","Catering Blog");			
			//받는 사람의 메일 설정
			messageHelper.setTo(new InternetAddress(email,userId,"utf-8"));
			mailSender.send(message);
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public int tmpPwUpdate(String userId,String tmpPw) {
		userDao=template.getMapper(UserDaoInterface.class);
		int resultCnt=userDao.updateTmpPw(userId,tmpPw);
		return resultCnt;		
	}
	
	public int changePwUpdate(String userId,String changePw) {
		userDao=template.getMapper(UserDaoInterface.class);
		int resultCnt=userDao.updateChangePw(userId, changePw);
		return resultCnt;	
	}
	
}