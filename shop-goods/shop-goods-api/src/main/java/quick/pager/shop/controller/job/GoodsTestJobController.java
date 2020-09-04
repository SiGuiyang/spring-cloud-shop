package quick.pager.shop.controller.job;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.user.response.Response;

@RestController
@RequestMapping(ConstantsClient.GOODS)
public class GoodsTestJobController {

    /**
     * 测试访问服务
     *
     * @param params
     * @return
     */
    @RequestMapping(value = "goodsTestJob", method = RequestMethod.POST)
    public Response<String> goodsTestJob(@RequestBody final String params) {

        System.out.println("执行商品定时任务" + params);
        return new Response<>(params);
    }
}
