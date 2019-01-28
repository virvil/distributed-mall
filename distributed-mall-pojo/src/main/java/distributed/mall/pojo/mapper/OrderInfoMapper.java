package distributed.mall.pojo.mapper;

import com.sun.org.apache.xpath.internal.operations.Or;
import distributed.mall.pojo.pojo.OrderInfo;

import java.util.List;

/**
 * <b><code>OrderInfoMapper</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/1/25 10:53.
 *
 * @author virvil
 * @since distributed-mall ${PROJECT_VERSION}
 */
public interface OrderInfoMapper {

    List<OrderInfo> getOrderInfo(String id) throws Exception;

    List<OrderInfo> listOrderInfos(Integer userId) throws Exception;

    int saveOrderInfo(OrderInfo orderInfo) throws Exception;

    int updOrderInfo(OrderInfo orderInfo) throws Exception;

    int delOrderInfo(OrderInfo orderInfo) throws Exception;

    int delOrderInfos(Integer userId) throws Exception;
}
