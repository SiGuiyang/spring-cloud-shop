package quick.pager.shop.service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.response.Response;
import quick.pager.shop.response.EnumResponse;

/**
 * 通用枚举服务
 *
 * @author siguiyang
 */
@Service
@Slf4j
public class CommonEnumService {
    public Response<Map<String, List<EnumResponse>>> getCommonEnumInfo() {

        Map<String, List<EnumResponse>> result = Maps.newConcurrentMap();
        result.putIfAbsent(Constants.Type.COUPON_TYPE, getCouponType());
        result.putIfAbsent(Constants.Type.GOODS_TYPE, getGoodsType());
        result.putIfAbsent(Constants.Type.ORDER_TYPE, getOrderType());
        result.putIfAbsent(Constants.Type.ORDER_STATUS, getOrderStatus());

        return new Response<>(result);
    }

    /**
     * 优惠券
     */
    private List<EnumResponse> getCouponType() {
        Constants.CouponType[] values = Constants.CouponType.values();

        List<EnumResponse> couponTypeResponses = Lists.newArrayList();

        for (Constants.CouponType couponType : values) {
            EnumResponse orderStatusResponse = new EnumResponse();
            orderStatusResponse.setType(couponType.getType());
            orderStatusResponse.setValue(couponType.getName());
            couponTypeResponses.add(orderStatusResponse);
        }
        return couponTypeResponses;
    }

    /**
     * 商品类型
     */
    private List<EnumResponse> getGoodsType() {
        Constants.GoodsType[] values = Constants.GoodsType.values();

        List<EnumResponse> goodsTypeResponses = Lists.newArrayList();

        for (Constants.GoodsType goodsType : values) {
            EnumResponse orderStatusResponse = new EnumResponse();
            orderStatusResponse.setType(goodsType.getType());
            orderStatusResponse.setValue(goodsType.getName());
            goodsTypeResponses.add(orderStatusResponse);
        }
        return goodsTypeResponses;
    }


    /**
     * 订单类型
     */
    private List<EnumResponse> getOrderType() {
        Constants.OrderType[] values = Constants.OrderType.values();

        List<EnumResponse> orderTypeResponses = Lists.newArrayList();

        for (Constants.OrderType orderType : values) {
            EnumResponse orderStatusResponse = new EnumResponse();
            orderStatusResponse.setType(orderType.getType());
            orderStatusResponse.setValue(orderType.getName());
            orderTypeResponses.add(orderStatusResponse);
        }
        return orderTypeResponses;
    }

    /**
     * 订单状态
     */
    private List<EnumResponse> getOrderStatus() {
        Constants.OrderStatus[] values = Constants.OrderStatus.values();

        List<EnumResponse> orderStatusResponses = Lists.newArrayList();

        for (Constants.OrderStatus orderStatus : values) {
            EnumResponse orderStatusResponse = new EnumResponse();
            orderStatusResponse.setKey(orderStatus.getStatus());
            orderStatusResponse.setValue(orderStatus.getName());
            orderStatusResponses.add(orderStatusResponse);
        }
        return orderStatusResponses;
    }
}
