package distributed.mall.pojo.mapper;



import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import distributed.mall.pojo.pojo.Permission;
import distributed.mall.pojo.pojo.Role;
import distributed.mall.pojo.pojo.User;

import java.util.List;

/**
 * <b><code>UserMapper</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/1/11 15:02.
 *
 * @author zyg
 * @since shiro-redis-sso ${PROJECT_VERSION}
 */

@Mapper
public interface UserMapper {

    List<User> getUserById(int id) throws Exception;

    List<User> findUserSelective(User user) throws Exception;

    List<User> findUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password) throws Exception;

    List<User> findUserByUsername(String username)throws Exception;

    List<User> findUserByPhone(String phone) throws Exception;

    List<User> findUserByEmail(String email) throws Exception;

    List<User> findAll() throws Exception;

    List<Role> findRoleByUsername(String username) throws Exception;

    List<Permission> findPermissionByUsername(String username) throws Exception;

    int insertSelective(User user) throws Exception;

    int updateById(User user) throws Exception;
}
