package distributed.mall.common.utils.pojo;

/**
 * <b><code>ResponseCode</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2018/10/24 22:09.
 *
 * @author virvil
 * @since dubbomall ${PROJECT_VERSION}
 */

public enum ResponseCode {

    SUCCESS(200, "success"),
    ERROR(401, "error");

    private final int code;
    private final String desc;

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    ResponseCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }


}
