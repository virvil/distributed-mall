package distributed.mall.pojo.mapper;

import distributed.mall.pojo.pojo.Cart;

import java.util.List;

/**
 * <b><code>CartMapper</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/1/25 14:46.
 *
 * @author virvil
 * @since distributed-mall ${PROJECT_VERSION}
 */
public interface CartMapper {
    List<Cart> getCart(Integer id) throws Exception;

    List<Cart> getCarts(Integer userId) throws Exception;

    int saveCart(Cart cart)throws Exception;

    int updCart(Cart cart) throws Exception;

    int delCart(Cart cart)throws Exception;
}
