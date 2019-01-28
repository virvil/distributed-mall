package distributed.mall.user.api;

import distributed.mall.common.utils.pojo.ResponseResult;

/**
 * <b><code>LoginService</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/1/14 9:23.
 *
 * @author virvil
 * @since distributed-mall ${PROJECT_VERSION}
 */
public interface LoginService {

    ResponseResult doLogin(String username, String password) throws Exception;

    ResponseResult getUserByToke(String token) throws Exception;

    ResponseResult logoutByToken(String token) throws Exception;
}
