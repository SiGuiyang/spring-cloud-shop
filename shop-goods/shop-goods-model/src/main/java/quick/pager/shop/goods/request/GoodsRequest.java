package quick.pager.shop.goods.request;

import java.math.BigDecimal;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.request.Request;

@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsRequest extends Request {
    private static final long serialVersionUID = 675509028031796700L;

    private Long goodsDetailId;
    // 活动的Id
    private Long activityId;

    private Long gcsId;

    private String goodsName;

    private String goodsCode;

    private Integer goodsStatus;

    private Integer goodsType;

    private BigDecimal goodsAmount;

    private BigDecimal goodsDiscountAmount;

    private String description;

    private Integer integral;

    private Integer goodsInventory;
    // 产地
    private String placeOrigin;
    // 储存
    private String storage;
    // 商品小图
    private String goodsImg;
    // 商品详情banner 图片一
    private String bannerFirst;
    // 商品详情banner 图片二
    private String bannerSecond;
    // 商品详情banner 图片三
    private String bannerThird;
    // 商品详情图片 一
    private String detailsImgFirst;
    // 商品详情图片 二
    private String detailsImgSecond;
    // 商品详情图片 三
    private String detailsImgThird;
    // 商品详情图片 四
    private String detailsImgFourth;
    // 商品详情图片 五
    private String detailsImgFifth;
}
