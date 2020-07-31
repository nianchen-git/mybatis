package com.nc.main;

import com.nc.mapper.AdminMapper;
import com.nc.model.Admin;
import com.nc.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class AdminMain {
    public static void main(String[] args) {
//        oneToMany();
        oneToManyLazy();
    }

    private static void oneToManyLazy() {
        SqlSessionFactory instance = SqlSessionFactoryUtils.getInstance("mybatis-config.xml");
        SqlSession sqlSession = instance.openSession();
        AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
        Admin admin = adminMapper.getAdminByIdToLazy(1);
        System.out.println("==========懒加载==========");
        System.out.println(admin);
        System.out.println("============第二次============");
        Admin admin1 = adminMapper.getAdminByIdToLazy(1);
        System.out.println(admin1);
        sqlSession.close();
    }

    private static void oneToMany() {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getInstance("mybatis-config.xml");
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
        Admin admin = adminMapper.getAdminById(1);
        System.out.println(admin);
        sqlSession.close();
    }
}
