package distributed.mall.user.service;

import com.alibaba.dubbo.config.annotation.Service;
import distributed.mall.common.utils.pojo.ResponseResult;
import distributed.mall.pojo.mapper.UserMapper;
import distributed.mall.pojo.pojo.User;
import distributed.mall.user.api.RegisterService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * <b><code>RegisterServiceImpl</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/1/16 20:11.
 *
 * @author virvil
 * @since distributed-mall ${PROJECT_VERSION}
 */
@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public ResponseResult doRegister(User user) throws Exception {
        List<User> users = userMapper.findUserByUsername(user.getUsername());
        if (!CollectionUtils.isEmpty(users)){
            return ResponseResult.error("该用户名被注册过");
        }
        Date date = new Date();
        user.setCreateTime(date);
        user.setUpdateTime(date);
        int success = userMapper.insertSelective(user);
        if (success<0){
            return ResponseResult.error("注册失败");
        }
        return ResponseResult.success("注册成功");
    }
}
