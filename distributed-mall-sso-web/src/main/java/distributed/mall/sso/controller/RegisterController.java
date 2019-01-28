package distributed.mall.sso.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import distributed.mall.common.utils.Redis.ConstantRedisConfig;
import distributed.mall.common.utils.Redis.RedisUtil;
import distributed.mall.common.utils.cookie.CookieUtil;
import distributed.mall.common.utils.pojo.ResponseResult;
import distributed.mall.pojo.pojo.User;
import distributed.mall.user.api.RegisterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <b><code>RegisterController</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/1/16 20:54.
 *
 * @author virvil
 * @since distributed-mall ${PROJECT_VERSION}
 */
@Api("用户注册类")
@RestController
public class RegisterController {

    @Reference
    private RegisterService registerService;

    @ApiOperation("跳转到用户注册接界面接口")
    @RequestMapping(value = "register", method = RequestMethod.GET)
    public ModelAndView register(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String token = CookieUtil.getCookie(request, CookieUtil.COOKIE_NAME);
        String value = RedisUtil.get(ConstantRedisConfig.TOKEN_PREFIX + token);
        ModelAndView modelAndView = new ModelAndView();
        if (StringUtils.isBlank(value)) {
            modelAndView.setViewName("register");
            return modelAndView;
        }
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @ApiOperation("执行用户注册接口")
    @RequestMapping(value = "doRegister", method = RequestMethod.POST)
    public ResponseResult doRegister(User user) throws Exception {
        ResponseResult responseResult = registerService.doRegister(user);
        return responseResult;
    }
}
