package quick.pager.shop.service.system;

import java.util.List;
import quick.pager.shop.param.system.DynamicFormOtherSaveParam;
import quick.pager.shop.platform.response.DynamicFormResponse;
import quick.pager.shop.user.response.Response;

/**
 * 自定义表单
 *
 * @author siguiyang
 */
public interface DynamicFormService {

    /**
     * 创建表单
     */
    Response<Long> create(DynamicFormOtherSaveParam param);

    /**
     * 修改表单
     */
    Response<Long> modify(DynamicFormOtherSaveParam param);

    /**
     * 获取表单
     *
     * @param bizType 业务类型
     */
    Response<List<DynamicFormResponse>> get(String bizType);
}
