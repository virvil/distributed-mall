package distributed.mall.product.api;

import distributed.mall.pojo.pojo.SpuSpecName;

/**
 * <b><code>SpuSpecNameService</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/1/25 15:55.
 *
 * @author virvil
 * @since distributed-mall ${PROJECT_VERSION}
 */
public interface SpuSpecNameService {
    int saveSpuSpecName(SpuSpecName spuSpecName) throws Exception;

    int delSpuSpecName(Integer id) throws Exception;

    int delSpuSpecNames(Integer spuId) throws Exception;
}
