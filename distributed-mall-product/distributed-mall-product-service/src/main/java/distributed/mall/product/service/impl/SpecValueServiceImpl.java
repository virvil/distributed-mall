package distributed.mall.product.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import distributed.mall.pojo.mapper.SpecValueMapper;
import distributed.mall.pojo.pojo.SpecValue;
import distributed.mall.product.api.SpecValueService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <b><code>SpecValueServiceImpl</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/1/25 15:29.
 *
 * @author virvil
 * @since distributed-mall ${PROJECT_VERSION}
 */
@Service
public class SpecValueServiceImpl implements SpecValueService {
    @Autowired
    private SpecValueMapper specValueMapper;

    @Override
    public SpecValue getSpecValue(Integer id) throws Exception {
        List<SpecValue> specValues = specValueMapper.getSpecValue(id);
        if (CollectionUtils.isEmpty(specValues)){
            return null;
        }
        return specValues.get(0);
    }

    @Override
    public List<SpecValue> listSpecValues(Integer specNameId) throws Exception {
        List<SpecValue> specValues = specValueMapper.listSpecValues(specNameId);
        return specValues;
    }

    @Override
    public int saveSpecValue(SpecValue specValue) throws Exception {
        int result = specValueMapper.saveSpecValue(specValue);
        return result;
    }

    @Override
    public int updSpecValue(SpecValue specValue) throws Exception {
        int result = specValueMapper.updSpecValue(specValue);
        return result;
    }

    @Override
    public int delSpecValue(Integer id) throws Exception {
        int result = specValueMapper.delSpecValue(id);
        return result;
    }

    @Override
    public int delSpecValues(Integer specNameId) throws Exception {
        int result = specValueMapper.delSpecValues(specNameId);
        return result;
    }
}
