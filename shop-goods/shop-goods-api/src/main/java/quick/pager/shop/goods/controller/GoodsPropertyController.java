package quick.pager.shop.goods.controller;

import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.goods.request.property.GoodsPropertyPageRequest;
import quick.pager.shop.goods.request.property.GoodsPropertySaveRequest;
import quick.pager.shop.goods.response.property.GoodsPropertyResponse;
import quick.pager.shop.goods.service.GoodsPropertyService;
import quick.pager.shop.response.Response;

/**
 * 商品属性
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(ConstantsClient.GOODS)
public class GoodsPropertyController {

    @Autowired
    private GoodsPropertyService goodsPropertyService;

    /**
     * 分页
     *
     * @param request 请求参数
     * @return 返回结果
     */
    @PostMapping("/property/page")
    public Response<List<GoodsPropertyResponse>> page(@RequestBody GoodsPropertyPageRequest request) {

        return goodsPropertyService.queryPage(request);
    }

    /**
     * 新增
     *
     * @param request 请求参数
     * @return 返回结果
     */
    @PostMapping("/property/create")
    public Response<Long> create(@RequestBody GoodsPropertySaveRequest request) {

        return goodsPropertyService.create(request);
    }

    /**
     * 编辑
     *
     * @param request 请求参数
     * @return 返回结果
     */
    @PutMapping("/property/modify")
    public Response<Long> modify(@RequestBody GoodsPropertySaveRequest request) {

        if (Objects.isNull(request.getId())) {
            return new Response<>(ResponseStatus.Code.FAIL_CODE, ResponseStatus.PARAMS_EXCEPTION);
        }

        return goodsPropertyService.modify(request);
    }
}
