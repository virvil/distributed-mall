package distributed.mall.manager.controller;

import distributed.mall.common.utils.pojo.ResponseResult;
import distributed.mall.manager.service.UserService;
import distributed.mall.pojo.pojo.Permission;
import distributed.mall.pojo.pojo.Role;
import distributed.mall.pojo.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <b><code>UserController</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/1/11 16:47.
 *
 * @author zyg
 * @since shiro-redis-sso ${PROJECT_VERSION}
 */
@Api(value = "用户管理类")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户查找",notes = "根据用户密码")
    @RequestMapping(value = "findUser",method = RequestMethod.POST)
    public ResponseResult findUserByUsernameAndPassword(String username, String password) throws Exception{
        User user = userService.findUserByUsernameAndPassword(username, password);
        return ResponseResult.success(user);
    }

    @ApiOperation(value = "用户查找",notes = "根据用户名")
    @RequestMapping(value = "findUserByUserName",method = RequestMethod.POST)
    public ResponseResult findUserByUsername(String username) throws Exception{
        User user = userService.findUserByUsername(username);
        return ResponseResult.success(user);
    }

    @ApiOperation(value = "用户列表")
    @RequestMapping(value = "findAll",method = RequestMethod.GET)
    public ResponseResult findAll() throws Exception{
        List<User> users = userService.findAll();
        return ResponseResult.success(users);
    }

    @ApiOperation(value = "用户角色接口")
    @RequestMapping(value = "findRole",method = RequestMethod.GET)
    public ResponseResult findRoleByUsername(String username) throws Exception{
        List<Role> roles = userService.findRoleByUsername(username);
        return ResponseResult.success(roles);
    }

    @ApiOperation(value = "用户权限接口")
    @RequestMapping(value = "findPermission",method = RequestMethod.GET)
    public ResponseResult findPermissionByUsername(String username) throws Exception{
        List<Permission> permissions = userService.findPermissionByUsername(username);
        return ResponseResult.success(permissions);
    }

    @ApiOperation(value = "用户添加接口")
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public ResponseResult insert(User user) throws Exception{
        int success = userService.insert(user);
        if (success<0){
            ResponseResult.error("用户添加失败");
        }
        return ResponseResult.success("用户添加成功");
    }

    @ApiOperation(value = "用户更新接口")
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public ResponseResult updateById(User user) throws Exception{
        int success = userService.updateById(user);
        if (success<0){
            ResponseResult.error("用户更新失败");
        }
        return ResponseResult.success("用户更新成功");
    }
}
