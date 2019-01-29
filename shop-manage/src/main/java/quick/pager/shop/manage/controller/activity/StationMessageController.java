package quick.pager.shop.manage.controller.activity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.common.constants.Constants;
import quick.pager.common.request.ManageRequest;
import quick.pager.common.response.Response;
import quick.pager.shop.feign.client.UserClient;
import quick.pager.shop.model.user.StationLetter;

/**
 * 站内信管理
 *
 * @author siguiyang
 */
@Api(description = "站内信管理")
@RestController
@RequestMapping(Constants.Module.MANAGE)
@Slf4j
public class StationMessageController {

    @Autowired
    private UserClient userClient;

    @ApiOperation("站内信列表")
    @PostMapping("/activity/station/list")
    public Response<List<StationLetter>> list(ManageRequest request) {

        return userClient.queryStationLetter(request);
    }

}
