package distributed.mall.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import distributed.mall.common.utils.pojo.ResponseResult;
import distributed.mall.pojo.pojo.Spu;
import distributed.mall.product.api.SpuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <b><code>SpuController</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/1/27 14:57.
 *
 * @author virvil
 * @since distributed-mall ${PROJECT_VERSION}
 */
@Api("商品spu管理类")
@RestController
@RequestMapping("spu")
public class SpuController {

    @Reference
    private SpuService spuService;

    @ApiOperation("根据id获取spu")
    @GetMapping("get")
    public ResponseResult getSpu(Integer id) throws Exception{
        Spu spu = spuService.getSpu(id);
        return ResponseResult.success(spu);
    }

    @ApiOperation("根据分类id获取spu")
    @GetMapping("listByCid")
    public ResponseResult listSpuByCategoryId(Integer categoryId) throws Exception{
        List<Spu> spus = spuService.listSpuByCategoryId(categoryId);
        return ResponseResult.success(spus);
    }

    @ApiOperation("根据品牌id获取spu")
    @GetMapping("listByBrandId")
    public ResponseResult listSpuByBrandId(Integer brandId) throws Exception{
        List<Spu> spus = spuService.listSpuByBrandId(brandId);
        return ResponseResult.success(spus);
    }

    @ApiOperation("添加spu")
    @PostMapping("save")
    public ResponseResult saveSpu(@RequestBody Spu spu)throws Exception{
        int result = spuService.saveSpu(spu);
        return ResponseResult.success(result);
    }

    @ApiOperation("修改spu")
    @PutMapping("upd")
    public ResponseResult updSpu(@RequestBody Spu spu)throws Exception{
        int result = spuService.updSpu(spu);
        return ResponseResult.success(result);
    }

    @ApiOperation("删除spu")
    @DeleteMapping("del")
    public ResponseResult delSpu(Integer id) throws Exception{
        int result = spuService.delSpu(id);
        return ResponseResult.success(result);
    }
}
