package distributed.mall.pojo.mapper;

import distributed.mall.pojo.pojo.Sku;

import java.util.List;

/**
 * <b><code>SkuMapper</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/1/25 9:57.
 *
 * @author virvil
 * @since distributed-mall ${PROJECT_VERSION}
 */
public interface SkuMapper {

    List<Sku> getSku(Integer id) throws Exception;

    List<Sku> listSkus(Integer spuId) throws Exception;

    int saveSku(Sku sku) throws Exception;

    int updSku(Sku sku) throws Exception;

    int delSku(Integer id)throws Exception;

    int delSkus(Integer spuId)throws Exception;
}
