package com.solvd.web.saucedemo.db;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

public class MyBatisUtil {

    private static SqlSessionFactory factory;

    static {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis/mybatis-config.xml");
            factory = new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static SqlSession openSession() {
        return factory.openSession(true);
    }
}