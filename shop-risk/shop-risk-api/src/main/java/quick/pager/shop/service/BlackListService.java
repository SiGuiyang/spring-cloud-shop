package quick.pager.shop.service;

import quick.pager.shop.user.response.Response;

/**
 * @author siguiyang
 */

public interface BlackListService {

    Response create();

    Response modify();

    Response queryList();

    Response queryPage();


}
