package distributed.mall.manager.shiro;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.SessionListener;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <b><code>ShiroConfig</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/1/10 15:09.
 *
 * @author zyg
 * @since shiro-redis-sso ${PROJECT_VERSION}
 */
//@Configuration
public class ShiroConfig {

    //将自己的验证方式加入容器
    @Bean
    public CustomRealm customRealm(){
        return new CustomRealm();
    }

    //权限管理，配置主要是Realm的管理认证
    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(customRealm());
        return securityManager;
    }

    //Filter工厂，设置对应的过滤条件和跳转条件
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){
        System.out.println("初始化filter");
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        Map<String,String> map = new HashMap<String, String>();
        //登出
//        map.put("/logout","logout");
//        //对所有用户认证
//        map.put("/**","authc");
        map.put("/**","anon");
        //登录
        shiroFilterFactoryBean.setLoginUrl("/login");
        //首页
        shiroFilterFactoryBean.setSuccessUrl("/index");
        //错误页面，认证不通过跳转
        shiroFilterFactoryBean.setUnauthorizedUrl("/error");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }

    //加入注解的使用，不加入这个注解不生效
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    public CustomSessionRedisDao customSessionRedisDao(){
        CustomSessionRedisDao customSessionRedisDao = new CustomSessionRedisDao();
        return customSessionRedisDao;
    }

    public CustomSessionFactory customSessionFactory(){
        CustomSessionFactory customSessionFactory = new CustomSessionFactory();
        return customSessionFactory;
    }

    @Bean
    public SessionManager sessionManager(){
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setGlobalSessionTimeout(30*60*60);
        //是否在会话过期后会调用SessionDAO的delete方法删除会话 默认true
        sessionManager.setDeleteInvalidSessions(false);
        sessionManager.setSessionFactory(customSessionFactory());
        sessionManager.setSessionDAO(customSessionRedisDao());
        sessionManager.setSessionIdCookie(simpleCookie());
        List<SessionListener> listeners = new ArrayList<>();
        listeners.add(new CustomSessionListener());
        sessionManager.setSessionListeners(listeners);
        return sessionManager;
    }

    public SimpleCookie simpleCookie() {
        SimpleCookie simpleCookie = new SimpleCookie();
        simpleCookie.setName("SHRIOSESSIONID");
        simpleCookie.setPath("/");
        return simpleCookie;
    }
}
