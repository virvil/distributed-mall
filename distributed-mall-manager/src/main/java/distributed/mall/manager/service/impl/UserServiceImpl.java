package distributed.mall.manager.service.impl;

import distributed.mall.manager.service.UserService;
import distributed.mall.pojo.pojo.Permission;
import distributed.mall.pojo.pojo.Role;
import distributed.mall.pojo.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <b><code>UserServiceImpl</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/1/25 16:43.
 *
 * @author virvil
 * @since distributed-mall ${PROJECT_VERSION}
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public User findUserByUsernameAndPassword(String username, String password) throws Exception {
        return null;
    }

    @Override
    public User findUserByUsername(String username) throws Exception {
        return null;
    }

    @Override
    public List<User> findAll() throws Exception {
        return null;
    }

    @Override
    public List<Role> findRoleByUsername(String username) throws Exception {
        return null;
    }

    @Override
    public List<Permission> findPermissionByUsername(String username) throws Exception {
        return null;
    }

    @Override
    public int insert(User user) throws Exception {
        return 0;
    }

    @Override
    public int updateById(User user) throws Exception {
        return 0;
    }
}
