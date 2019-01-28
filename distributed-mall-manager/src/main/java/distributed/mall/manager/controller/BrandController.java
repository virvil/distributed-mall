package distributed.mall.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import distributed.mall.common.utils.pojo.ResponseResult;
import distributed.mall.pojo.pojo.Brand;
import distributed.mall.product.api.BrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <b><code>BrandController</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/1/25 17:07.
 *
 * @author virvil
 * @since distributed-mall ${PROJECT_VERSION}
 */
@Api("品牌管理")
@RestController
@RequestMapping("brand")
public class BrandController {
    @Reference
    private BrandService brandService;

    @ApiOperation("根据id获取品牌")
    @GetMapping("get")
    public ResponseResult getBrand(Integer id)throws Exception{
        Brand brand = brandService.getBrand(id);
        if (brand == null){
            ResponseResult.error("根据id搜索不到品牌");
        }
        return ResponseResult.success(brand);
    }

    @ApiOperation("根据分类id获取品牌列表")
    @GetMapping("list")
    public ResponseResult listBrands(Integer categoryId)throws Exception{
        List<Brand> brands = brandService.listBrands(categoryId);
        if (CollectionUtils.isEmpty(brands)){
            ResponseResult.error("根据分类id搜索不到品牌");
        }
        return ResponseResult.success(brands);
    }

    @ApiOperation("添加品牌")
    @PostMapping("save")
    public ResponseResult saveBrand(@RequestBody Brand brand)throws Exception{
        int result = brandService.saveBrand(brand);
        if (result<1){
            return ResponseResult.error("添加品牌失败");
        }
        return ResponseResult.success("添加品牌成功");
    }

    @ApiOperation("修改品牌信息")
    @PutMapping("upd")
    public ResponseResult updBrand(@RequestBody Brand brand) throws Exception{
        int result = brandService.updBrand(brand);
        if (result<1){
            return ResponseResult.error("更新品牌失败");
        }
        return ResponseResult.success("更新品牌成功");
    }

    @ApiOperation("删除品牌")
    @DeleteMapping("del")
    public ResponseResult delBrand(Integer id) throws Exception{
        int result = brandService.delBrand(id);
        if (result<1){
            return ResponseResult.error("删除品牌失败");
        }
        return ResponseResult.success("删除品牌成功");
    }
}
