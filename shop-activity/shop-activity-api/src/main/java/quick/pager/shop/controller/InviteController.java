package quick.pager.shop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.user.response.Response;

/**
 * 好友邀请
 */
@RestController
@RequestMapping(ConstantsClient.ACTIVITY)
public class InviteController {

    @GetMapping("/testJob")
    public Response<String> testJob() {

        return Response.toResponse("Hello World");
    }
}
