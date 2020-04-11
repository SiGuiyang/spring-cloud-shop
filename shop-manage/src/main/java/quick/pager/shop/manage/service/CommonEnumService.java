package quick.pager.shop.manage.service;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.platform.dto.SystemConfigDTO;
import quick.pager.shop.response.Response;
import quick.pager.shop.manage.response.EnumResponse;
import quick.pager.shop.service.RedisService;

/**
 * 通用枚举服务
 *
 * @author siguiyang
 */
@Service
public class CommonEnumService {

    @Autowired
    private RedisService redisService;

    public Response<Map<String, List<EnumResponse>>> getCommonEnumInfo() {

        Map<String, List<EnumResponse>> result = Maps.newHashMap();
        result.putIfAbsent(Constants.Type.OFFER_TYPE, getOfferType());
        result.putIfAbsent(Constants.Type.GOODS_TYPE, getGoodsType());
        result.putIfAbsent(Constants.Type.ORDER_TYPE, getOrderType());
        result.putIfAbsent(Constants.Type.ORDER_STATUS, getOrderStatus());
        result.putIfAbsent(Constants.Type.MODULE_TYPE, getModuleType());

        return new Response<>(result);
    }

    /**
     * 优惠券
     */
    private List<EnumResponse> getOfferType() {
        String couponConfig = redisService.get("offer_type");

        if (StringUtils.isNotBlank(couponConfig)) {
            return getCommonInteger(JSON.parseArray(couponConfig, SystemConfigDTO.class));
        }

        return Lists.newArrayList();
    }

    /**
     * 商品类型
     */
    private List<EnumResponse> getGoodsType() {
        String goodsConfig = redisService.get("goods_type");

        if (StringUtils.isNotBlank(goodsConfig)) {
            return getCommonInteger(JSON.parseArray(goodsConfig, SystemConfigDTO.class));
        }

        return Lists.newArrayList();
    }


    /**
     * 订单类型
     */
    private List<EnumResponse> getOrderType() {
        String orderTypeConfig = redisService.get("order_type");

        if (StringUtils.isNotBlank(orderTypeConfig)) {
            return getCommonInteger(JSON.parseArray(orderTypeConfig, SystemConfigDTO.class));
        }

        return Lists.newArrayList();
    }

    /**
     * 订单状态
     */
    private List<EnumResponse> getOrderStatus() {

        String orderStatusConfig = redisService.get("order_status");

        if (StringUtils.isNotBlank(orderStatusConfig)) {
            return getCommonString(JSON.parseArray(orderStatusConfig, SystemConfigDTO.class));
        }

        return Lists.newArrayList();
    }

    /**
     * 模块类型
     */
    private List<EnumResponse> getModuleType() {

        String moduleConfig = redisService.get("shop_module");

        if (StringUtils.isNotBlank(moduleConfig)) {
            return getCommonString(JSON.parseArray(moduleConfig, SystemConfigDTO.class));
        }

        return Lists.newArrayList();
    }

    /**
     * SystemConfig configValue 配置使用String型
     */
    private List<EnumResponse> getCommonString(List<SystemConfigDTO> systemConfigs) {
        return systemConfigs.stream()
                .map(config -> new EnumResponse(config.getConfigValue(), config.getConfigName()))
                .collect(Collectors.toList());
    }

    /**
     * SystemConfig configValue 配置使用int型
     */
    private List<EnumResponse> getCommonInteger(List<SystemConfigDTO> systemConfigs) {
        return systemConfigs.stream()
                .map(config -> new EnumResponse(Integer.parseInt(config.getConfigValue()), config.getConfigName()))
                .collect(Collectors.toList());
    }
}
