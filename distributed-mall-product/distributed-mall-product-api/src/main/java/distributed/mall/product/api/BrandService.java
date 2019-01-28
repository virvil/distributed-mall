package distributed.mall.product.api;

import distributed.mall.pojo.pojo.Brand;

import java.util.List;

/**
 * <b><code>BrandService</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/1/25 15:11.
 *
 * @author virvil
 * @since distributed-mall ${PROJECT_VERSION}
 */
public interface BrandService {

    Brand getBrand(Integer id) throws Exception;

    List<Brand> listBrands(Integer categoryId) throws Exception;

    int saveBrand(Brand brand) throws Exception;

    int updBrand(Brand brand) throws Exception;

    int delBrand(Integer id)throws Exception;
}
