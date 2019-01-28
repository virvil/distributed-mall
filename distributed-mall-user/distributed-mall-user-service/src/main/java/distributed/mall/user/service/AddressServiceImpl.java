package distributed.mall.user.service;

import com.alibaba.dubbo.config.annotation.Service;
import distributed.mall.pojo.mapper.AddressMapper;
import distributed.mall.pojo.pojo.Address;
import distributed.mall.user.api.AddressService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;

/**
 * <b><code>AddressServiceImpl</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/1/20 11:14.
 *
 * @author virvil
 * @since distributed-mall ${PROJECT_VERSION}
 */
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public List<Address> listAddress(int userId) throws Exception {
        List<Address> addresses = addressMapper.listAddress(userId);
        if (CollectionUtils.isEmpty(addresses)){
            return null;
        }
        int size = addresses.size();
        //将默认的地址放在列表的第一个位置
        for (int i=0;i<size;i++){
            if (addresses.get(i).getIsDefault()){
                Collections.swap(addresses, 0, i);
                break;
            }
        }
        return addresses;
    }

    @Override
    public Address getAddress(int id) throws Exception {
        Address address = addressMapper.getAddress(id);
        return address;
    }

    @Override
    public int saveAddress(Address address) throws Exception {
        int result = addressMapper.saveAddress(address);
        return result;
    }

    @Override
    public int updAddress(Address address) throws Exception {
        int result = addressMapper.updAddress(address);
        return result;
    }

    @Override
    public int delAddress(int id) throws Exception {
        int result = addressMapper.delAddress(id);
        return result;
    }
}
