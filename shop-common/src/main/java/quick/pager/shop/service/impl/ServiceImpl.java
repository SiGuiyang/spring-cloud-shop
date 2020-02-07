package quick.pager.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import quick.pager.shop.service.IService;

public class ServiceImpl<M extends BaseMapper<T>, T> implements IService<T> {

    @Autowired
    protected M baseMapper;

    @Override
    public M getBaseMapper() {
        return baseMapper;
    }

    @Override
    public T getById(Serializable id) {
        return baseMapper.selectById(id);
    }

    @Override
    public T getOne(Wrapper<T> queryWrapper) {
        return baseMapper.selectOne(queryWrapper);
    }

    @Override
    public int count(Wrapper<T> queryWrapper) {
        Integer total = baseMapper.selectCount(queryWrapper);
        return null != total ? total : 0;
    }

    @Override
    public List<T> list(Wrapper<T> queryWrapper) {
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public IPage<T> page(IPage<T> page, Wrapper<T> queryWrapper) {
        return baseMapper.selectPage(page, queryWrapper);
    }
}
