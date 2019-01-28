package distributed.mall.user.api;

import distributed.mall.common.utils.pojo.ResponseResult;
import distributed.mall.pojo.pojo.User;

/**
 * <b><code>RegisterService</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/1/16 20:09.
 *
 * @author virvil
 * @since distributed-mall ${PROJECT_VERSION}
 */
public interface RegisterService {

    ResponseResult doRegister(User user) throws Exception;
}
