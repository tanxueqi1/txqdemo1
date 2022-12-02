package com.xueqi.mybatisTest;

import com.xueqi.mapper.UserMapper;
import com.xueqi.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class Demo2 {

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
     * 插入数据
     */
    @Test
    public void test1() {

        User addUser = new User("xueqi2", new Date(), "1", "深圳");
        UserMapper mapper = session.getMapper(UserMapper.class);
        mapper.save(addUser);
        //增删改需要提交事务
        session.commit();
        System.out.println("新增用户的id: " + addUser.getId());

    }

    /**
     * 查1条数据
     */
    @Test
    public void test2() {

        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.findUserById(37);

        System.out.println("查询到的用户: " + user);

    }

    /**
     * 查多条数据
     */
    @Test
    public void test3() {

        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> users = mapper.findUserByName("xueqi");

        System.out.println("查询到的用户: " + users);

    }

    /**
     * 删除数据
     */
    @Test
    public void test4() {

        UserMapper mapper = session.getMapper(UserMapper.class);
        mapper.deleteUser(41);
        session.commit();

    }

    /**
     * 更新数据
     */
    @Test
    public void test5() {

        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = new User();
        user.setId(42);
        user.setSex("男");
        user.setAddress("深圳宝安");
        mapper.updateUser(user);
        session.commit();

    }

}
