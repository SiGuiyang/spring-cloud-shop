package quick.pager.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import quick.pager.shop.dto.activity.ExchangeActivityDTO;
import quick.pager.shop.mapper.ExchangeActivityMapper;
import quick.pager.shop.model.activity.ExchangeActivity;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.ExchangeService;
import quick.pager.shop.utils.BeanCopier;
import quick.pager.shop.utils.CopyOptions;
import quick.pager.shop.utils.DateUtils;

@Service
public class ExchangeServiceImpl extends ServiceImpl<ExchangeActivityMapper, ExchangeActivity> implements ExchangeService {


    @Override
    public Response<ExchangeActivity> exchangeInfo(Long activityId) {
        return new Response<>(this.baseMapper.selectById(activityId));
    }

    @Override
    public Response<List<ExchangeActivity>> exchangeActivityList(ExchangeActivityDTO dto) {

        QueryWrapper<ExchangeActivity> qw = new QueryWrapper<>();
        if (!StringUtils.isEmpty(dto.getActivityName())) {

            qw.eq("activity_name", dto.getActivityName());
        }
        return this.toPage(dto.getPage(), dto.getPageSize(), qw);
    }

    @Override
    public Response createOrModifyExchange(ExchangeActivityDTO dto) {

        ExchangeActivity exchangeActivity = BeanCopier.create(dto, new ExchangeActivity(), CopyOptions.create().setIgnoreError(true).setIgnoreNullValue(true))
                .copy();

        if (!CollectionUtils.isEmpty(dto.getTimeRange())) {
            exchangeActivity.setBeginTime(DateUtils.parseDateTime(dto.getTimeRange().get(0)));
            exchangeActivity.setEndTime(DateUtils.parseDateTime(dto.getTimeRange().get(1)));
        }

        if (null == dto.getId()) {
            exchangeActivity.setDeleteStatus(false);
            exchangeActivity.setCreateTime(DateUtils.now());
            this.baseMapper.insert(exchangeActivity);
        } else {
            this.baseMapper.updateById(exchangeActivity);
        }
        return new Response();
    }
}
