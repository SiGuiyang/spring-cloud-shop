package quick.pager.shop.service.goods;

import java.util.List;
import quick.pager.shop.dto.goods.GoodsBrandDTO;
import quick.pager.shop.response.Response;

/**
 * 商品品牌
 *
 * @author siguiyang
 */
public interface GoodsBrandService {

    /**
     * 品牌列表
     */
    Response<List<GoodsBrandDTO>> list(GoodsBrandDTO dto);

    /**
     * 新增品牌
     */
    Response create(GoodsBrandDTO dto);

    /**
     * 修改品牌
     */
    Response modify(GoodsBrandDTO dto);
}
