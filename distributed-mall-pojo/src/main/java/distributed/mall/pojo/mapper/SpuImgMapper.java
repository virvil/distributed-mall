package distributed.mall.pojo.mapper;

import distributed.mall.pojo.pojo.SpuImg;

import java.util.List;

/**
 * <b><code>SpuImg</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/1/25 10:39.
 *
 * @author virvil
 * @since distributed-mall ${PROJECT_VERSION}
 */
public interface SpuImgMapper {
    List<SpuImg> getSpuImg(Integer id) throws Exception;

    List<SpuImg> listSpuImgs(Integer spuId) throws Exception;

    int saveSpuImg(SpuImg spuImg) throws Exception;

    int updSpuImg(SpuImg spuImg) throws Exception;

    int delSpuImg(Integer id) throws Exception;

    int delSpuImgs(Integer spuId) throws Exception;
}
