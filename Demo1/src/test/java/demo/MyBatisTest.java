package demo;

import com.mskj.demo.mapper.UserMapper;
import com.mskj.demo.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {

    @Test
    public void testSelect() throws IOException {
        String config = "mybatis-config.xml";
        InputStream in = Resources.getResourceAsStream(config);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        User user = sqlSession.selectOne("UserMapper.getUser", 1);
//        User user = mapper.getUser(0);
//        System.out.println(user);
        List<User> list = mapper.getAllUsers();
        list.forEach(System.out::println);
    }

    @Test
    public void testInsert() throws IOException {
        String config = "mybatis-config.xml";
        InputStream in = Resources.getResourceAsStream(config);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setPassword("123");
        user.setAge(22);
        user.setSex('M');
        user.setEmail("333@163.com");
        mapper.insertUser(user);
//        System.out.println(id);
    }
}
