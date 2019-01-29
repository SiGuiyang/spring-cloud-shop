package quick.pager.shop.goods.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.common.constants.Constants;
import quick.pager.common.dto.BaseDTO;
import quick.pager.common.request.AppRequest;
import quick.pager.common.response.Response;
import quick.pager.shop.feign.dto.GoodsDTO;
import quick.pager.shop.goods.constants.GoodsConstants;
import quick.pager.shop.goods.dto.GoodsSearchDTO;
import quick.pager.shop.goods.service.GoodsDetailService;
import quick.pager.shop.goods.service.GoodsHomeListService;
import quick.pager.shop.goods.service.GoodsSearchService;

/**
 * APP展示商品
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(Constants.Module.GOODS)
@Api(description = "商品服务")
public class GoodsController {

    @Autowired
    private GoodsHomeListService goodsHomeListService;
    @Autowired
    private GoodsDetailService goodsDetailService;
    @Autowired
    private GoodsSearchService goodsSearchService;


    @ApiOperation("首页商品列表")
    @PostMapping("/home/goods/list")
    public Response homeGoodsList(AppRequest request) {
        GoodsDTO dto = new GoodsDTO();
        dto.setPage(request.getPage());
        dto.setPageSize(request.getPageSize());
        return goodsHomeListService.doService(dto);
    }

    @ApiOperation("商品搜索")
    @PostMapping("/search")
    public Response goodsSearch(GoodsSearchDTO dto) {

        dto.setEvent(GoodsConstants.SEARCH_GOODS_SEARCH_EVENT);
        return goodsSearchService.doService(dto);
    }

    @ApiOperation("查看商品详情")
    @PostMapping("/goodsInfo/{goodsId}")
    public Response goodsInfo(@PathVariable("goodsId") Long goodsId) {
        BaseDTO dto = new BaseDTO();
        dto.setId(goodsId);
        return goodsDetailService.doService(dto);

    }

    @ApiOperation("根据商品分类搜索商品")
    @PostMapping("searchByClassification/{goodsClassId}")
    public Response goodsSearchByClassification(@PathVariable("goodsClassId") Long goodsClassId,
                                                @RequestParam("page") Integer page,
                                                @RequestParam("pageSize") Integer pageSize) {
        GoodsSearchDTO dto = new GoodsSearchDTO();
        dto.setGoodsClassId(goodsClassId);
        dto.setPage(page);
        dto.setPageSize(pageSize);
        dto.setEvent(GoodsConstants.SEARCH_CLASSIFICATION_EVENT);
        return goodsSearchService.doService(dto);
    }
}
