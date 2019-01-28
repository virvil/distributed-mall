package distributed.mall.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import distributed.mall.common.utils.pojo.ResponseResult;
import distributed.mall.pojo.pojo.SpuSpecName;
import distributed.mall.product.api.SpuSpecNameService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * <b><code>SpuSpecNameController</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/1/27 16:03.
 *
 * @author virvil
 * @since distributed-mall ${PROJECT_VERSION}
 */
@Api("spu 与 规格名称绑定类")
@RestController
@RequestMapping("spuSpecName")
public class SpuSpecNameController {

    @Reference
    private SpuSpecNameService spuSpecNameService;

    @ApiOperation("添加商品规格名称")
    @PostMapping("save")
    public ResponseResult saveSpuSpecName(@RequestBody SpuSpecName spuSpecName) throws Exception{
        int result = spuSpecNameService.saveSpuSpecName(spuSpecName);
        return ResponseResult.success(result);
    }

    @ApiOperation("根据id删除商品规格名称")
    @DeleteMapping("del")
    public ResponseResult delSpuSpecName(Integer id) throws Exception{
        int result = spuSpecNameService.delSpuSpecName(id);
        return ResponseResult.success(result);
    }

    @ApiOperation("根据spuId删除商品规格名称")
    @DeleteMapping("delBySpuId")
    public ResponseResult delSpuSpecNames(Integer spuId) throws Exception{
        int result = spuSpecNameService.delSpuSpecNames(spuId);
        return ResponseResult.success(result);
    }
}
