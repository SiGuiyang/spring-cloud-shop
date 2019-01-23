package quick.pager.shop.manage.service;

import com.google.common.collect.Lists;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import quick.pager.common.constants.Constants;
import quick.pager.common.constants.ResponseStatus;
import quick.pager.common.response.Response;
import quick.pager.shop.manage.response.EnumResponse;

/**
 * 通用枚举服务
 *
 * @author siguiyang
 */
@Service
@Slf4j
public class CommonEnumService {
    public Response<List<EnumResponse>> getCommonEnumInfo(String type) {

        Response<List<EnumResponse>> response = new Response<>();

        switch (type) {
            case Constants.Type.ORDER_STATUS:
                response = getOrderStatus();
                break;
            case Constants.Type.ORDER_TYPE:
                response = getOrderType();
                break;
            case Constants.Type.GOODS_TYPE:
                response = getGoodsType();
                break;
            case Constants.Type.COUPON_TYPE:
                response = getCouponType();
                break;
            default:
                response = new Response<>(ResponseStatus.Code.FAIL_CODE, ResponseStatus.PARAMS_EXCEPTION);
        }
        return response;
    }

    /**
     * 优惠券
     */
    private Response<List<EnumResponse>> getCouponType() {
        Constants.CouponType[] values = Constants.CouponType.values();

        List<EnumResponse> couponTypeResponses = Lists.newArrayList();

        for (Constants.CouponType couponType : values) {
            EnumResponse orderStatusResponse = new EnumResponse();
            orderStatusResponse.setType(couponType.getType());
            orderStatusResponse.setValue(couponType.getName());
            couponTypeResponses.add(orderStatusResponse);
        }
        return new Response<>(couponTypeResponses);
    }

    /**
     * 商品类型
     */
    private Response<List<EnumResponse>> getGoodsType() {
        Constants.GoodsType[] values = Constants.GoodsType.values();

        List<EnumResponse> goodsTypeResponses = Lists.newArrayList();

        for (Constants.GoodsType goodsType : values) {
            EnumResponse orderStatusResponse = new EnumResponse();
            orderStatusResponse.setType(goodsType.getType());
            orderStatusResponse.setValue(goodsType.getName());
            goodsTypeResponses.add(orderStatusResponse);
        }
        return new Response<>(goodsTypeResponses);
    }


    /**
     * 订单类型
     */
    private Response<List<EnumResponse>> getOrderType() {
        Constants.OrderType[] values = Constants.OrderType.values();

        List<EnumResponse> orderTypeResponses = Lists.newArrayList();

        for (Constants.OrderType orderType : values) {
            EnumResponse orderStatusResponse = new EnumResponse();
            orderStatusResponse.setType(orderType.getType());
            orderStatusResponse.setValue(orderType.getName());
            orderTypeResponses.add(orderStatusResponse);
        }
        return new Response<>(orderTypeResponses);
    }

    /**
     * 订单状态
     */
    private Response<List<EnumResponse>> getOrderStatus() {
        Constants.OrderStatus[] values = Constants.OrderStatus.values();

        List<EnumResponse> orderStatusResponses = Lists.newArrayList();

        for (Constants.OrderStatus orderStatus : values) {
            EnumResponse orderStatusResponse = new EnumResponse();
            orderStatusResponse.setKey(orderStatus.getStatus());
            orderStatusResponse.setValue(orderStatus.getName());
            orderStatusResponses.add(orderStatusResponse);
        }
        return new Response<>(orderStatusResponses);
    }
}
