package com.demo.service;
import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.demo.models.User;

public class UserService {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("Configuration.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        try {
            User user = (User) session.selectOne("com.jin.models.UserMapper.selectUserByID", 1);
            System.out.println(user.getUsername());
        } finally {
            session.close();
        }
    }
}
