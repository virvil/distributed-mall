package distributed.mall.manager.shiro;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/**
 * <b><code>CustomSerssionRedisDao</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/1/10 13:41.
 *
 * @author zyg
 * @since shiro-redis-sso ${PROJECT_VERSION}
 */
public class CustomSessionRedisDao extends EnterpriseCacheSessionDAO {

    @Value("${sso.redis.session.prefix}")
    private String session_prefix;

    @Value("${sso.redis.session.expire}")
    private int session_expire;

    @Value("${sso.redis.token.prefix}")
    private String token_prefix;

    @Value("${sso.cookie.key}")
    private String cookie_key;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = session.getId();
        redisTemplate.opsForValue().set(session_prefix+sessionId.toString(),session , session_expire, TimeUnit.SECONDS);
        return sessionId;
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        Session session = (Session) redisTemplate.opsForValue().get(session_prefix + sessionId);
        if (null != null){
            redisTemplate.boundValueOps(session_prefix + sessionId.toString()).expire(session_expire,  TimeUnit.SECONDS);
        }
        return session;
    }

    @Override
    protected void doUpdate(Session session) {
        Serializable sessionId = session.getId();
        Session oldSession = (Session) redisTemplate.opsForValue().getAndSet(session_prefix + sessionId.toString(), session);
        if (null != oldSession){
            redisTemplate.boundValueOps(session_prefix + sessionId.toString()).expire(session_expire,  TimeUnit.SECONDS);
        }
    }

    @Override
    protected void doDelete(Session session) {
        Serializable sessionId = session.getId();
        redisTemplate.delete(session_prefix + sessionId.toString());
    }
}
