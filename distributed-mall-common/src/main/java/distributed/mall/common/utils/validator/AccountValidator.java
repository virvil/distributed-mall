package distributed.mall.common.utils.validator;

import java.util.regex.Pattern;

/**
 * <b><code>AccountValidator</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2018/10/28 11:03.
 *
 * @author xxx
 * @since dubbomall ${PROJECT_VERSION}
 */
public class AccountValidator {
    public static final String REGEX_USERNAME = "^^[a-zA-Z]\\w{5,20}$";

    /*
    分开来注释一下：
    ^ 匹配一行的开头位置
    (?![0-9]+$) 预测该位置后面不全是数字
    (?![a-zA-Z]+$) 预测该位置后面不全是字母
    [0-9A-Za-z] {8,16} 由8-16位数字或这字母组成
    $ 匹配行结尾位置
    */
    public static final String REGEX_PASSWORD = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z_]{8,16}$";

    public static final String REGEX_EMAIL = "^(\\w)+(\\.\\w+)*@(\\w)+((\\.\\w{2,3}){1,3})$";

    public static final String REGEX_PHONE = "^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\\d{8}$";

    public static boolean isUsername(String username) {
        return Pattern.matches(REGEX_USERNAME, username);
    }

    public static boolean isPassword(String password) {
        return Pattern.matches(REGEX_PASSWORD, password);
    }

    public static boolean isEmail(String email) {
        return Pattern.matches(REGEX_EMAIL, email);
    }

    public static final boolean isPhone(String phone) {
        return Pattern.matches(REGEX_PHONE, phone);
    }

    public static void main(String[] args) {
        System.out.println(isPassword("aaaaaaxcdc"));
//        System.out.println("===============username================");
//        boolean flag = isUsername("1d54sfW");
//        System.out.println(flag);
//        flag = isUsername("d54sfW");
//        System.out.println(flag);
//        System.out.println("===============email================");
//        flag = isEmail("1372348027@qq.com");
//        System.out.println(flag);
//        flag = isEmail("1313,@qq.com");
//        System.out.println(flag);
//        flag = isEmail("1313,@163.com");
//        System.out.println(flag);
//        flag = isEmail("1313@qq.163.com");
//        System.out.println(flag);
//        System.out.println("===============phone================");
//        flag = isPhone("13751748442");
//        System.out.println(flag);
//        flag = isPhone("13151748442");
//        System.out.println(flag);
//        flag = isPhone("19951748442");
//        System.out.println(flag);
//        flag = isPhone("14551748442");
//        System.out.println(flag);
//        flag = isPhone("16651748442");
//        System.out.println(flag);

    }
}
