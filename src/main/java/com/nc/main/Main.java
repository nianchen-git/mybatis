package com.nc.main;

import com.nc.model.User;

import com.nc.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
//        helloWord();
//        addUser();
//        deleteUserById();
//        updateUserById();
//        queryUser();
    }

    private static void queryUser() {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getInstance("mybatis-config.xml");
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> userList = sqlSession.selectList("com.nc.mapper.queryUser");
        System.out.println(userList);
        sqlSession.commit();
        sqlSession.close();
    }

    private static void updateUserById() {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getInstance("mybatis-config.xml");
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = new User();
        user.setId("2");
        user.setUsername("小张");
        int update = sqlSession.update("com.nc.mapper.updateUserById", user);
        System.out.println(update);
        sqlSession.commit();
        sqlSession.close();
    }

    private static void deleteUserById() {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getInstance("mybatis-config.xml");
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int delete = sqlSession.delete("com.nc.mapper.deleteUserById", "1");
        System.out.println(delete);
        sqlSession.commit();
        sqlSession.close();
    }

    private static void addUser() {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getInstance("mybatis-config.xml");
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = new User();
        user.setUsername("赵八");
        user.setAddress("东北");
        int insert = sqlSession.insert("com.nc.mapper.addUser2",user);
        System.out.println(insert);
        sqlSession.commit();
        sqlSession.close();
    }


    /**
     * 第一个例子
     * */
    private static void helloWord() throws IOException {
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = factory.openSession();
        User user = sqlSession.selectOne("com.nc.mapper.queryUserById", 3);
        System.out.println(user);
        sqlSession.close();
    }
}
