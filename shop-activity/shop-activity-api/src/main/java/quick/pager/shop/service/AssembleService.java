package quick.pager.shop.service;

import java.util.List;
import quick.pager.shop.activity.request.assemble.AssembleMemberPageRequest;
import quick.pager.shop.activity.request.assemble.AssemblePageRequest;
import quick.pager.shop.activity.request.assemble.AssembleSaveRequest;
import quick.pager.shop.activity.response.assemble.AssembleMemberResponse;
import quick.pager.shop.activity.response.assemble.AssembleActivityResponse;
import quick.pager.shop.user.response.Response;

/**
 * 拼团活动
 *
 * @author siguiyang
 */
public interface AssembleService {

    /**
     * 设置拼团商品
     */
//    Response assembleGoods(AssemblePageRequest request);

    /**
     * 参与拼团成员
     *
     * @param request 请求参数
     * @return 拼团参与人员
     */
    Response<List<AssembleMemberResponse>> members(AssembleMemberPageRequest request);
}
