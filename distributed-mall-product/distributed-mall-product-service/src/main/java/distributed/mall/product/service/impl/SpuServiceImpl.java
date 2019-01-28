package distributed.mall.product.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import distributed.mall.pojo.mapper.SpuMapper;
import distributed.mall.pojo.pojo.Spu;
import distributed.mall.product.api.SpuService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * <b><code>SpuServiceImpl</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/1/25 15:37.
 *
 * @author virvil
 * @since distributed-mall ${PROJECT_VERSION}
 */
@Service
public class SpuServiceImpl implements SpuService {
    @Autowired
    private SpuMapper spuMapper;

    @Override
    public Spu getSpu(Integer id) throws Exception {
        List<Spu> spus = spuMapper.getSpu(id);
        if (CollectionUtils.isEmpty(spus)) {
            return null;
        }
        return spus.get(0);
    }

    @Override
    public List<Spu> listSpuByCategoryId(Integer categoryId) throws Exception {
        List<Spu> spus = spuMapper.listSpuByCategoryId(categoryId);
        return spus;
    }

    @Override
    public List<Spu> listSpuByBrandId(Integer brandId) throws Exception {
        List<Spu> spus = spuMapper.listSpuByBrandId(brandId);
        return spus;
    }

    @Override
    public int saveSpu(Spu spu) throws Exception {
        Date date = new Date();
        spu.setCreateTime(date);
        spu.setUpdateTime(date);
        int result = spuMapper.saveSpu(spu);
        return result;
    }

    @Override
    public int updSpu(Spu spu) throws Exception {
        int result = spuMapper.updSpu(spu);
        return result;
    }

    @Override
    public int delSpu(Integer id) throws Exception {
        int result = spuMapper.delSpu(id);
        return result;
    }
}
