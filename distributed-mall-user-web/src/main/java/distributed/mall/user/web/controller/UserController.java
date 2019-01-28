package distributed.mall.user.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import distributed.mall.common.utils.FastDFS.FastDFSClientUtil;
import distributed.mall.common.utils.Redis.ConstantRedisConfig;
import distributed.mall.common.utils.Redis.RedisUtil;
import distributed.mall.common.utils.json.JsonUtil;
import distributed.mall.common.utils.pojo.ResponseResult;
import distributed.mall.pojo.pojo.User;
import distributed.mall.user.api.LoginService;
import distributed.mall.user.api.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


/**
 * <b><code>UserController</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/1/20 21:55.
 *
 * @author virvil
 * @since distributed-mall ${PROJECT_VERSION}
 */
@Api("用户信息操作类")
@RestController
@RequestMapping("user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private FastDFSClientUtil fastDFSClientUtil;

    @Reference
    private UserService userService;

    @Reference
    private LoginService loginService;

    @ApiOperation(value = "修改用户密码")
    @PostMapping("udpPassword")
    public ResponseResult updPassword(int userId,String oldPassword,String newPassword) throws Exception{
        User user = userService.getUserById(userId);
        if (null != user){
            if (user.getPassword().equals(oldPassword)){
                user.setPassword(newPassword);
                int result = userService.updateById(user);
                return ResponseResult.success(result);
            }
        }
        return ResponseResult.error();
    }

    @ApiOperation(value = "上传用户头像")
    @PostMapping("uploadImage")
    public ResponseResult uploadImage(MultipartFile file,int userId, String token)throws Exception{
        User user = userService.getUserById(userId);
        if (user == null){
            return ResponseResult.error("获取用户失败");
        }

        String filename = file.getOriginalFilename();
        logger.info("图片本地上传地址:{}",filename);
        String remoteFileName = fastDFSClientUtil.uploadFile("C:\\Users\\Administrator\\Pictures\\middle_444x652-120207_v2_19441462334527927_cbe6d02af9ad43e175be4c7bc7486aa9.png");
        logger.info("图片远程地址:{}",remoteFileName);
        user.setImagePath(remoteFileName);
        userService.updateById(user);
        ResponseResult responseResult = loginService.getUserByToke(token);
        user = (User)responseResult.getData();
        RedisUtil.set(ConstantRedisConfig.TOKEN_PREFIX+token,JsonUtil.getJsonString(user));
        RedisUtil.expire(ConstantRedisConfig.TOKEN_PREFIX+token, ConstantRedisConfig.TOKEN_EXPIRE);
        return ResponseResult.success(remoteFileName);
    }

}
