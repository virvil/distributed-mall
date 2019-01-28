package distributed.mall.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import distributed.mall.common.utils.pojo.ResponseResult;
import distributed.mall.pojo.pojo.SpecName;
import distributed.mall.product.api.SpecNameService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <b><code>SpecNameController</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/1/27 13:54.
 *
 * @author virvil
 * @since distributed-mall ${PROJECT_VERSION}
 */
@Api("规格名称管理类")
@RestController
@RequestMapping("specName")
public class SpecNameController {

    @Reference
    private SpecNameService specNameService;

    @ApiOperation("根据id获取规格名称")
    @GetMapping("get")
    public ResponseResult getSpecName(Integer id) throws Exception{
        SpecName specName = specNameService.getSpecName(id);
        return ResponseResult.success(specName);
    }

    @ApiOperation("根据分类id获取规格名称列表")
    @GetMapping("listByCid")
    public ResponseResult listSpecNamesByCategoryId(Integer categoryId) throws Exception{
        List<SpecName> specNames = specNameService.listSpecNamesByCategoryId(categoryId);
        return ResponseResult.success(specNames);
    }

    @ApiOperation("根据商品spuid获取规格名称列表")
    @GetMapping("listBySpuId")
    public ResponseResult listSpecNamesBySpuId(Integer spuId) throws Exception{
        List<SpecName> specNames = specNameService.listSpecNamesBySpuId(spuId);
        return ResponseResult.success(specNames);
    }

    @ApiOperation("添加规格名称")
    @PostMapping("save")
    public ResponseResult saveSpecName(@RequestBody SpecName specName) throws Exception{
        int result = specNameService.saveSpecName(specName);
        return ResponseResult.success(result);
    }

    @ApiOperation("修改规格名称")
    @PutMapping("upd")
    public ResponseResult updSpecName(@RequestBody SpecName specName) throws Exception{
        int result = specNameService.updSpecName(specName);
        return ResponseResult.success(result);
    }

    @ApiOperation(("根据id删除"))
    @DeleteMapping("del")
    public ResponseResult delSpecName(Integer id) throws Exception{
        int result = specNameService.delSpecName(id);
        return ResponseResult.success(result);
    }

    @ApiOperation("根据分类id删除")
    @DeleteMapping("delByCid")
    public ResponseResult delSpecNames(Integer categoryId) throws Exception{
        int result = specNameService.delSpecNames(categoryId);
        return ResponseResult.success(result);
    }
}
