package distributed.mall.pojo.mapper;

import distributed.mall.pojo.pojo.Brand;

import java.util.List;

/**
 * <b><code>Brand</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/1/24 10:07.
 *
 * @author virvil
 * @since distributed-mall ${PROJECT_VERSION}
 */
public interface BrandMapper {

    List<Brand> getBrand(Integer id) throws Exception;

    List<Brand> listBrands(Integer categoryId) throws Exception;

    int saveBrand(Brand brand) throws Exception;

    int updBrand(Brand brand) throws Exception;

    int delBrand(Integer id)throws Exception;

}
