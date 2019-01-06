package quick.pager.shop.manage.controller.document;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.common.constants.Constants;
import quick.pager.common.response.Response;

@Api(description = "文章管理")
@RestController
@RequestMapping(Constants.Module.MANAGE)
public class DocumentController {

    @ApiOperation("文章列表")
    @PostMapping("/document/list")
    public Response list() {
        return null;
    }

    @ApiOperation("文章修改")
    @PostMapping("/document/modify")
    public Response modify() {
        return null;
    }
}
