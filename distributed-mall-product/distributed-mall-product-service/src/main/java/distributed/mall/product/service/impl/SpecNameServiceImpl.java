package distributed.mall.product.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import distributed.mall.pojo.mapper.SpecNameMapper;
import distributed.mall.pojo.pojo.SpecName;
import distributed.mall.product.api.SpecNameService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <b><code>SpecNameServiceImpl</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/1/25 15:22.
 *
 * @author virvil
 * @since distributed-mall ${PROJECT_VERSION}
 */
@Service
public class SpecNameServiceImpl implements SpecNameService {
    @Autowired
    private SpecNameMapper specNameMapper;

    @Override
    public SpecName getSpecName(Integer id) throws Exception {
        List<SpecName> specNames = specNameMapper.getSpecName(id);
        if (CollectionUtils.isEmpty(specNames)){
            return null;
        }
        return specNames.get(0);
    }

    @Override
    public List<SpecName> listSpecNamesByCategoryId(Integer categoryId) throws Exception {
        List<SpecName> specNames = specNameMapper.listSpecNamesByCategoryId(categoryId);
        return specNames;
    }

    @Override
    public List<SpecName> listSpecNamesBySpuId(Integer spuId) throws Exception {
        List<SpecName> specNames = specNameMapper.listSpecNamesBySpuId(spuId);
        return specNames;
    }

    @Override
    public int saveSpecName(SpecName specName) throws Exception {
        int result = specNameMapper.saveSpecName(specName);
        return result;
    }

    @Override
    public int updSpecName(SpecName specName) throws Exception {
        int result = specNameMapper.updSpecName(specName);
        return result;
    }

    @Override
    public int delSpecName(Integer id) throws Exception {
        int result = specNameMapper.delSpecName(id);
        return result;
    }

    @Override
    public int delSpecNames(Integer categoryId) throws Exception {
        int result = specNameMapper.delSpecNames(categoryId);
        return result;
    }
}
