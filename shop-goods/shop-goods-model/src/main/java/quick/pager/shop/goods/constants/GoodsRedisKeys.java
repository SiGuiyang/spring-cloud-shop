package quick.pager.shop.goods.constants;

/**
 * 商品中心redis key 配置
 *
 * @author siguiyang
 */
public interface GoodsRedisKeys {

    /**
     * redis spu 缓存
     */
    String REDIS_SPU_PREFIX = "redis:app:spu";
    /**
     * redis 分类缓存
     */
    String REDIS_CLASSIFICATION_PREFIX = "redis:app:classification";
}
