package distributed.mall.product.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import distributed.mall.pojo.mapper.SpuSpecNameMapper;
import distributed.mall.pojo.pojo.SpuSpecName;
import distributed.mall.product.api.SpuSpecNameService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <b><code>SpuSpecNameServiceImpl</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/1/25 15:56.
 *
 * @author virvil
 * @since distributed-mall ${PROJECT_VERSION}
 */
@Service
public class SpuSpecNameServiceImpl implements SpuSpecNameService {
    @Autowired
    private SpuSpecNameMapper spuSpecNameMapper;

    @Override
    public int saveSpuSpecName(SpuSpecName spuSpecName) throws Exception {
        int result = spuSpecNameMapper.saveSpuSpecName(spuSpecName);
        return result;
    }

    @Override
    public int delSpuSpecName(Integer id) throws Exception {
        int result = spuSpecNameMapper.delSpuSpecName(id);
        return result;
    }

    @Override
    public int delSpuSpecNames(Integer spuId) throws Exception {
        int result = spuSpecNameMapper.delSpuSpecNames(spuId);
        return result;
    }
}
