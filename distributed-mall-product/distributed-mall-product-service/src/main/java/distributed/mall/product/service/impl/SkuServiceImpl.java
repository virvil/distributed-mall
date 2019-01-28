package distributed.mall.product.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import distributed.mall.pojo.mapper.SkuMapper;
import distributed.mall.pojo.pojo.Sku;
import distributed.mall.product.api.SkuService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <b><code>SkuServiceImpl</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/1/25 15:49.
 *
 * @author virvil
 * @since distributed-mall ${PROJECT_VERSION}
 */
@Service
public class SkuServiceImpl implements SkuService {

    @Autowired
    private SkuMapper skuMapper;

    @Override
    public Sku getSku(Integer id) throws Exception {
        List<Sku> skus = skuMapper.getSku(id);
        if (CollectionUtils.isEmpty(skus)){
            return null;
        }
        return skus.get(0);
    }

    @Override
    public List<Sku> listSkus(Integer spuId) throws Exception {
        List<Sku> skus = skuMapper.listSkus(spuId);
        return skus;
    }

    @Override
    public int saveSku(Sku sku) throws Exception {
        int result = skuMapper.saveSku(sku);
        return result;
    }

    @Override
    public int updSku(Sku sku) throws Exception {
        int result = skuMapper.updSku(sku);
        return result;
    }

    @Override
    public int delSku(Integer id) throws Exception {
        int result = skuMapper.delSku(id);
        return result;
    }

    @Override
    public int delSkus(Integer spuId) throws Exception {
        int result = skuMapper.delSkus(spuId);
        return result;
    }
}
