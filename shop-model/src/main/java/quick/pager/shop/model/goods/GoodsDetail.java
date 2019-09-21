package quick.pager.shop.model.goods;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.model.Model;

@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsDetail extends Model {
    private static final long serialVersionUID = 4774603647596393848L;

    private Long goodsId;
    // 描述
    private String description;
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
