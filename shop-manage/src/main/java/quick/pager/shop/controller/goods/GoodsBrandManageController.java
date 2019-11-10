package quick.pager.shop.controller.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.dto.goods.GoodsBrandDTO;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.goods.GoodsBrandService;

/**
 * 商品管理-->品牌管理
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(Constants.Module.MANAGE)
public class GoodsBrandManageController {

    @Autowired
    private GoodsBrandService goodsBrandService;

    /**
     * 品牌列表
     */
    @PostMapping("/goods/brand/list")
    public Response list(@RequestBody GoodsBrandDTO dto) {

        return goodsBrandService.list(dto);
    }

    /**
     * 品牌创建或修改
     */
    @PostMapping("/goods/brand/create")
    public Response create(@RequestBody GoodsBrandDTO dto) {
        return goodsBrandService.create(dto);
    }

    /**
     * 品牌修改
     */
    @PutMapping("/goods/brand/modify")
    public Response modify(@RequestBody GoodsBrandDTO dto) {
        return goodsBrandService.modify(dto);
    }
}
