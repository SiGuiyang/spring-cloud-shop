package quick.pager.shop.controller.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.user.response.Response;

/**
 * 满赠换购
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(ConstantsClient.ACTIVITY)
public class AppExchangeController {

    /**
     * 满赠换购活动列表
     *
     * @return
     */
    @GetMapping("/app/exchange/list")
    public Response list() {

        return null;
    }
}
