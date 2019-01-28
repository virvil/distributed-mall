package distributed.mall.user.service;

import com.alibaba.dubbo.config.annotation.Service;
import distributed.mall.common.utils.FastDFS.FastDFSClientUtil;
import distributed.mall.common.utils.Redis.ConstantRedisConfig;
import distributed.mall.common.utils.Redis.RedisUtil;
import distributed.mall.common.utils.json.JsonUtil;
import distributed.mall.common.utils.pojo.ResponseResult;
import distributed.mall.pojo.mapper.UserMapper;
import distributed.mall.pojo.pojo.User;
import distributed.mall.user.api.LoginService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <b><code>LoginServiceImpl</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/1/14 9:32.
 *
 * @author virvil
 * @since distributed-mall ${PROJECT_VERSION}
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserMapper userMapper;

    public ResponseResult doLogin( String username, String password) throws Exception {
        List<User> users = userMapper.findUserByUsernameAndPassword(username, password);
        if (CollectionUtils.isEmpty(users)){
            return ResponseResult.error("用户名或密码错误");
        }
        User user = users.get(0);
        if (user.getStatus() == 2){
            return ResponseResult.error("该账号被冻结");
        }
        return ResponseResult.success("登录成功",user);
    }

    public ResponseResult getUserByToke(String token) throws Exception {
        String value = RedisUtil.get(ConstantRedisConfig.TOKEN_PREFIX + token);
        if (StringUtils.isBlank(value)){
            return ResponseResult.error("授权令牌无效");
        }
        User user = (User)JsonUtil.getJsonObject(value, User.class);
        RedisUtil.expire(ConstantRedisConfig.TOKEN_PREFIX+token, ConstantRedisConfig.TOKEN_EXPIRE);
        return ResponseResult.success(user);
    }

    public ResponseResult logoutByToken(String token) throws Exception {
        Long success = RedisUtil.del(ConstantRedisConfig.TOKEN_PREFIX + token);
        System.out.println(success);
        if (success>0) {
            return ResponseResult.success("成功退出登录");
        }
        return ResponseResult.error("用户未登录或者已退出");
    }
}
