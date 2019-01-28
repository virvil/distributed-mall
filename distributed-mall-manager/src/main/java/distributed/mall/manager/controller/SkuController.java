package distributed.mall.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import distributed.mall.common.utils.pojo.ResponseResult;
import distributed.mall.pojo.pojo.Sku;
import distributed.mall.product.api.SkuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <b><code>SkuController</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/1/27 16:21.
 *
 * @author virvil
 * @since distributed-mall ${PROJECT_VERSION}
 */
@Api("sku管理类")
@RestController
@RequestMapping("sku")
public class SkuController {

    @Reference
    private SkuService skuService;

    @ApiOperation("根据id获取sku")
    @GetMapping("get")
    public ResponseResult getSku(Integer id) throws Exception{
        Sku sku = skuService.getSku(id);
        return ResponseResult.success(sku);
    }

    @ApiOperation("根据spuId获取sku")
    @GetMapping("list")
    public ResponseResult listSkus(Integer spuId) throws Exception{
        List<Sku> skus = skuService.listSkus(spuId);
        return ResponseResult.success(skus);
    }

    @ApiOperation("添加sku")
    @PostMapping("save")
    public ResponseResult saveSku(@RequestBody Sku sku) throws Exception{
        int result = skuService.saveSku(sku);
        return ResponseResult.success(result);
    }

    @ApiOperation("修改sku")
    @PutMapping("upd")
    public ResponseResult updSku(@RequestBody Sku sku) throws Exception{
        int result = skuService.updSku(sku);
        return ResponseResult.success(result);
    }

    @ApiOperation("根据id删除sku")
    @DeleteMapping("del")
    public ResponseResult delSku(Integer id)throws Exception{
        int result = skuService.delSku(id);
        return ResponseResult.success(id);
    }

    @ApiOperation("根据spuId删除sku")
    @DeleteMapping("delBySpuId")
    public ResponseResult delSkus(Integer spuId)throws Exception{
        int result = skuService.delSkus(spuId);
        return ResponseResult.success(result);
    }
}
