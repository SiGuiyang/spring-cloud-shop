package quick.pager.shop.controller.document;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.response.Response;

/**
 * 文章管理
 */
@RestController
@RequestMapping(Constants.Module.MANAGE)
public class DocumentController {

    /**
     * 文章列表
     */
    @PostMapping("/document/list")
    public Response list() {
        return null;
    }

    /**
     * 文章修改
     */
    @PostMapping("/document/modify")
    public Response modify() {
        return null;
    }
}
