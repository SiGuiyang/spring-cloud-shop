package quick.pager.shop.platform.service;

import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;
import quick.pager.shop.platform.model.DynamicForm;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author siguiyang
 * @since 2019-12-14
 */
public interface DynamicFormService extends IService<DynamicForm> {

    /**
     * 根据bizType 获取自定义表单内容
     *
     * @param bizType 业务代码
     */
    List<DynamicForm> get(String bizType);
}
