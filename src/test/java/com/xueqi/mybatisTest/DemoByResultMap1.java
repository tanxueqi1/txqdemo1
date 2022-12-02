package com.xueqi.mybatisTest;

import com.xueqi.mapper.UserMapper;
import com.xueqi.model.User;
import com.xueqi.vo.UserQueryVO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class DemoByResultMap1 {

    static SqlSession session;

    @BeforeAll
    public static void before() throws IOException {
        System.out.println("before ......获取session");
        //读取配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //通过SqlSessionFactoryBuilder创建SqlSessionFactory会话工厂
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
        //通过SqlSessionFactory创建SqlSession
        session = ssf.openSession();
    }

    @AfterAll
    public static void after(){
        System.out.println("after ..... 关闭session");
        //关闭SqlSession
        session.close();
    }



    /**
     * 查数据
     */
    @Test
    public void test2() {

        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.findUserByIdResultMap(1);
        System.out.println(user);

    }



}
