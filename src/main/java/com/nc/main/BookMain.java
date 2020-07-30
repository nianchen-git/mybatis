package com.nc.main;

import com.nc.mapper.BookMapper;
import com.nc.model.Book;
import com.nc.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.util.List;

public class BookMain {
    public static void main(String[] args) throws IOException {
        lazyLoading();
//        reallyLazy();

    }

    private static void reallyLazy() {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getInstance("mybatis-config.xml");
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        List<Book> books = bookMapper.queryAllBook();
        System.out.println("=================");
        for (Book b: books) {
//            System.out.print(b.getName() + ", ");
            System.out.println(b);
        }
    }

    private static void lazyLoading() throws IOException {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        Book book = bookMapper.getBookById2(3);
        System.out.println("==========懒加载==========");
        System.out.println(book.getName());
        sqlSession.commit();
        sqlSession.close();
    }
}
