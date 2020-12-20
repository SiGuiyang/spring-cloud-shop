package quick.pager.shop.service;

import java.util.List;
import quick.pager.shop.model.BlackList;
import quick.pager.shop.risk.request.WhiteBlacklistPageRequest;
import quick.pager.shop.risk.request.WhiteBlacklistSaveRequest;
import quick.pager.shop.risk.response.WhiteBlacklistResponse;
import quick.pager.shop.user.response.Response;

/**
 * 黑名单服务
 *
 * @author siguiyang
 */
public interface BlacklistService extends IService<BlackList> {

    /**
     * 分页列表
     *
     * @param request 请求参数
     * @return 黑名单列表
     */
    Response<List<WhiteBlacklistResponse>> queryPage(final WhiteBlacklistPageRequest request);

    /**
     * 黑名单集
     *
     * @return 主键
     */
    Response<List<String>> queryList();

    /**
     * 新增黑名单
     *
     * @return 主键
     */
    Response<Long> create(final WhiteBlacklistSaveRequest request);

    /**
     * 修改黑名单
     *
     * @return 主键
     */
    Response<Long> modify(final WhiteBlacklistSaveRequest request);

    /**
     * 移除黑名单
     *
     * @param id 主键
     * @return 主键
     */
    Response<Long> delete(final Long id);
}
