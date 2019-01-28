package distributed.mall.user.api;

import distributed.mall.pojo.pojo.Permission;
import distributed.mall.pojo.pojo.Role;
import distributed.mall.pojo.pojo.User;

import java.util.List;

/**
 * <b><code>UserService</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/1/11 16:08.
 *
 * @author zyg
 * @since shiro-redis-sso ${PROJECT_VERSION}
 */

public interface UserService {
    User getUserById(int id)throws Exception;

    List<User> findUserSelective(User user) throws Exception;

    User findUserByUsernameAndPassword(String username, String password) throws Exception;

    User findUserByUsername(String username) throws Exception;

    User findUserByPhone(String phone) throws Exception;

    User findUserByEmail(String email) throws Exception;

    List<User> findAll() throws Exception;

    List<Role> findRoleByUsername(String username) throws Exception;

    List<Permission> findPermissionByUsername(String username) throws Exception;

    int insertSelective(User user) throws Exception;

    int updateById(User user) throws Exception;
}
