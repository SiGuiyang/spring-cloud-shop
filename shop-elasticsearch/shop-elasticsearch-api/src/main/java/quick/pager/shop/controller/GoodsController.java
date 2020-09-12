package quick.pager.shop.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.elasticsearch.request.ESGoodsPageRequest;
import quick.pager.shop.elasticsearch.response.ESGoodsResponse;
import quick.pager.shop.service.GoodsService;
import quick.pager.shop.user.response.Response;

/**
 * 商品ES服务
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(ConstantsClient.ELASTICSEARCH)
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    /**
     * 查询商品
     *
     * @param request 请求参数
     */
    @PostMapping("/goods/page")
    public Response<List<ESGoodsResponse>> queryPage(@RequestBody final ESGoodsPageRequest request) {
        return goodsService.queryPage(request);
    }
}
