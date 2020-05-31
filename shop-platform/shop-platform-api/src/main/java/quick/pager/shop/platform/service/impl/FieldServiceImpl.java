package quick.pager.shop.platform.service.impl;

import org.springframework.stereotype.Service;
import quick.pager.shop.platform.mapper.FieldMapper;
import quick.pager.shop.platform.model.Field;
import quick.pager.shop.platform.service.FieldService;
import quick.pager.shop.service.impl.ServiceImpl;

/**
 * @author siguiyang
 */
@Service
public class FieldServiceImpl extends ServiceImpl<FieldMapper, Field> implements FieldService {
}
