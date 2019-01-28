package distributed.mall.common.utils.cookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <b><code>CookieUtil</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2018/10/31 17:18.
 *
 * @author virvil
 * @since dubbomall ${PROJECT_VERSION}
 */
public class CookieUtil {
    public static final String COOKIE_NAME = "COOKIEID";

    private static int DEFAULT_EXPIRE = 60 * 60 * 24 * 30;

    public static void addCookie(HttpServletResponse response, String cookieName, String cookieValue) {

        addCookie(response, cookieName, cookieValue, DEFAULT_EXPIRE);
    }

    public static void addCookie(HttpServletResponse response, String cookieName, String cookieValue, int expire) {

        Cookie cookie = new Cookie(cookieName, cookieValue);
        cookie.setMaxAge(expire);
        cookie.setPath("/");
        response.addCookie(cookie);

    }

    public static String getCookie(HttpServletRequest request, String cookieName) {

        Cookie[] cookies = request.getCookies();
        if (cookies == null){
            return null;
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(cookieName)) {
                return cookie.getValue();
            }
        }
        return null;
    }

    public static void removeCookie(HttpServletResponse response, String cookieName) {
        addCookie(response, cookieName, null, 0);
    }
}
