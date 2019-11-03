package quick.pager.shop.service;

import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.model.SystemConfig;
import quick.pager.shop.response.Response;
import quick.pager.shop.response.EnumResponse;
import quick.pager.shop.utils.SystemConfigMap;

/**
 * 通用枚举服务
 *
 * @author siguiyang
 */
@Service
public class CommonEnumService {

    public Response<Map<String, List<EnumResponse>>> getCommonEnumInfo() {

        Map<String, List<EnumResponse>> result = Maps.newHashMap();
        result.putIfAbsent(Constants.Type.COUPON_TYPE, getCouponType());
        result.putIfAbsent(Constants.Type.GOODS_TYPE, getGoodsType());
        result.putIfAbsent(Constants.Type.ORDER_TYPE, getOrderType());
        result.putIfAbsent(Constants.Type.ORDER_STATUS, getOrderStatus());
        result.putIfAbsent(Constants.Type.MODULE_TYPE, getModuleType());

        return new Response<>(result);
    }

    /**
     * 优惠券
     */
    private List<EnumResponse> getCouponType() {
        List<SystemConfig> couponType = SystemConfigMap.get("coupon_type");

        return getCommonInteger(couponType);
    }

    /**
     * 商品类型
     */
    private List<EnumResponse> getGoodsType() {
        List<SystemConfig> goodsTypes = SystemConfigMap.get("goods_type");

        return getCommonInteger(goodsTypes);
    }


    /**
     * 订单类型
     */
    private List<EnumResponse> getOrderType() {
        List<SystemConfig> orderTypes = SystemConfigMap.get("order_type");
        return getCommonInteger(orderTypes);
    }

    /**
     * 订单状态
     */
    private List<EnumResponse> getOrderStatus() {

        List<SystemConfig> orderStatus = SystemConfigMap.get("order_status");

        return getCommonString(orderStatus);
    }

    /**
     * 模块类型
     */
    private List<EnumResponse> getModuleType() {
        List<SystemConfig> moduleType = SystemConfigMap.get("module_type");

        return getCommonString(moduleType);
    }

    /**
     * SystemConfig configValue 配置使用String型
     */
    private List<EnumResponse> getCommonString(List<SystemConfig> systemConfigs) {
        return systemConfigs.stream()
                .map(config -> new EnumResponse(config.getConfigValue(), config.getDescription()))
                .collect(Collectors.toList());
    }


    /**
     * SystemConfig configValue 配置使用int型
     */
    private List<EnumResponse> getCommonInteger(List<SystemConfig> systemConfigs) {
        return systemConfigs.stream()
                .map(config -> new EnumResponse(Integer.parseInt(config.getConfigValue()), config.getDescription()))
                .collect(Collectors.toList());
    }
}
