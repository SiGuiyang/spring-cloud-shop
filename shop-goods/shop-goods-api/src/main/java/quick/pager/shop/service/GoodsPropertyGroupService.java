package quick.pager.shop.service;

import java.util.List;
import quick.pager.shop.model.GoodsPropertyGroup;
import quick.pager.shop.goods.request.property.group.GoodsPropertyGroupOtherRequest;
import quick.pager.shop.goods.request.property.group.GoodsPropertyGroupPageRequest;
import quick.pager.shop.goods.request.property.group.GoodsPropertyGroupSaveRequest;
import quick.pager.shop.goods.response.property.group.GoodsPropertyGroupResponse;
import quick.pager.shop.user.response.Response;

/**
 * <p>
 * 商品属性组 服务类
 * </p>
 *
 * @author Siguiyang
 * @since 2019-10-07
 */
public interface GoodsPropertyGroupService extends IService<GoodsPropertyGroup> {

    /**
     * 分页查询
     *
     * @param request 请求参数
     * @return 数据响应
     */
    Response<List<GoodsPropertyGroupResponse>> queryPage(GoodsPropertyGroupPageRequest request);

    /**
     * 属性组列表
     *
     * @param request 请求参数
     * @return 数据响应
     */
    Response<List<GoodsPropertyGroupResponse>> queryList(GoodsPropertyGroupOtherRequest request);

    /**
     * 新增
     *
     * @param request 请求参数
     * @return 数据响应
     */
    Response<Long> create(GoodsPropertyGroupSaveRequest request);

    /**
     * 修改
     *
     * @param request 请求参数
     * @return 数据响应
     */
    Response<Long> modify(GoodsPropertyGroupSaveRequest request);

}
