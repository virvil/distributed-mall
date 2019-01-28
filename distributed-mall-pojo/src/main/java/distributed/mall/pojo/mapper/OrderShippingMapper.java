package distributed.mall.pojo.mapper;

import distributed.mall.pojo.pojo.OrderShipping;

import java.util.List;

/**
 * <b><code>orderShipping</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/1/25 11:44.
 *
 * @author virvil
 * @since distributed-mall ${PROJECT_VERSION}
 */
public interface OrderShippingMapper {

    List<OrderShipping> getOrderShipping(Integer id)throws Exception;

    List<OrderShipping> getOrderShippingByOrderInfoId(String orderInfoId) throws Exception;

    int saveOrderShipping(OrderShipping orderShipping)throws Exception;

    int updOrderShipping(OrderShipping orderShipping) throws Exception;

    int delOrderShipping(Integer id) throws Exception;

    int delOrderShippingByOrderInfoId(String orderInfoId)throws Exception;
}
