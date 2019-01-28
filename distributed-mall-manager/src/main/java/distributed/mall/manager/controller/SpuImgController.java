package distributed.mall.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import distributed.mall.common.utils.pojo.ResponseResult;
import distributed.mall.pojo.mapper.SpuImgMapper;
import distributed.mall.pojo.pojo.SpuImg;
import distributed.mall.product.api.SpuImgService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <b><code>SpuImgController</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/1/27 15:32.
 *
 * @author virvil
 * @since distributed-mall ${PROJECT_VERSION}
 */
@Api("商品spu图片管理")
@RestController
@RequestMapping("spuImg")
public class SpuImgController {

    @Reference
    private SpuImgService spuImgService;

    @ApiOperation("根据id获取图片")
    @GetMapping("get")
    public ResponseResult getSpuImg(Integer id) throws Exception{
        SpuImg spuImg = spuImgService.getSpuImg(id);
        return ResponseResult.success(spuImg);
    }

    @ApiOperation("根据spuId获取图片")
    @GetMapping("list")
    public ResponseResult listSpuImgs(Integer spuId) throws Exception{
        List<SpuImg> spuImgs = spuImgService.listSpuImgs(spuId);
        return ResponseResult.success(spuImgs);
    }

    @ApiOperation("添加图片")
    @PostMapping("save")
    public ResponseResult saveSpuImg(@RequestBody SpuImg spuImg) throws Exception{
        int result = spuImgService.saveSpuImg(spuImg);
        return ResponseResult.success(result);
    }

    @ApiOperation("修改图片")
    @PutMapping("upd")
    public ResponseResult updSpuImg(@RequestBody SpuImg spuImg) throws Exception{
        int result = spuImgService.updSpuImg(spuImg);
        return ResponseResult.success(result);
    }

    @ApiOperation("删除图片")
    @DeleteMapping("del")
    public ResponseResult delSpuImg(Integer id) throws Exception{
        int result = spuImgService.delSpuImg(id);
        return ResponseResult.success(result);
    }

    @ApiOperation("根据spuId删除图片")
    @DeleteMapping("delBySpuId")
    public ResponseResult delSpuImgs(Integer spuId) throws Exception{
        int result = spuImgService.delSpuImgs(spuId);
        return ResponseResult.success(result);
    }
}
