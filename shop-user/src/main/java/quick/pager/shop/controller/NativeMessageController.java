package quick.pager.shop.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.response.Response;
import quick.pager.shop.dto.StationMessageDTO;

/**
 * 站内消息
 *
 * @author siguiyang
 */
@Api(description = "站内消息")
@RestController
@RequestMapping(Constants.Module.USER)
public class NativeMessageController {


    @PostMapping("/message/{userId}")
    @ApiOperation("站内消息列表")
    public Response message(@PathVariable("userId") Long userId) {
        return null;
    }


    @PostMapping("/message/modify")
    @ApiOperation("站内消息操作 删除 已读")
    public Response modifyMessage(StationMessageDTO dto) {
        return null;
    }
}
