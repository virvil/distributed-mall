package distributed.mall.sso.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import distributed.mall.common.utils.DefaultIdGenerator;
import distributed.mall.common.utils.Redis.ConstantRedisConfig;
import distributed.mall.common.utils.Redis.RedisUtil;
import distributed.mall.common.utils.cookie.CookieUtil;
import distributed.mall.common.utils.json.JsonUtil;
import distributed.mall.common.utils.pojo.ResponseResult;
import distributed.mall.pojo.pojo.User;
import distributed.mall.user.api.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <b><code>LoginController</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/1/14 10:17.
 *
 * @author zyg
 * @since distributed-mall ${PROJECT_VERSION}
 */
@Api("用户登录类")
@Controller
public class LoginController {

    @Reference
    private LoginService loginService;

    @ApiOperation(value = "跳转到登录页面接口")
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String token = CookieUtil.getCookie(request, CookieUtil.COOKIE_NAME);
        String value = RedisUtil.get(ConstantRedisConfig.TOKEN_PREFIX + token);
        if (StringUtils.isBlank(value)) {
            return "login";
        }
        return "index";
    }

    @ApiOperation(value = "执行登录接口")
    @RequestMapping(value = "dologin", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult doLogin(HttpServletResponse response, String username, String password) throws Exception {
        ResponseResult responseResult = loginService.doLogin(username, password);
        if (responseResult.isSuccess()) {
            User user = (User) responseResult.getData();
            String token = DefaultIdGenerator.createId();
            CookieUtil.addCookie(response, CookieUtil.COOKIE_NAME, token);
            RedisUtil.set(ConstantRedisConfig.TOKEN_PREFIX + token, JsonUtil.getJsonString(user));
            RedisUtil.expire(ConstantRedisConfig.TOKEN_PREFIX + token, ConstantRedisConfig.TOKEN_EXPIRE);
        }
        return responseResult;
    }

    @ApiOperation(value = "根据token获取用户接口")
    @RequestMapping(value = "getUser", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult getUserByToken(String token) throws Exception {
        return loginService.getUserByToke(token);
    }

    @ApiOperation(value = "用户登出接口")
    @RequestMapping(value = "logout", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult logoutByToken(String token) throws Exception {
        return loginService.logoutByToken(token);
    }
}
