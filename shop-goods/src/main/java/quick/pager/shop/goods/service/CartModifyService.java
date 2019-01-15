package quick.pager.shop.goods.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.common.dto.DTO;
import quick.pager.common.response.Response;
import quick.pager.common.service.IService;
import quick.pager.shop.goods.mapper.GoodsCartMapper;

/**
 * 购物车添加删除服务
 *
 * @author siguiyang
 */
@Service
@Slf4j
public class CartModifyService implements IService {

    @Autowired
    private GoodsCartMapper goodsCartMapper;

    @Override
    public Response doService(DTO dto) {
        return null;
    }
}
