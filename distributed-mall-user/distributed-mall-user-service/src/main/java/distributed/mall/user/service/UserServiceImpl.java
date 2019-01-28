package distributed.mall.user.service;

import com.alibaba.dubbo.config.annotation.Service;
import distributed.mall.pojo.mapper.UserMapper;
import distributed.mall.pojo.pojo.Permission;
import distributed.mall.pojo.pojo.Role;
import distributed.mall.pojo.pojo.User;
import distributed.mall.user.api.UserService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * <b><code>UserServiceImpl</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/1/11 16:09.
 *
 * @author zyg
 * @since shiro-redis-sso ${PROJECT_VERSION}
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(int id) throws Exception {
        List<User> users = userMapper.getUserById(id);
        if (CollectionUtils.isEmpty(users)){
            return null;
        }
        return users.get(0);
    }

    @Override
    public List<User> findUserSelective(User user) throws Exception {
        List<User> users = userMapper.findUserSelective(user);
        return users;
    }

    public User findUserByUsernameAndPassword(String username, String password) throws Exception {
        List<User> users = userMapper.findUserByUsernameAndPassword(username, password);
        if (CollectionUtils.isEmpty(users)){
            return null;
        }
        return users.get(0);
    }


    public User findUserByUsername(String username) throws Exception {
        List<User> users = userMapper.findUserByUsername(username);
        if (CollectionUtils.isEmpty(users)){
            return null;
        }
        return users.get(0);
    }

    @Override
    public User findUserByPhone(String phone) throws Exception {
        List<User> users = userMapper.findUserByPhone(phone);
        if (CollectionUtils.isEmpty(users)){
            return null;
        }
        return users.get(0);
    }

    @Override
    public User findUserByEmail(String email) throws Exception {
        List<User> users = userMapper.findUserByEmail(email);
        if (CollectionUtils.isEmpty(users)){
            return null;
        }
        return users.get(0);
    }


    public List<User> findAll() throws Exception {
        List<User> users = userMapper.findAll();
        return users;
    }

    @Override
    public int insertSelective(User user) throws Exception {
        Date date = new Date();
        user.setCreateTime(date);
        user.setUpdateTime(date);
        int success = userMapper.insertSelective(user);
        return success;
    }

    public int updateById(User user) throws Exception {
        user.setUpdateTime(new Date());
        int success = userMapper.updateById(user);
        return success;
    }

    public List<Role> findRoleByUsername(String username) throws Exception {
        List<Role> roles = userMapper.findRoleByUsername(username);
        return roles;
    }


    public List<Permission> findPermissionByUsername(String username) throws Exception {
        List<Permission> permissions = userMapper.findPermissionByUsername(username);
        return permissions;
    }
}
