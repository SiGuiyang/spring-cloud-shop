package quick.pager.shop.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.dto.BaseDTO;
import quick.pager.shop.response.Response;
import quick.pager.shop.mapper.GoodsCartMapper;

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
    public Response doService(BaseDTO dto) {
        return null;
    }
}
