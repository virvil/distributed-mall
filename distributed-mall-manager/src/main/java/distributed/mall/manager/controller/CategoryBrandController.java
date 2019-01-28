package distributed.mall.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import distributed.mall.common.utils.pojo.ResponseResult;
import distributed.mall.pojo.pojo.CategoryBrand;
import distributed.mall.product.api.CategoryBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * <b><code>CategoryBrandController</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/1/25 17:45.
 *
 * @author virvil
 * @since distributed-mall ${PROJECT_VERSION}
 */
@Api("分类与品牌绑定类")
@RestController
@RequestMapping("category/brand")
public class CategoryBrandController {

    @Reference
    private CategoryBrandService categoryBrandService;

    @ApiOperation("绑定")
    @PostMapping("bind")
    public ResponseResult saveCategotyBrand(@RequestBody CategoryBrand categoryBrand) throws Exception{
        int result = categoryBrandService.saveCategotyBrand(categoryBrand);
        if (result<1){
            return ResponseResult.error("分类与品牌失败");
        }
        return ResponseResult.success("分类与品牌绑定成功");
    }

    @ApiOperation("根据id解除绑定")
    @DeleteMapping("release")
    public ResponseResult delCategotyBrand(Integer id) throws Exception{
        int result = categoryBrandService.delCategotyBrand(id);
        if (result<1){
            return ResponseResult.error("解除绑定失败");
        }
        return ResponseResult.success("解除绑定成功");
    }

    @ApiOperation("根据分类id解除绑定")
    @DeleteMapping("releaseAll")
    public ResponseResult delCategotyBrands(Integer categoryId) throws Exception{
        int result = categoryBrandService.delCategotyBrands(categoryId);
        if (result<1){
            return ResponseResult.error("解除绑定失败");
        }
        return ResponseResult.success("解除绑定成功");
    }
}
