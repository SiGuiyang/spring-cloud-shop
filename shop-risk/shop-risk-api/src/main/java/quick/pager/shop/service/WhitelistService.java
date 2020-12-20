package quick.pager.shop.service;

import java.util.List;
import quick.pager.shop.model.Whitelist;
import quick.pager.shop.risk.request.WhiteBlacklistPageRequest;
import quick.pager.shop.risk.request.WhiteBlacklistSaveRequest;
import quick.pager.shop.risk.response.WhiteBlacklistResponse;
import quick.pager.shop.user.response.Response;

/**
 * 白名单服务
 *
 * @author siguiyang
 */
public interface WhitelistService extends IService<Whitelist> {

    /**
     * 分页列表
     *
     * @param request 请求参数
     * @return 白名单列表
     */
    Response<List<WhiteBlacklistResponse>> queryPage(final WhiteBlacklistPageRequest request);

    /**
     * 白名单集
     *
     * @return 主键
     */
    Response<List<String>> queryList();

    /**
     * 新增白名单
     *
     * @return 主键
     */
    Response<Long> create(final WhiteBlacklistSaveRequest request);

    /**
     * 修改白名单
     *
     * @return 主键
     */
    Response<Long> modify(final WhiteBlacklistSaveRequest request);

    /**
     * 移除白名单
     *
     * @param id 主键
     * @return 主键
     */
    Response<Long> delete(final Long id);
}
