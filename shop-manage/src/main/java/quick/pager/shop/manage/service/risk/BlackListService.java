package quick.pager.shop.manage.service.risk;

import quick.pager.shop.manage.param.risk.BlackListPageParam;
import quick.pager.shop.manage.param.risk.BlackListSaveParam;
import quick.pager.shop.response.Response;

public interface BlackListService {

    Response queryPage(BlackListPageParam dto);

    Response create(BlackListSaveParam dto);

    Response modify(BlackListSaveParam dto);

    Response delBlackLists(Long id);
}
