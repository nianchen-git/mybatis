package com.nc.main;

import com.nc.mapper.UserMapper;
import com.nc.model.User;

import com.nc.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
//        helloWord();
//        addUser();
//        deleteUserById();
        updateUserById();
//        queryUser();
//        mapperXml();
//        setHandler();
//        ifpage();
//        whereIdAndName();
//        forEachByIds();

    }

    private static void forEachByIds() throws IOException {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Integer[] ids = {1,2,3,4,5};
        List<User> userList = userMapper.queryUserByIds(ids);
        System.out.println(userList);
        sqlSession.close();
    }

    private static void whereIdAndName() throws IOException {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId("3");
//        user.setUsername("三");
        List<User> userList = userMapper.queryUserByUsernameAndId(user);
        System.out.println(userList);
        sqlSession.close();
    }

    private static void ifpage() {
        SqlSessionFactory instance = SqlSessionFactoryUtils.getInstance("mybatis-config.xml");
        SqlSession sqlSession = instance.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.queryUserByPage(null,null);
        System.out.println(userList);
        List<User> userList1 = userMapper.queryUserByPage(1, 3);
        System.out.println(userList1);
        sqlSession.close();
    }

    private static void setHandler() {
        SqlSessionFactory instance = SqlSessionFactoryUtils.getInstance("mybatis-config.xml");
        SqlSession sqlSession = instance.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("转换");
        user.setAddress("上海");
        List<String> favorites = new ArrayList<>();
        favorites.add("篮球");
        favorites.add("足球");
        favorites.add("排球");
        user.setFavorites(favorites);
        userMapper.addUser3(user);
        sqlSession.commit();
        sqlSession.close();
    }

    private static void mapperXml() {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getInstance("mybatis-config.xml");
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.queryUser();
        System.out.println(userList);
//        Integer update = userMapper.updateUserById1("2", "小松");
//        System.out.println(update);
        sqlSession.commit();
        sqlSession.close();
    }

    private static void queryUser() {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getInstance("mybatis-config.xml");
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> userList = sqlSession.selectList("com.nc.mapper.UserMapper.queryUser");
        System.out.println(userList);
        sqlSession.commit();
        sqlSession.close();
    }

    private static void updateUserById() {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getInstance("mybatis-config.xml");
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = new User();
        user.setId("6");
        user.setUsername("松松");
        List<String> favorites = new ArrayList<>();
        favorites.add("篮球");
        favorites.add("LOL");
        user.setFavorites(favorites);
        int update = sqlSession.update("com.nc.mapper.UserMapper.updateUserById", user);
        System.out.println(update);
        sqlSession.commit();
        sqlSession.close();
    }

    private static void deleteUserById() {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getInstance("mybatis-config.xml");
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int delete = sqlSession.delete("com.nc.mapper.UserMapper.deleteUserById", "1");
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
        int insert = sqlSession.insert("com.nc.mapper.UserMapper.addUser2",user);
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
        User user = sqlSession.selectOne("com.nc.mapper.UserMapper.queryUserById", 7);
        System.out.println(user);
        sqlSession.close();
    }
}
