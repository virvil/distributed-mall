package distributed.mall.common.utils.enDecrypt;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * <b><code>EnDecryptUtil</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2018/10/27 21:37.
 *
 * @author xxx
 * @since dubbomall ${PROJECT_VERSION}
 */
public class EnDecryptUtil {
    private final static Logger logger = LoggerFactory.getLogger(EnDecryptUtil.class);
    private static final String CHARSET_NAME = "utf-8";
    private static final String KEY_ALGORITHM = "AES";
    private static final String DEFAULT_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";//默认的加密算法

    //在这里使用AES-128-ECB的加密模式，key需要为16位。
    private static final String KEY = "asdfghjklqwertyu";

    public static String encodeMD5(String data) {
        return DigestUtils.md5Hex(data);
    }

    public static String encodeAES(String data) {
        try {
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
            //使用密钥初始化，设置为加密密模式
            cipher.init(Cipher.ENCRYPT_MODE, getSecretKey(KEY));
            byte[] dataBytes = data.getBytes("utf-8");
            //执行加密操作
            byte[] result = cipher.doFinal(dataBytes);
            //通过Base64转码返回
            return Base64.encodeBase64String(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String decryptAES(String data) {
        try {
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
            //使用密钥初始化，设置为解密模式
            cipher.init(Cipher.DECRYPT_MODE, getSecretKey(KEY));
            //执行加密操作
            byte[] result = cipher.doFinal(Base64.decodeBase64(data));
            //通过Base64转码返回
            return new String(result, CHARSET_NAME);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static SecretKeySpec getSecretKey(String password) {

        try {
            //密钥生成器对象
            KeyGenerator keyGenerator = KeyGenerator.getInstance(KEY_ALGORITHM);
            keyGenerator.init(128, new SecureRandom(password.getBytes()));
            SecretKey secretKey = keyGenerator.generateKey();
            // 转换为AES专用密
            return new SecretKeySpec(secretKey.getEncoded(), "AES");
        } catch (NoSuchAlgorithmException e) {
            logger.error(e.getMessage(), e);
        }
        //AES 要求密钥长度为 128

        return null;
    }

    public static void main(String[] args) {
        String encode = EnDecryptUtil.encodeAES("test");
        System.out.println(encode);
        String decrypt = EnDecryptUtil.decryptAES(encode);
        System.out.println(decrypt);
    }
}
