package quick.pager.shop.manage.controller.activity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.common.constants.Constants;
import quick.pager.common.response.Response;

/**
 * 拼团管理
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(Constants.Module.MANAGE)
public class FightGroupManageController {

    @PostMapping("/activity/fightGroup/rule")
    public Response rule() {
        return null;
    }

    @PostMapping("/activity/fightGroup/goods")
    public Response goods() {
        return null;
    }
}
