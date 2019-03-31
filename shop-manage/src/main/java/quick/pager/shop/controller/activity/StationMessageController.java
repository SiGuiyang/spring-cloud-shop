package quick.pager.shop.controller.activity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.request.ManageRequest;
import quick.pager.shop.response.Response;
import quick.pager.shop.client.UserClient;
import quick.pager.shop.model.StationLetter;

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
