package distributed.mall.product.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import distributed.mall.pojo.mapper.BrandMapper;
import distributed.mall.pojo.pojo.Brand;
import distributed.mall.product.api.BrandService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * <b><code>BrandServiceImpl</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/1/25 15:12.
 *
 * @author virvil
 * @since distributed-mall ${PROJECT_VERSION}
 */
@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandMapper brandMapper;

    @Override
    public Brand getBrand(Integer id) throws Exception {
        List<Brand> brands = brandMapper.getBrand(id);
        if (CollectionUtils.isEmpty(brands)){
            return null;
        }
        return brands.get(0);
    }

    @Override
    public List<Brand> listBrands(Integer categoryId) throws Exception {
        List<Brand> brands = brandMapper.listBrands(categoryId);
        return brands;
    }

    @Override
    public int saveBrand(Brand brand) throws Exception {
        Date date = new Date();
        brand.setCreateTime(date);
        brand.setUpdateTime(date);
        int result = brandMapper.saveBrand(brand);
        return result;
    }

    @Override
    public int updBrand(Brand brand) throws Exception {
        brand.setUpdateTime(new Date());
        return brandMapper.updBrand(brand);
    }

    @Override
    public int delBrand(Integer id) throws Exception {
        int result = brandMapper.delBrand(id);
        return result;
    }
}
