package distributed.mall.manager.shiro;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <b><code>CustomSessionListener</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/1/10 13:44.
 *
 * @author zyg
 * @since shiro-redis-sso ${PROJECT_VERSION}
 */
public class CustomSessionListener implements SessionListener {

    private static final Logger logger = LoggerFactory.getLogger(CustomSessionListener.class);
    @Override
    public void onStart(Session session) {
        logger.info("CustomSessionListener session 被{}被创建",session.getId());
    }

    @Override
    public void onStop(Session session) {
        logger.info("CustomSessionListener session 被{}被销毁",session.getId());
    }

    @Override
    public void onExpiration(Session session) {
        logger.info("CustomSessionListener session 被{}过期",session.getId());
    }
}
