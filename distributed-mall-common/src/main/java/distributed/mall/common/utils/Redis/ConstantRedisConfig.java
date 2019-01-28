package distributed.mall.common.utils.Redis;

/**
 * <b><code>ConstantRedisConfig</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2018/10/26 17:02.
 *
 * @author zyg
 * @since dubbomall ${PROJECT_VERSION}
 */
public interface ConstantRedisConfig {
    String ADDRESS = "192.168.209.128";
    int PORT = 6379;

    //最大空闲
    int MAXIDLE = 200;
    //连接池最大实例数
    int MAXTOTAL = 1024;
    //最大等待时长
    int MAXWAITMILLIS = 10000;
    //testOnBorrow：在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
    boolean TESTONBORROW = true;

    int TOKEN_EXPIRE = 1800;

    String TOKEN_PREFIX = "TOKENID:";

//    String ACTIVE_USER_CODE_PREFIX = "ACTIVE_USER_CODE:";
//
//    int ACTIVE_USER_CODE_EXPIRE = 1800;

}
