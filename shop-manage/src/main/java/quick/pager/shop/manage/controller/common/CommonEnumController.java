package quick.pager.shop.manage.controller.common;

import io.swagger.annotations.Api;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.common.constants.Constants;
import quick.pager.common.response.Response;
import quick.pager.shop.manage.response.EnumResponse;
import quick.pager.shop.manage.service.CommonEnumService;

@Api(description = "常量枚举")
@RestController
@RequestMapping(Constants.Module.MANAGE)
public class CommonEnumController {

    @Autowired
    private CommonEnumService commonEnumService;

    @PostMapping("/common/enumInfo")
    public Response<List<EnumResponse>> commonEnumInfo(@RequestParam String type) {
        return commonEnumService.getCommonEnumInfo(type);
    }
}
