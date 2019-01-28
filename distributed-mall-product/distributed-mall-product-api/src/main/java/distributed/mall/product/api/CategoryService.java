package distributed.mall.product.api;

import distributed.mall.pojo.pojo.Category;

import java.util.List;

/**
 * <b><code>CategoryService</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/1/23 9:31.
 *分类
 * @author virvil
 * @since distributed-mall ${PROJECT_VERSION}
 */
public interface CategoryService {

    Category getCategory(Integer id)throws Exception;

    List<Category> listCategorys(Integer pid)throws Exception;

    int saveCategory(Category category) throws Exception;

    int updCategory(Category category) throws Exception;

    int delCategory(Integer id) throws Exception;

    int delCategorys(Integer pid) throws Exception;
}
