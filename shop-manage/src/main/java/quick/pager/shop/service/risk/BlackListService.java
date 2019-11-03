package quick.pager.shop.service.risk;

import quick.pager.shop.dto.risk.BlackListDTO;
import quick.pager.shop.response.Response;

public interface BlackListService {

    Response getBlackLists(BlackListDTO dto);

    Response addBlackLists(BlackListDTO dto);

    Response modifyBlackLists(BlackListDTO dto);

    Response delBlackLists(Long id);
}
