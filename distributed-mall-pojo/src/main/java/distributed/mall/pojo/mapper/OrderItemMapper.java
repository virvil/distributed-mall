package distributed.mall.pojo.mapper;

import distributed.mall.pojo.pojo.OrderItem;

import java.util.List;

/**
 * <b><code>OrderItemMapper</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/1/25 11:22.
 *
 * @author virvil
 * @since distributed-mall ${PROJECT_VERSION}
 */
public interface OrderItemMapper {

    List<OrderItem> getOrderItem(Integer id) throws Exception;

    List<OrderItem> listOrderItems(String orderInfoId) throws Exception;

    int saveOrderItem(OrderItem orderItem)throws Exception;

    int updOrderItem(OrderItem orderItem)throws Exception;

    int delOrderItem(Integer id)throws Exception;

    int delOrderItems(String orderInfoId)throws Exception;
}
