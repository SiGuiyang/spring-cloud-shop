package quick.pager.shop.platform.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import org.springframework.stereotype.Service;
import quick.pager.shop.platform.mapper.DynamicFormMapper;
import quick.pager.shop.platform.model.DynamicForm;
import quick.pager.shop.platform.service.DynamicFormService;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author siguiyang
 * @since 2019-12-14
 */
@Service
public class DynamicFormServiceImpl extends ServiceImpl<DynamicFormMapper, DynamicForm> implements DynamicFormService {

    @Override
    public List<DynamicForm> get(String bizType) {
        DynamicForm df = new DynamicForm();
        df.setBizType(bizType);
        QueryWrapper<DynamicForm> qw = new QueryWrapper<>(df);

        return this.baseMapper.selectList(qw);
    }
}
