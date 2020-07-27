package com.nc.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class SqlSessionFactoryUtils {
    private static SqlSessionFactory SQL_SESSION_FACTORY = null;
    /**
     * 获取SqlSessionFactory实例
     * @param path mybatis.xml路径
     * */
    public static SqlSessionFactory getInstance(String path){
        if(SQL_SESSION_FACTORY == null){
            try{
                SQL_SESSION_FACTORY = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader(path));
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        return SQL_SESSION_FACTORY;
    }

}
