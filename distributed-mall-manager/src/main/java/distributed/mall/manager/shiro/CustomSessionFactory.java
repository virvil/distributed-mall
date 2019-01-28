package distributed.mall.manager.shiro;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SessionContext;
import org.apache.shiro.session.mgt.SessionFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * <b><code>CustomSessionFactory</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/1/10 13:35.
 *
 * @author xxx
 * @since shiro-redis-sso ${PROJECT_VERSION}
 */
public class CustomSessionFactory implements SessionFactory {
    @Override
    public Session createSession(SessionContext sessionContext) {
        CustomSession session = new CustomSession();

        return null;
    }
    public static String getIpAddress(HttpServletRequest request) {
        String localIP = "127.0.0.1";
        String ip = request.getHeader("x-forwarded-for");
        if (StringUtils.isBlank(ip) || (ip.equalsIgnoreCase(localIP)) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isBlank(ip) || (ip.equalsIgnoreCase(localIP)) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isBlank(ip) || (ip.equalsIgnoreCase(localIP)) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

}
