package com.demo;

import static org.junit.Assert.*;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.demo.dao.UserMapper;
import com.demo.models.User;

public class UserMapperTest {
	private SqlSessionFactory sqlSessionFactory;
	private SqlSession session;

	@Before
	public void setUp() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("Configuration.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sqlSessionFactory.openSession();
	}

	@After
	public void tearDown() throws Exception {
		session.close();
		System.out.println("==close session");
	}

	@Test
	public void testSelectById() {
		UserMapper mapper = session.getMapper(UserMapper.class);
		User user = mapper.selectById(1);
		System.out.println(JSON.toJSONString(user));
	}

	@Test
	public void testInsertUser() {
		UserMapper mapper = session.getMapper(UserMapper.class);
		User user = new User();
		user.setUsername("liu");
		user.setPassword("ss");
		int nums = mapper.insertUser(user);
		session.commit();
		System.out.println(user.getId());
	}
	
	@Test
	public void testInsertUser2() {
		UserMapper mapper = session.getMapper(UserMapper.class);
		User user = new User();
		user.setUsername("liu");
		user.setPassword("ss");
		int nums = mapper.insertUser2(user);
		session.commit();
		System.out.println(user.getId());
	}	
}
