package distributed.mall.product.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import distributed.mall.pojo.mapper.CategoryBrandMapper;
import distributed.mall.pojo.pojo.CategoryBrand;
import distributed.mall.product.api.CategoryBrandService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <b><code>CategoryBrandServiceImpl</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/1/25 15:19.
 *
 * @author virvil
 * @since distributed-mall ${PROJECT_VERSION}
 */

@Service
public class CategoryBrandServiceImpl implements CategoryBrandService {
    @Autowired
    private CategoryBrandMapper categoryBrandMapper;

    @Override
    public int saveCategotyBrand(CategoryBrand categoryBrand) throws Exception {
        int result = categoryBrandMapper.saveCategotyBrand(categoryBrand);
        return result;
    }

    @Override
    public int delCategotyBrand(Integer id) throws Exception {
        int result = categoryBrandMapper.delCategotyBrand(id);
        return result;
    }

    @Override
    public int delCategotyBrands(Integer categoryId) throws Exception {
        int result = categoryBrandMapper.delCategotyBrands(categoryId);
        return result;
    }
}
