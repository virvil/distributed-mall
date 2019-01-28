package distributed.mall.pojo.mapper;

import distributed.mall.pojo.pojo.Category;
import distributed.mall.pojo.pojo.CategoryBrand;

/**
 * <b><code>CategoryBrandMapper</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/1/24 10:30.
 *
 * @author virvil
 * @since distributed-mall ${PROJECT_VERSION}
 */
public interface CategoryBrandMapper {

    int saveCategotyBrand(CategoryBrand categoryBrand) throws Exception;

    int delCategotyBrand(Integer id) throws Exception;

    int delCategotyBrands(Integer categoryId) throws Exception;
}
