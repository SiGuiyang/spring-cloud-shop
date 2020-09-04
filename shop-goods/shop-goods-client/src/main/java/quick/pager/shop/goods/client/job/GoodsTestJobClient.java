package quick.pager.shop.goods.client.job;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.user.response.Response;

/**
 * 商品服务测试定时任务
 *
 * @author siguiyang
 */
@FeignClient(value = ConstantsClient.GOODS_CLIENT, path = ConstantsClient.GOODS)
public interface GoodsTestJobClient {

    /**
     * 测试访问服务
     *
     * @param params
     * @return
     */
    @RequestMapping(value = "goodsTestJob", method = RequestMethod.POST)
    Response<String> goodsTestJob(@RequestBody final String params);
}
