package quick.pager.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.List;
import org.springframework.stereotype.Service;
import quick.pager.shop.mapper.DynamicFormMapper;
import quick.pager.shop.model.DynamicForm;
import quick.pager.shop.platform.request.DynamicFormSaveRequest;
import quick.pager.shop.service.DynamicFormService;
import quick.pager.shop.utils.BeanCopier;

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
        return this.baseMapper.selectList(new QueryWrapper<>(df));
    }

    @Override
    public Long create(DynamicFormSaveRequest request) {
        DynamicForm df = new DynamicForm();
        BeanCopier.create(request, df).copy();
        this.baseMapper.insert(df);
        return df.getId();
    }

    @Override
    public Long modify(DynamicFormSaveRequest request) {
        DynamicForm df = new DynamicForm();
        BeanCopier.create(request, df).copy();
        this.baseMapper.updateById(df);
        return df.getId();
    }
}
