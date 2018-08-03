package Services;

import java.io.UnsupportedEncodingException;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class MailSenderService {
	@Autowired
	JavaMailSender mailSender;
	
	public void htmlMailSend() throws UnsupportedEncodingException {
		MimeMessage message = mailSender.createMimeMessage();
		
		try {
			MimeMessageHelper messageHelper=new MimeMessageHelper(message,true,"utf-8");
			messageHelper.setSubject("[공지] 안녕하세요 필요한 문서를 첨부하였습니다.");
			//내용구성(HTML)
			String html="<h1>안녕하세요 회원님</h1>회원가입을 진심으로 감사드립니다 <br>"
			+"이메일을 인증을 위해서는 아래 링크를 클릭해주세요 <br><br>"
			+"<a href=\"http://localhost/mywebsite/\">사이트 가기</a>";

			//내용설정 html로
			messageHelper.setText(html,true);
			
			//보내는 사람의 메일 설정
			messageHelper.setFrom("misu00282@gmail.com","관리자");
			
			//받는 사람의 메일 설정
			messageHelper.setTo(new InternetAddress("misu002@naver.com","Mia","utf-8"));
			
			//파일 첨부 설정
			DataSource source= new FileDataSource("C:\\Users\\HB04-15\\Desktop\\설명.txt");
			
			messageHelper.addAttachment(MimeUtility.encodeText("설명서.txt","utf-8","B"), source);
			
			mailSender.send(message);
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		
		
	}
}