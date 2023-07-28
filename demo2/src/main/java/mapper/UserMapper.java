package mapper;


import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    /**
     * 面向接口编程的mybatis有两个一致：
     * 1. 映射文件中namespace与Mapper接口的全类名一致
     * 2. SQL语句的id与方法名保持一致
     * @param id
     * @return
     */
    Integer deleteUser(int id);

    Map<String, Object> getUserToMap(@Param("username") String username, @Param("password") String passwd);

    List<Map<String, Object>> getAllUserToMap();

    @MapKey("id")
    Map<String, Object> getAllUserToMapByMapKey();

    Integer insertUser(User u);

    User getUserByName(String name);

    User checkLogin(String username, String passwd);

    User checkLoginByUser(@Param("user")User user);

    User checkLoginByMap(Map<String, String> map);

    User checkLoginByParam(@Param("username") String username, @Param("password") String passwd);

    List<User> getUsersByDynamicTable(@Param("tableName") String tableName,
                                      @Param("username") String username, @Param("password") String passwd);
}
