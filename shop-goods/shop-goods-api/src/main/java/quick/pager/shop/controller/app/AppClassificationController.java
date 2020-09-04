package quick.pager.shop.controller.app;


import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.param.AppClassificationParam;
import quick.pager.shop.goods.response.classification.AppGoodsClassificationResponse;
import quick.pager.shop.service.AppClassificationService;
import quick.pager.shop.user.response.CommonResponse;
import quick.pager.shop.user.response.Response;

/**
 * 商品分类
 *
 * @author siguiyang
 * @version 3.0
 */
@RestController
@RequestMapping(Constants.Module.GOODS)
public class AppClassificationController {

    @Autowired
    private AppClassificationService appClassificationService;

    /**
     * App 商品分类列表
     */
    @GetMapping("/app/goods/classifications")
    public Response<List<CommonResponse>> classifications() {

        return appClassificationService.classifications();
    }

    /**
     * 分类对应的详情
     *
     * @param param 请求参数
     */
    @PostMapping("/app/goods/classifications/detail")
    public Response<AppGoodsClassificationResponse> detail(@RequestBody AppClassificationParam param) {

        if (Objects.isNull(param.getClassificationId())) {
            return new Response<>(ResponseStatus.Code.FAIL_CODE, "分类不存在");
        }

        return appClassificationService.detail(param.getClassificationId());
    }
}
