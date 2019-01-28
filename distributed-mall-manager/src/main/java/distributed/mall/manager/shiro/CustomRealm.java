package distributed.mall.manager.shiro;

import com.alibaba.dubbo.config.annotation.Reference;
import distributed.mall.manager.service.UserService;
import distributed.mall.pojo.pojo.Permission;
import distributed.mall.pojo.pojo.Role;
import distributed.mall.pojo.pojo.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <b><code>CustomRealm</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/1/10 15:15.
 *
 * @author zyg
 * @since shiro-redis-sso ${PROJECT_VERSION}
 */
public class CustomRealm extends AuthorizingRealm {

    private final Logger logger = LoggerFactory.getLogger(CustomRealm.class);

    @Reference
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        logger.info("用户授权");
        System.out.println(userService);
        String username = (String)principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        try {
            List<Role> roles = userService.findRoleByUsername(username);
            List<String> roleNames = roles.stream().map(Role::getName).collect(Collectors.toList());
            simpleAuthorizationInfo.addRoles(roleNames);

            List<Permission> permissions = userService.findPermissionByUsername(username);
            List<String> permissionUrls = permissions.stream().map(Permission::getUrl).collect(Collectors.toList());
            simpleAuthorizationInfo.addStringPermissions(permissionUrls);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) {
        logger.info("用户身份验证");
        String username = (String)authenticationToken.getPrincipal();
        User user = null;
        try {
            user = userService.findUserByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (null == user){
            throw new UnknownAccountException("不存在用户名"+username);
        }
        if (user.getStatus() != 1){
            throw new LockedAccountException("该账号已被冻结");
        }
        String password = user.getPassword();
        return new SimpleAuthenticationInfo(username,password,getName());
    }
}
