package distributed.mall.pojo.mapper;

import distributed.mall.pojo.pojo.SpuSpecName;

/**
 * <b><code>SpuSpecNameMapper</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/1/25 9:30.
 *
 * @author virvil
 * @since distributed-mall ${PROJECT_VERSION}
 */
public interface SpuSpecNameMapper {
    int saveSpuSpecName(SpuSpecName spuSpecName) throws Exception;

    int delSpuSpecName(Integer id) throws Exception;

    int delSpuSpecNames(Integer spuId) throws Exception;
}
