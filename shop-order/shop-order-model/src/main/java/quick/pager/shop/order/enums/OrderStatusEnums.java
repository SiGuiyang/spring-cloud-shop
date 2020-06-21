package quick.pager.shop.order.enums;

import quick.pager.shop.enums.IEnum;

/**
 * 订单状态 <br />
 * 1.订单生成但没有支付，则状态是BS001 <br />
 * 2.订单生成，已支付 <br />
 * 3.商家没有发货，则消费者端与商家端状态是BS002 <br />
 * 4.商家发货，消费者端状态是BS004 <br />
 * 5.商家确认发货完成，消费者端与商家端状态是BS006 <br />
 * 6.三天内用户未评价，订单自动自动完成，状态是BS008 <br />
 * 7.三天内用户评价，消费者端与商家端订单完成，状态是BS008 <br />
 * 8.如果订单是自提类型，消费者端与商家端的状态是BS007 <br />
 * 9.如果订单是自提类型，商家确认发货，走步骤5
 * 10.如果订单状态是BS002与BS004状态时，消费者端可以申请退款和取消订单 <br />
 * 11.当消费者端申请退款后，消费者端状态BS010，商家端状态BS012 <br />
 * 12.当退款完成后，消费者端状态BS011，商家端状态BS013，也就是说，只有消费者退款的订单，商家端才会有已关闭的状态<br />
 * 13.当消费者取消订单后，消费者端与商家端状态BS009 <br />
 * 14.如果商家不方便发货，商家与消费者沟通，无法配送，商家取消订单 BS009 <br />
 *
 * @author siguiyang
 */
public enum OrderStatusEnums implements IEnum<String> {
    BS001("BS001", "待付款"),
    BS002("BS002", "待发货"),
    BS003("BS003", "已发货"),
    BS004("BS004", "待收获"),
    BS005("BS005", "已签收"),
    BS006("BS006", "待评价"),
    BS007("BS007", "待自提"),
    BS008("BS008", "已完成"),
    BS009("BS009", "已取消"),
    BS010("BS010", "退款中"),
    BS011("BS011", "已退款"),
    BS012("BS012", "退货中"),
    BS013("BS013", "已关闭");

    private String code;

    private String desc;

    OrderStatusEnums(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getDesc() {
        return this.desc;
    }
}
