package quick.pager.shop.manage.service.risk.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.manage.param.risk.BlackListPageParam;
import quick.pager.shop.manage.param.risk.BlackListSaveParam;
import quick.pager.shop.risk.client.RiskClient;
import quick.pager.shop.response.Response;
import quick.pager.shop.manage.service.risk.BlackListService;

@Service
public class BlackListServiceImpl implements BlackListService {

    @Autowired
    private RiskClient riskClient;

    @Override
    public Response queryPage(BlackListPageParam dto) {
//        return riskClient.getBlackLists(param);
        return null;
    }

    @Override
    public Response create(BlackListSaveParam dto) {
//        return riskClient.addBlackLists(param);
        return null;
    }

    @Override
    public Response modify(BlackListSaveParam dto) {
//        return riskClient.modifyBlackLists(param);
        return null;
    }

    @Override
    public Response delBlackLists(Long id) {
//        return riskClient.delBlackLists(id);
        return null;
    }
}
