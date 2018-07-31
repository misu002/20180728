package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import BeanModel.userinfo;

public class UserinfoRowMapper implements RowMapper<userinfo> {

	@Override
	public userinfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		userinfo Userinfo=new userinfo();
		Userinfo.setId(rs.getString(1));
		Userinfo.setPw(rs.getString(2));
		Userinfo.setName(rs.getString(3));
		//date로 받아서 String바꾸고 년도 달 day로 나누기
		Date date = rs.getDate(4);
		String date1=date.toString();
		String[] finaldate= date1.split("-");
		Userinfo.setYear(finaldate[0]);
		Userinfo.setMonth(finaldate[1]);
		Userinfo.setDay(finaldate[2]);
		Userinfo.setGender(rs.getString(5));
		Userinfo.setPhone(rs.getString(6));
		Userinfo.setEmail(rs.getString(7));
		Userinfo.setImgname(rs.getString(8));
		
		return Userinfo;
	}

}


