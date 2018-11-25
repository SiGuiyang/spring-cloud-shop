package quick.pager.shop.goods.service;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import quick.pager.common.dto.DTO;
import quick.pager.common.response.Response;
import quick.pager.common.service.IService;

/**
 * 商品详情服务
 *
 * @author siguiyang
 */
@Service
@Slf4j
public class GoodsDetailService implements IService {
    @Override
    public Response doService(DTO dto) {
        log.info("开始调用商品详情服务 params = {}", JSON.toJSONString(dto));

        return null;
    }
}
