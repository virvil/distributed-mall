package distributed.mall.product.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import distributed.mall.pojo.mapper.CategoryMapper;
import distributed.mall.pojo.pojo.Category;
import distributed.mall.product.api.CategoryService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * <b><code>CategoryServiceImpl</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/1/23 9:31.
 *
 * @author virvil
 * @since distributed-mall ${PROJECT_VERSION}
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public Category getCategory(Integer id) throws Exception {
        List<Category> categorys = categoryMapper.getCategory(id);
        if (CollectionUtils.isEmpty(categorys)){
            return null;
        }
        return categorys.get(0);
    }

    @Override
    public List<Category> listCategorys(Integer pid) throws Exception {
        List<Category> categories = categoryMapper.listCategorys(pid);
        return categories;
    }

    @Override
    public int saveCategory(Category category) throws Exception {
        Date date = new Date();
        category.setCreateTime(date);
        category.setUpdateTime(date);
        int result = categoryMapper.saveCategory(category);
        if (result>0 && category.getPid() != null){
            Category parent_category = new Category();
            parent_category.setId(category.getPid());
            parent_category.setIsParent(true);
            categoryMapper.updCategory(parent_category);
        }
        return result;
    }

    @Override
    public int updCategory(Category category) throws Exception {
        category.setUpdateTime(new Date());
        int result = categoryMapper.updCategory(category);
        return result;
    }

    @Override
    public int delCategory(Integer id) throws Exception {
        int result = categoryMapper.delCategory(id);
        return result;
    }

    @Override
    public int delCategorys(Integer pid) throws Exception {
        int result = categoryMapper.delCategorys(pid);
        return result;
    }
}
