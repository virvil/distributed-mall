package distributed.mall.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import distributed.mall.common.utils.pojo.ResponseResult;
import distributed.mall.pojo.pojo.SpecValue;
import distributed.mall.product.api.SpecValueService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <b><code>SpecValueController</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/1/27 14:25.
 *
 * @author virvil
 * @since distributed-mall ${PROJECT_VERSION}
 */
@Api("规格值管理类")
@RestController
@RequestMapping("specValue")
public class SpecValueController {

    @Reference
    private SpecValueService specValueService;

    @ApiOperation("根据id获取规格值")
    @GetMapping("get")
    public ResponseResult getSpecValue(Integer id) throws Exception{
        SpecValue specValue = specValueService.getSpecValue(id);
        return ResponseResult.success(specValue);
    }

    @ApiOperation("根据规格名称id获取规格值列表")
    @GetMapping("list")
    public ResponseResult listSpecValues(Integer specNameId) throws Exception{
        List<SpecValue> specValues = specValueService.listSpecValues(specNameId);
        return ResponseResult.success(specValues);
    }

    @ApiOperation("添加规格值")
    @PostMapping("save")
    public ResponseResult saveSpecValue(@RequestBody SpecValue specValue) throws Exception{
        int result = specValueService.saveSpecValue(specValue);
        return ResponseResult.success(result);
    }

    @ApiOperation("修改规格值")
    @PutMapping("del")
    public ResponseResult updSpecValue(@RequestBody SpecValue specValue)throws Exception{
        int result = specValueService.updSpecValue(specValue);
        return ResponseResult.success(result);
    }

    @ApiOperation("根据id删除规格值")
    @DeleteMapping("del")
    public ResponseResult delSpecValue(Integer id) throws Exception{
        int result = specValueService.delSpecValue(id);
        return ResponseResult.success(result);
    }

    @ApiOperation("根据规格名称id删除规格值")
    @DeleteMapping("delBySpecNameId")
    public ResponseResult delSpecValues(Integer specNameId) throws Exception{
        int result = specValueService.delSpecValues(specNameId);
        return ResponseResult.success(result);
    }
}
