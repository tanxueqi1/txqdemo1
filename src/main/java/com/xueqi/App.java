package com.xueqi;

import com.xueqi.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) throws IOException {
        //读取配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //通过SqlSessionFactoryBuilder创建SqlSessionFactory会话工厂
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
        //通过SqlSessionFactory创建SqlSession
        SqlSession session = ssf.openSession();
        //调用SqlSesion的操作数据库方法
        User user = session.selectOne("findUserById", 10);
        System.out.println(user);

        //关闭SqlSession
        session.close();
    }

}
