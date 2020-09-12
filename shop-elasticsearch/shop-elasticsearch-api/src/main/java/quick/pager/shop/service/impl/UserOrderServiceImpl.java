package quick.pager.shop.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import quick.pager.shop.elasticsearch.field.UserOrderField;
import quick.pager.shop.elasticsearch.request.ESUserOrderPageRequest;
import quick.pager.shop.elasticsearch.response.ESUserOrderResponse;
import quick.pager.shop.model.ESUserOrder;
import quick.pager.shop.repository.UserOrderRepository;
import quick.pager.shop.service.UserOrderService;
import quick.pager.shop.user.response.Response;

/**
 * 用户订单es实现
 *
 * @author siguiyang
 */
@Service
public class UserOrderServiceImpl implements UserOrderService {

    @Autowired
    private UserOrderRepository userOrderRepository;

    @Override
    public Response<List<ESUserOrderResponse>> queryPage(final ESUserOrderPageRequest request) {

        final PageRequest pageRequest = PageRequest.of(request.getPage(), request.getPageSize(), Sort.by(Sort.Direction.DESC, "updateTime"));

        //创建查询条件
        BoolQueryBuilder builder = QueryBuilders.boolQuery();

        // 用户主键
        if (Objects.nonNull(request.getUserId())) {
            builder.must(QueryBuilders.matchPhraseQuery(UserOrderField.USER_ID_KEY, request.getUserId()));
        }
        // 订单主键
        if (Objects.nonNull(request.getOrderId())) {
            builder.must(QueryBuilders.matchPhraseQuery(UserOrderField.ORDER_ID_KEY, request.getOrderId()));
        }
        // 订单类型
        if (Objects.nonNull(request.getOrderType())) {
            builder.must(QueryBuilders.matchPhraseQuery(UserOrderField.ORDER_TYPE_KEY, request.getOrderType()));
        }
        // 订单编号
        if (StringUtils.isNotBlank(request.getOrderCode())) {
            builder.should(QueryBuilders.matchPhraseQuery(UserOrderField.ORDER_CODE_KEY, request.getOrderCode()));
        }
        // 订单状态
        if (StringUtils.isNotBlank(request.getOrderStatus())) {
            builder.must(QueryBuilders.matchPhraseQuery(UserOrderField.ORDER_STATUS_KEY, request.getOrderCode()));
        }
        // 下单时间范围查询
        if (Objects.nonNull(request.getBeginTime()) && Objects.nonNull(request.getEndTime())) {
            builder.filter(QueryBuilders.rangeQuery(UserOrderField.ORDER_TIME_KEY).from(request.getBeginTime()).to(request.getEndTime()));
        }

        Page<ESUserOrder> page = userOrderRepository.search(builder, pageRequest);

        return Response.toResponse(page.getContent().stream().map(this::conv).collect(Collectors.toList()), page.getTotalElements());
    }

    private ESUserOrderResponse conv(ESUserOrder order) {
        ESUserOrderResponse resp = new ESUserOrderResponse();
        return resp;
    }
}
