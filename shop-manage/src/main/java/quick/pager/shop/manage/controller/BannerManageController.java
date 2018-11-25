package quick.pager.shop.manage.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.common.response.Response;

/**
 * banner 管理
 *
 * @author siguiyang
 */
@RestController
public class BannerManageController {

    /**
     * banner 列表
     */
    @RequestMapping("/admin/banner/list")
    public Response list() {
        return null;
    }

    /**
     * banner 新增|修改|删除
     */
    @RequestMapping("/admin/banner/modify")
    public Response modify() {
        return null;
    }
}
