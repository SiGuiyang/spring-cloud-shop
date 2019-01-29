package quick.pager.shop.feign.fallback;

import feign.hystrix.FallbackFactory;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import quick.pager.common.constants.ResponseStatus;
import quick.pager.common.response.Response;
import quick.pager.shop.feign.client.GoodsClient;
import quick.pager.shop.feign.request.ClassificationRequest;
import quick.pager.shop.feign.request.GoodsRequest;
import quick.pager.shop.feign.response.GoodsResponse;
import quick.pager.shop.model.goods.Goods;

/**
 * 商品模块熔断工厂
 *
 * @author siguiyang
 */
@Slf4j
@Component
public class GoodsClientFallbackFactory implements FallbackFactory<GoodsClient> {
    @Override
    public GoodsClient create(Throwable cause) {
        log.error("GoodsClient 进入熔断错误异常信息 msg = {}", cause.getMessage());
        return new GoodsClient() {
            @Override
            public Response<List<Goods>> queryGoodsList(GoodsRequest request) {
                log.error("进入熔断措施 GoodsClient.queryGoodsList");
                return new Response<>(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.TELNET_EXCEPTION);
            }

            @Override
            public Response<String> modifyGoods(GoodsRequest request) {
                log.error("进入熔断措施 GoodsClient.modifyGoods");
                return new Response<>(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.TELNET_EXCEPTION);
            }

            @Override
            public Response<GoodsResponse> goodsInfo(Long goodsId) {
                log.error("进入熔断措施 GoodsClient.goodsInfo");
                return new Response<>(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.TELNET_EXCEPTION);
            }

            @Override
            public Response goodsClassList(String className) {
                log.error("进入熔断措施 GoodsClient.goodsClassList");
                return new Response<>(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.TELNET_EXCEPTION);
            }

            @Override
            public Response modifyGoodsClass(ClassificationRequest request) {
                log.error("进入熔断措施 GoodsClient.modifyGoodsClass");
                return new Response<>(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.TELNET_EXCEPTION);
            }

            @Override
            public Response<List<GoodsResponse>> queryBuyerOrderGoods(Long buyerOrderCartId) {
                log.error("进入熔断措施 GoodsClient.queryBuyerOrderGoods");
                return new Response<>(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.TELNET_EXCEPTION);
            }
        };
    }
}
