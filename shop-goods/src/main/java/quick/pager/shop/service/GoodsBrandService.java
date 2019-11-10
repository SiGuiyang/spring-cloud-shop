package quick.pager.shop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;
import quick.pager.shop.dto.goods.GoodsBrandDTO;
import quick.pager.shop.model.goods.GoodsBrand;
import quick.pager.shop.response.Response;

/**
 * 商品品牌
 *
 * @author siguiyang
 */
public interface GoodsBrandService extends IPageService<GoodsBrand> {

    /**
     * 品牌列表
     * @param dto
     * @return
     */
    Response<List<GoodsBrand>> goodsBrandList(GoodsBrandDTO dto);
}
