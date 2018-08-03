package DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import BeanModel.userinfo;

public class jdbcTemplateUserinfoDao {
	@Autowired
	JdbcTemplate template;
	
	
	public userinfo selectById(String id) {
		userinfo resultObj=null;
		String sql="select id,pw,name,birth,gender,phone,nvl(email,'없음'),imgname from userinfo where id=?";
//		List<userinfo> userlist=template.query(sql, new UserinfoRowMapper(),id);
//		resultObj=userlist.isEmpty() ? null : userlist.get(0);
		
		resultObj=template.queryForObject(sql, new UserinfoRowMapper(),id);
		
		return resultObj;
	}
	
	public int insertUser(userinfo userinfo) {
		int resultCnt=0;
		String sql="insert into userinfo values(?,?,?,?,?,?,?,?)";
		String birth=userinfo.getYear()+"-"+userinfo.getMonth()+"-"+userinfo.getDay();
		resultCnt=template.update(sql,userinfo.getId(),userinfo.getPw(),userinfo.getName(),birth,
				userinfo.getGender(),userinfo.getPhone(),userinfo.getEmail(),userinfo.getImgname());
		
		
		return resultCnt;
	}
	
	
	public List<userinfo> selectUser(){
		List<userinfo> userlist;
		String sql="select id,pw,name,birth,gender,phone,nvl(email,'없음'),imgname from userinfo";
		//userlist 는 userinfo만들어진 배열들임 for,문으로 돌려야하나
		userlist=template.query(sql, new UserinfoRowMapper());
		return userlist;
	}
	
}

