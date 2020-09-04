package quick.pager.shop.service;

import java.util.List;
import quick.pager.shop.model.DynamicForm;
import quick.pager.shop.platform.request.DynamicFormSaveRequest;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author siguiyang
 * @since 2019-12-14
 */
public interface DynamicFormService {

    /**
     * 根据bizType 获取自定义表单内容
     *
     * @param bizType 业务代码
     */
    List<DynamicForm> get(String bizType);

    /**
     * 新增
     */
    Long create(DynamicFormSaveRequest request);

    /**
     * 编辑
     */
    Long modify(DynamicFormSaveRequest request);
}
