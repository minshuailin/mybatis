package com.msl;

import com.msl.mapper.UserMapper;
import com.msl.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author: msl
 * @CreateDate: Created in 2020/8/7  <br>
 * @Description: TODO
 */
public class MybatisDemo {
    public static void main(String[] args) throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatisConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();
        userList.forEach(System.out:: println);

        List<Object> objects = sqlSession.selectList("com.msl.mapper.UserMapper.getUserList");
        objects.forEach(System.out::println);

        sqlSession.close();
    }
}
