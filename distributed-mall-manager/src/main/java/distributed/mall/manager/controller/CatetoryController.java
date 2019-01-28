package distributed.mall.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import distributed.mall.common.utils.pojo.Node;
import distributed.mall.common.utils.pojo.ResponseResult;
import distributed.mall.pojo.pojo.Category;
import distributed.mall.product.api.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <b><code>CatetoryController</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/1/23 11:05.
 *
 * @author virvil
 * @since distributed-mall ${PROJECT_VERSION}
 */
@Api("category分类管理")
@RestController
@RequestMapping("category")
public class CatetoryController {

    @Reference
    private CategoryService categoryService;

    @ApiOperation(value = "根据获取分类信息")
    @GetMapping("get")
    public ResponseResult getCategory(Integer id) throws Exception{
        Category category = categoryService.getCategory(id);
        return ResponseResult.success(category);
    }

    @ApiOperation(value = "根据获取pid获取下级信息")
    @GetMapping("list")
    public ResponseResult listCategorys(Integer pid) throws Exception{
        List<Category> categories = categoryService.listCategorys(pid);
        return ResponseResult.success(categories);
    }

    @ApiOperation(value = "根据id构建节点树")
    @GetMapping("bulid")
    public ResponseResult build(Integer id)throws Exception{

        Node root = new Node();
        build(root, id);
        return ResponseResult.success(root);
    }

    private void build(Node node,Integer id)throws Exception{

        Category category = categoryService.getCategory(id);
        node.setData(category);
        List<Category> categories = categoryService.listCategorys(id);
        if (CollectionUtils.isEmpty(categories)) {
            return;
        }
        List<Node> children = new ArrayList<>();
        for (Category category1 : categories){
            Node node1 = new Node();
            node1.setData(category1);
            build(node1,category1.getId());
            children.add(node1);
        }
        node.setChildren(children);
    }

    @ApiOperation(value = "添加分类")
    @PostMapping("save")
    public ResponseResult saveCategory(Category category) throws Exception{
        int result = categoryService.saveCategory(category);
        return ResponseResult.success(result);
    }

    @ApiOperation(value = "修改分类")
    @PutMapping("upd")
    public ResponseResult updCategory(Category category) throws Exception{
        int result = categoryService.updCategory(category);
        return ResponseResult.success(result);
    }

    @ApiOperation(value = "删除该id分类")
    @DeleteMapping("del")
    public ResponseResult updCategory(Integer id) throws Exception{
        int result = categoryService.delCategory(id);
        return ResponseResult.success(result);
    }

    @ApiOperation(value = "删除该pid及子分类")
    @DeleteMapping("dels")
    public ResponseResult delCategorys(Integer pid) throws Exception{
        int result1 = categoryService.delCategory(pid);
        int result2 = categoryService.delCategorys(pid);
        return ResponseResult.success(result1+result2);
    }
}
