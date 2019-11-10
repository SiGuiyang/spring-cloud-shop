package quick.pager.shop.controller.goods;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.dto.goods.GoodsBrandGroupDTO;
import quick.pager.shop.model.goods.GoodsBrandGroup;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.GoodsBrandGroupService;

/**
 * 商品管理 -> 品牌组
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(Constants.Module.MANAGE)
public class GoodsBrandGroupManageController {

    @Autowired
    private GoodsBrandGroupService goodsBrandGroupService;

    /**
     * 新建商品品牌组
     */
    @PostMapping("/goods/brand/group/create")
    public Response create(@RequestBody GoodsBrandGroupDTO dto) {
        return goodsBrandGroupService.create(dto);
    }

    /**
     * 修改商品品牌组
     */
    @PutMapping("/goods/brand/group/modify")
    public Response modify(@RequestBody GoodsBrandGroupDTO dto) {
        return goodsBrandGroupService.modify(dto);
    }

    /**
     * 商品品牌组列表
     */
    @PostMapping(value = "/goods/brand/group/list")
    public Response<List<GoodsBrandGroup>> list(@RequestBody GoodsBrandGroupDTO dto) {
        return goodsBrandGroupService.list(dto);
    }

    /**
     * 商品品牌组所有列表
     */
    @PostMapping(value = "/goods/brand/group/listAll")
    public Response<List<GoodsBrandGroup>> listAll() {
        return goodsBrandGroupService.listAll();
    }

}
