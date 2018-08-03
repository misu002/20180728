package DAO;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import BeanModel.userinfo;

public class MybatisUserDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public userinfo selectById(String id) {
		String str="com.bitcamp.mywebsite.mapper.mybatis.UserMapper.selectById";
		System.out.println("mybatisDao selectbyId 실행");
		return (userinfo)sqlSessionTemplate.selectOne(str, id);
	}
	public int insertUser(userinfo info) {
		String str="com.bitcamp.mywebsite.mapper.mybatis.UserMapper.insertUser";
		System.out.println("mybatisDao insertUser 실행");
		return sqlSessionTemplate.update(str,info);
	}
	public List<userinfo> selectUser() {
		String str="com.bitcamp.mywebsite.mapper.mybatis.UserMapper.selectUser";
		System.out.println("mybatisDao selectUser 실행");
		System.out.println(sqlSessionTemplate.selectList(str));
		return sqlSessionTemplate.selectList(str);
	}	
}
