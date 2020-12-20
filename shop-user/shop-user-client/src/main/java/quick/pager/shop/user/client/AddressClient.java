package quick.pager.shop.user.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.user.fallback.AddressFallbackFactory;
import quick.pager.shop.user.response.AddressResponse;
import quick.pager.shop.user.response.Response;

/**
 * 地址服务
 *
 * @author siguiyang
 */
@FeignClient(value = ConstantsClient.USER_CLIENT, path = ConstantsClient.USER, fallbackFactory = AddressFallbackFactory.class)
public interface AddressClient {


    /**
     * 查询用户默认地址
     *
     * @param userId 用户主键
     */
    @RequestMapping(value = "/address/default/{userId}", method = RequestMethod.POST)
    Response<AddressResponse> address(@PathVariable("userId") Long userId);


    /**
     * 获取地址信息
     *
     * @param addressId 地址主键
     */
    @RequestMapping(value = "/address/{addressId}/info", method = RequestMethod.POST)
    Response<AddressResponse> info(@PathVariable("addressId") Long addressId);
}
