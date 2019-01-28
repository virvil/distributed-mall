package distributed.mall.common.utils.enDecrypt;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * <b><code>Md5Util</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2018/10/27 21:05.
 *
 * @author virvil
 * @since dubbomall ${PROJECT_VERSION}
 */
public class Md5Util {

    public static String encodeMD5(String data) {
        return DigestUtils.md5Hex(data);

    }

    public static void main(String[] args) {
        String data = Md5Util.encodeMD5("data");
        System.out.println(data);
        data = DigestUtils.sha256Hex("data");
        System.out.println(data);
    }
}
