import mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.User;
import utils.SqlSessionUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestSelect {

    @Test
    public void testGetUserByName() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserByName("Tony' or 1=1 #");
        System.out.println(user);
    }

    @Test
    public void testCheckLogin() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.checkLogin("Tony", "123");
        System.out.println(user);
    }

    @Test
    public void testCheckLoginByMap() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, String> param = new HashMap<>();
        param.put("username", "Tony");
        param.put("password", "123");
        User user = mapper.checkLoginByMap(param);
        System.out.println(user);
    }

    @Test
    public void testInsert() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(0, "Jane1", "000", 24, 'F', "qq@163.com");
        Integer id = mapper.insertUser(user);
        System.out.println(id);
    }

    @Test
    public void testDelete() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int n = mapper.deleteUser(12);
        System.out.println(n);
    }

    @Test
    public void testCheckLoginByParam() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.checkLoginByParam("Jane1", "123");
        System.out.println(user);
    }

    @Test
    public void testCheckLoginByUser() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User old = new User();
        old.setUsername("Jane1");
        old.setPassword("123");
        User user = mapper.checkLoginByUser(old);
        System.out.println(user);
    }

    @Test
    public void testGetUserToMap() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> user = mapper.getUserToMap("Jane1", "123");
        System.out.println(user);
    }

    @Test
    public void testGetAllUserToMap() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<Map<String, Object>> user = mapper.getAllUserToMap();
        System.out.println(user.size());
    }

    @Test
    public void testGetAllUserToMapByMapKey() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> user = mapper.getAllUserToMapByMapKey();
        System.out.println(user);
    }

    @Test
    public void testDynamicTableName() throws IOException {
        UserMapper userMapper = SqlSessionUtils.getMapper(UserMapper.class);
        List<User> users = userMapper.getUsersByDynamicTable("user", "Jane1", "123");
        System.out.println(users);
    }
}
