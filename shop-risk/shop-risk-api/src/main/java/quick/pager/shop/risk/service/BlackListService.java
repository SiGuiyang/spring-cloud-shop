package quick.pager.shop.risk.service;

import quick.pager.shop.response.Response;

/**
 * @author siguiyang
 */

public interface BlackListService {

    Response create();

    Response modify();

    Response queryList();

    Response queryPage();


}
