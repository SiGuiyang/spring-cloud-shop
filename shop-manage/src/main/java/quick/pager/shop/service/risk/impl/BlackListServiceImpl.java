package quick.pager.shop.service.risk.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.client.RiskClient;
import quick.pager.shop.dto.BlackListDTO;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.risk.BlackListService;

@Service
public class BlackListServiceImpl implements BlackListService {

    @Autowired
    private RiskClient riskClient;

    @Override
    public Response getBlackLists(BlackListDTO dto) {
        return null;
    }

    @Override
    public Response addBlackLists(BlackListDTO dto) {
        return null;
    }

    @Override
    public Response modifyBlackLists(BlackListDTO dto) {
        return null;
    }

    @Override
    public Response delBlackLists(Long id) {
        return null;
    }
}
