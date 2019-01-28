package distributed.mall.user.api;

import distributed.mall.pojo.pojo.Address;

import java.util.List;

/**
 * <b><code>AddressService</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/1/20 11:14.
 *
 * @author virvil
 * @since distributed-mall ${PROJECT_VERSION}
 */
public interface AddressService {

    List<Address> listAddress(int userId) throws Exception;

    Address getAddress(int id) throws Exception;

    int saveAddress(Address address) throws Exception;

    int updAddress(Address address) throws Exception;

    int delAddress(int id) throws Exception;
}
