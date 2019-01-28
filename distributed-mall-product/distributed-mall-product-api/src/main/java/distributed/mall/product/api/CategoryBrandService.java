package distributed.mall.product.api;

import distributed.mall.pojo.pojo.CategoryBrand;

/**
 * <b><code>CategoryBrandService</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/1/25 15:18.
 *
 * @author xxx
 * @since distributed-mall ${PROJECT_VERSION}
 */
public interface CategoryBrandService {

    int saveCategotyBrand(CategoryBrand categoryBrand) throws Exception;

    int delCategotyBrand(Integer id) throws Exception;

    int delCategotyBrands(Integer categoryId) throws Exception;
}
