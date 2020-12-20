package quick.pager.shop.service;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.platform.dto.SystemConfigDTO;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.response.EnumResponse;

/**
 * 通用枚举服务
 *
 * @author siguiyang
 */
@Service
public class CommonEnumService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public Response<Map<String, List<EnumResponse>>> getCommonEnumInfo() {

        Map<String, List<EnumResponse>> result = Maps.newHashMap();
        result.putIfAbsent(Constants.Type.OFFER_TYPE, getOfferType());
        result.putIfAbsent(Constants.Type.GOODS_TYPE, getGoodsType());
        result.putIfAbsent(Constants.Type.ORDER_TYPE, getOrderType());
        result.putIfAbsent(Constants.Type.ORDER_STATUS, getOrderStatus());
        result.putIfAbsent(Constants.Type.MODULE_TYPE, getModuleType());
        result.putIfAbsent(Constants.Type.BANNER_TYPE, getBannerType());
        result.putIfAbsent(Constants.Type.SHARE_CHANNEL, getBannerShareChannel());

        return Response.toResponse(result);
    }

    /**
     * 优惠券
     */
    private List<EnumResponse> getOfferType() {
        Long size = redisTemplate.opsForList().size("offer_type");

        if (Objects.nonNull(size)) {
            return getCommonInteger(redisTemplate.opsForList().range("offer_type", 0, size));
        }

        return Lists.newArrayList();
    }

    /**
     * 商品类型
     */
    private List<EnumResponse> getGoodsType() {

        Long size = redisTemplate.opsForList().size("goods_type");

        if (Objects.nonNull(size)) {
            return getCommonInteger(redisTemplate.opsForList().range("goods_type", 0, size));
        }

        return Lists.newArrayList();
    }


    /**
     * 订单类型
     */
    private List<EnumResponse> getOrderType() {

        Long size = redisTemplate.opsForList().size("order_type");

        if (Objects.nonNull(size)) {
            return getCommonInteger(redisTemplate.opsForList().range("order_type", 0, size));
        }

        return Lists.newArrayList();
    }

    /**
     * 订单状态
     */
    private List<EnumResponse> getOrderStatus() {

        Long size = redisTemplate.opsForList().size("order_status");

        if (Objects.nonNull(size)) {
            return getCommonString(redisTemplate.opsForList().range("order_status", 0, size));
        }

        return Lists.newArrayList();
    }

    /**
     * 模块类型
     */
    private List<EnumResponse> getModuleType() {

        Long size = redisTemplate.opsForList().size("shop_module");

        if (Objects.nonNull(size)) {
            return getCommonString(redisTemplate.opsForList().range("shop_module", 0, size));
        }

        return Lists.newArrayList();
    }

    /**
     * Banner类型
     */
    private List<EnumResponse> getBannerType() {

        Long size = redisTemplate.opsForList().size("banner_type");

        if (Objects.nonNull(size)) {
            return getCommonString(redisTemplate.opsForList().range("banner_type", 0, size));
        }

        return Lists.newArrayList();
    }

    /**
     * Banner分享渠道
     */
    private List<EnumResponse> getBannerShareChannel() {

        Long size = redisTemplate.opsForList().size("share_channel");

        if (Objects.nonNull(size)) {
            return getCommonString(redisTemplate.opsForList().range("share_channel", 0, size));
        }

        return Lists.newArrayList();
    }

    /**
     * SystemConfig configValue 配置使用String型
     */
    private List<EnumResponse> getCommonString(final List<Object> result) {
        List<SystemConfigDTO> systemConfigs = JSON.parseArray(JSON.toJSONString(result), SystemConfigDTO.class);
        return Optional.ofNullable(systemConfigs).orElse(Lists.newArrayList()).stream()
                .map(config -> new EnumResponse(config.getConfigValue(), config.getConfigName()))
                .collect(Collectors.toList());
    }

    /**
     * SystemConfig configValue 配置使用int型
     */
    private List<EnumResponse> getCommonInteger(List<Object> result) {
        List<SystemConfigDTO> systemConfigs = JSON.parseArray(JSON.toJSONString(result), SystemConfigDTO.class);
        return Optional.ofNullable(systemConfigs).orElse(Lists.newArrayList()).stream()
                .map(config -> new EnumResponse(Integer.parseInt(config.getConfigValue()), config.getConfigName()))
                .collect(Collectors.toList());
    }
}
