package distributed.mall.user.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import distributed.mall.common.utils.pojo.ResponseResult;
import distributed.mall.pojo.pojo.Address;
import distributed.mall.user.api.AddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * <b><code>AddressController</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/1/20 11:34.
 *
 * @author virvil
 * @since distributed-mall ${PROJECT_VERSION}
 */
@Api("用户地址操作类")
@RestController
@RequestMapping("address")
public class AddressController {

    @Reference
    private AddressService addressService;

    @ApiOperation(value = "用户地址列表",notes = "列表第一位为默认地址")
    @GetMapping("list")
    public ResponseResult listAddress(int userId)throws Exception{
        List<Address> addresses = addressService.listAddress(userId);
        return ResponseResult.success(addresses);
    }

    @ApiOperation(value = "根据id获取地址")
    @GetMapping("get")
    public ResponseResult getAddress(int id) throws Exception{
        Address address = addressService.getAddress(id);
        return ResponseResult.success(address);
    }

    @ApiOperation(value = "添加用户地址")
    @PostMapping("save")
    public ResponseResult saveAddress(@RequestBody Address address)throws Exception{
        address.setCreateTime(new Date());
        int result = addressService.saveAddress(address);
        if (result<1){
            return ResponseResult.error();
        }
        return ResponseResult.success();
    }

    @ApiOperation(value = "更新地址")
    @PostMapping("upd")
    public ResponseResult updAddress(@RequestBody Address address)throws Exception{
        int result = addressService.updAddress(address);
        if (result<1){
            return ResponseResult.error();
        }
        return ResponseResult.success();
    }

    @ApiOperation(value = "删除地址")
    @PostMapping("del")
    public ResponseResult delAddress(int id) throws Exception{
        int result = addressService.delAddress(id);
        if (result<1){
            return ResponseResult.error();
        }
        return ResponseResult.success();
    }
}
