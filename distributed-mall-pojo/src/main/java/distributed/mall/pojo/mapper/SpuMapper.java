package distributed.mall.pojo.mapper;

import distributed.mall.pojo.pojo.Spu;

import java.util.List;

/**
 * <b><code>SpuMapper</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/1/25 9:32.
 *
 * @author virvil
 * @since distributed-mall ${PROJECT_VERSION}
 */
public interface SpuMapper {

    List<Spu> getSpu(Integer id) throws Exception;

    List<Spu> listSpuByCategoryId(Integer categoryId) throws Exception;

    List<Spu> listSpuByBrandId(Integer brandId) throws Exception;

    int saveSpu(Spu spu)throws Exception;

    int updSpu(Spu spu)throws Exception;

    int delSpu(Integer id) throws Exception;
}
