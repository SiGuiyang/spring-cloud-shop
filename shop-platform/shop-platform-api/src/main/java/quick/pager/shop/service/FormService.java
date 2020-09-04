package quick.pager.shop.service;

import java.util.List;
import quick.pager.shop.model.Form;
import quick.pager.shop.platform.request.form.FormOtherRequest;
import quick.pager.shop.platform.request.form.FormPageRequest;
import quick.pager.shop.platform.request.form.FormSaveRequest;
import quick.pager.shop.platform.response.FieldResponse;
import quick.pager.shop.platform.response.FormResponse;
import quick.pager.shop.user.response.Response;

/**
 * 表单服务
 *
 * @author siguiyang
 */
public interface FormService extends IService<Form> {

    /**
     * 创建
     *
     * @param request 请求参数
     * @return 主键
     */
    Response<Long> create(FormSaveRequest request);

    /**
     * 更新
     *
     * @param request 请求参数
     * @return 主键
     */
    Response<Long> modify(FormSaveRequest request);

    /**
     * 模型列表分页
     *
     * @param request 请求参数
     * @return 主键
     */
    Response<List<FormResponse>> queryPage(FormPageRequest request);

    /**
     * 模型列表
     *
     * @param request 请求参数
     * @return 模型列表
     */
    Response<List<FormResponse>> queryList(FormOtherRequest request);

    /**
     * 根据表单模型查询字段
     *
     * @param bizType 表单模型
     * @return 字段列表
     */
    List<FieldResponse> get(String bizType);
}
