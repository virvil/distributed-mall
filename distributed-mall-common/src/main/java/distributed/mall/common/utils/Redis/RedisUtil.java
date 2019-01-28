package distributed.mall.common.utils.Redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;

/**
 * <b><code>RedisUtil</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2018/10/26 16:51.
 *
 * @author virvil
 * @since dubbomall ${PROJECT_VERSION}
 */
public class RedisUtil {

    static JedisPool jedisPool = null;

    static {
        init();
    }

    private static void init() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(ConstantRedisConfig.MAXIDLE);
        jedisPoolConfig.setMaxTotal(ConstantRedisConfig.MAXTOTAL);
        jedisPoolConfig.setMaxWaitMillis(ConstantRedisConfig.MAXWAITMILLIS);
        jedisPoolConfig.setTestOnBorrow(ConstantRedisConfig.TESTONBORROW);
        jedisPool = new JedisPool(jedisPoolConfig, ConstantRedisConfig.ADDRESS, ConstantRedisConfig.PORT);
    }


    public static String set(String key, String value) {
        Jedis resource = jedisPool.getResource();
        return resource.set(key, value);
    }


    public static String get(String key) {
        Jedis resource = jedisPool.getResource();
        return resource.get(key);
    }


    public static Boolean exists(String key) {
        Jedis resource = jedisPool.getResource();
        return resource.exists(key);
    }


    public static Long expire(String key, int seconds) {
        Jedis resource = jedisPool.getResource();
        return resource.expire(key, seconds);
    }


    public static Long ttl(String key) {
        Jedis resource = jedisPool.getResource();
        return resource.ttl(key);
    }


    public static Long incr(String key) {
        Jedis resource = jedisPool.getResource();
        return resource.incr(key);
    }


    public static Long hset(String key, String field, String value) {
        Jedis resource = jedisPool.getResource();
        return resource.hset(key, field, value);
    }


    public static String hget(String key, String field) {
        Jedis resource = jedisPool.getResource();
        return resource.hget(key, field);
    }


    public static Long hdel(String key, String... field) {
        Jedis resource = jedisPool.getResource();
        return resource.hdel(key, field);
    }


    public static Boolean hexists(String key, String field) {
        Jedis resource = jedisPool.getResource();
        return resource.hexists(key, field);
    }


    public static List<String> hvals(String key) {
        Jedis resource = jedisPool.getResource();
        return resource.hvals(key);
    }


    public static Long del(String key) {
        Jedis resource = jedisPool.getResource();
        return resource.del(key);
    }

    public static void main(String[] args) {
        RedisUtil.set("name", "1");
    }
}
