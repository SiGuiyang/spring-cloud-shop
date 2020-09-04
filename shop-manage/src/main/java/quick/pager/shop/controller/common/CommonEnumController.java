package quick.pager.shop.controller.common;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.service.CommonEnumService;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.response.EnumResponse;

/**
 * 常量枚举
 */
@RestController
@RequestMapping(Constants.Module.MANAGE)
public class CommonEnumController {

    @Autowired
    private CommonEnumService commonEnumService;

    @PostMapping("/common/enumInfo")
    public Response<Map<String, List<EnumResponse>>> commonEnumInfo() {
        return commonEnumService.getCommonEnumInfo();
    }
}
