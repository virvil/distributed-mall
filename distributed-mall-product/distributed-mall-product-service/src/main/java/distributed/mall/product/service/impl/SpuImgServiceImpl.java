package distributed.mall.product.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import distributed.mall.pojo.mapper.SpuImgMapper;
import distributed.mall.pojo.pojo.SpuImg;
import distributed.mall.product.api.SpuImgService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <b><code>SpuImgServiceImpl</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/1/25 15:44.
 *
 * @author virvil
 * @since distributed-mall ${PROJECT_VERSION}
 */
@Service
public class SpuImgServiceImpl implements SpuImgService {
    @Autowired
    private SpuImgMapper spuImgMapper;

    @Override
    public SpuImg getSpuImg(Integer id) throws Exception {
        List<SpuImg> spuImgs = spuImgMapper.getSpuImg(id);
        if (CollectionUtils.isEmpty(spuImgs)) {
            return null;
        }
        return spuImgs.get(0);
    }

    @Override
    public List<SpuImg> listSpuImgs(Integer spuId) throws Exception {
        List<SpuImg> spuImgs = spuImgMapper.listSpuImgs(spuId);
        return spuImgs;
    }

    @Override
    public int saveSpuImg(SpuImg spuImg) throws Exception {
        int result = spuImgMapper.saveSpuImg(spuImg);
        return result;
    }

    @Override
    public int updSpuImg(SpuImg spuImg) throws Exception {
        int result = spuImgMapper.updSpuImg(spuImg);
        return result;
    }

    @Override
    public int delSpuImg(Integer id) throws Exception {
        int result = spuImgMapper.delSpuImg(id);
        return result;
    }

    @Override
    public int delSpuImgs(Integer spuId) throws Exception {
        int result = spuImgMapper.delSpuImgs(spuId);
        return result;
    }
}
