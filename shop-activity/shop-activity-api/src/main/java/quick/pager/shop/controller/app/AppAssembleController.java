package quick.pager.shop.controller.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.user.response.Response;

/**
 * 拼团
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(ConstantsClient.ACTIVITY)
public class AppAssembleController {

    /**
     * 拼团活动列表
     */
    @GetMapping("/app/assemble/list")
    public Response list() {

        return null;
    }
}
