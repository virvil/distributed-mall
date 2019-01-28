package distributed.mall.pojo.mapper;

import distributed.mall.pojo.pojo.SpecName;

import java.util.List;

/**
 * <b><code>SpecNameMapper</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/1/24 10:55.
 *
 * @author virvil
 * @since distributed-mall ${PROJECT_VERSION}
 */
public interface SpecNameMapper {

    List<SpecName> getSpecName(Integer id) throws Exception;

    List<SpecName> listSpecNamesByCategoryId(Integer categoryId) throws Exception;

    List<SpecName> listSpecNamesBySpuId(Integer spuId) throws Exception;

    int saveSpecName(SpecName specName) throws Exception;

    int updSpecName(SpecName specName) throws Exception;

    int delSpecName(Integer id) throws Exception;

    int delSpecNames(Integer categoryId) throws Exception;
}
