package quick.pager.shop.fallback;

import feign.hystrix.FallbackFactory;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.dto.ClassificationDTO;
import quick.pager.shop.dto.GoodsDTO;
import quick.pager.shop.response.GoodsResponse;
import quick.pager.shop.response.Response;
import quick.pager.shop.client.GoodsClient;
import quick.pager.shop.model.Goods;

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
            public Response<List<Goods>> queryGoodsList(GoodsDTO request) {
                log.error("进入熔断措施 GoodsClient.queryGoodsList");
                return new Response<>(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.TELNET_EXCEPTION);
            }

            @Override
            public Response<String> addGoods(GoodsDTO request) {
                log.error("进入熔断措施 GoodsClient.addGoods");
                return new Response<>(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.TELNET_EXCEPTION);
            }

            @Override
            public Response<String> modifyGoods(GoodsDTO request) {
                log.error("进入熔断措施 GoodsClient.modifyGoods");
                return new Response<>(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.TELNET_EXCEPTION);
            }

            @Override
            public Response<GoodsResponse> goodsInfo(Long goodsId) {
                log.error("进入熔断措施 GoodsClient.goodsInfo");
                return new Response<>(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.TELNET_EXCEPTION);
            }

            @Override
            public Response classificationList(String className) {
                log.error("进入熔断措施 GoodsClient.goodsClassList");
                return new Response<>(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.TELNET_EXCEPTION);
            }

            @Override
            public Response modifyClassification(ClassificationDTO dto) {
                log.error("进入熔断措施 GoodsClient.modifyGoodsClass");
                return new Response<>(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.TELNET_EXCEPTION);
            }

            @Override
            public Response<List<GoodsResponse>> queryBuyerOrderGoods(Long buyerOrderCartId) {
                log.error("进入熔断措施 GoodsClient.queryBuyerOrderGoods");
                return new Response<>(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.TELNET_EXCEPTION);
            }

            @Override
            public Response goodsCarts(Long userId) {
                return new Response<>(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.TELNET_EXCEPTION);
            }

            @Override
            public Response modifyGoodsCart(Long userId, Long[] goodsIds, Integer goodsCount, String event) {
                return new Response<>(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.TELNET_EXCEPTION);
            }
        };
    }
}
