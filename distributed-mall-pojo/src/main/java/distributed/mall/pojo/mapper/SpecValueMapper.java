package distributed.mall.pojo.mapper;

import distributed.mall.pojo.pojo.SpecValue;

import java.util.List;

/**
 * <b><code>SpecValueMapper</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/1/24 11:12.
 *
 * @author virvil
 * @since distributed-mall ${PROJECT_VERSION}
 */
public interface SpecValueMapper {
    List<SpecValue> getSpecValue(Integer id) throws Exception;

    List<SpecValue> listSpecValues(Integer specNameId) throws Exception;

    int saveSpecValue(SpecValue specValue) throws Exception;

    int updSpecValue(SpecValue specValue)throws Exception;

    int delSpecValue(Integer id) throws Exception;

    int delSpecValues(Integer specNameId) throws Exception;
}
