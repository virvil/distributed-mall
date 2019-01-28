package distributed.mall.common.utils.pojo;

import java.io.Serializable;

/**
 * <b><code>ResponseResult</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2018/10/24 22:14.
 *
 * @author virvil
 * @since dubbomall ${PROJECT_VERSION}
 */

public class ResponseResult<T> implements Serializable {

    private int status;
    private String message;
    private T data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    private ResponseResult() {
        this.status = status;
    }

    private ResponseResult(int status) {
        this.status = status;
    }

    private ResponseResult(int status, String message) {
        this(status);
        this.message = message;
    }

    private ResponseResult(int status, T data) {
        this(status);
        this.data = data;
    }

    private ResponseResult(int status, String message, T data) {
        this(status, message);
        this.data = data;
    }

    public boolean isSuccess() {
        return this.status == ResponseCode.SUCCESS.getCode();
    }


    public static <T> ResponseResult<T> success() {
        return new ResponseResult<>(ResponseCode.SUCCESS.getCode());
    }

    public static <T> ResponseResult<T> success(String message) {
        return new ResponseResult<>(ResponseCode.SUCCESS.getCode(), message);
    }

    public static <T> ResponseResult<T> success(T data) {
        return new ResponseResult<>(ResponseCode.SUCCESS.getCode(), data);
    }

    public static <T> ResponseResult<T> success(String message, T data) {
        return new ResponseResult<>(ResponseCode.SUCCESS.getCode(), message, data);
    }

    public static <T> ResponseResult<T> error() {
        return new ResponseResult<>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getDesc());
    }

    public static <T> ResponseResult<T> error(String message) {
        return new ResponseResult<>(ResponseCode.ERROR.getCode(), message);
    }

    public static <T> ResponseResult<T> error(int code, String message) {
        return new ResponseResult<>(code, message);
    }
}
