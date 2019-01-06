package quick.pager.shop.manage.controller.activity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.io.IOException;
import java.io.InputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import quick.pager.common.constants.Constants;
import quick.pager.common.response.Response;
import quick.pager.shop.manage.dto.CouponDTO;
import quick.pager.shop.manage.dto.CouponTemplateDTO;
import quick.pager.shop.manage.request.CouponRequest;
import quick.pager.shop.manage.request.CouponTemplateRequest;
import quick.pager.shop.manage.service.activity.CouponService;
import quick.pager.shop.manage.service.activity.CouponTemplateService;

@Api(description = "优惠券")
@RestController
@RequestMapping(Constants.Module.MANAGE)
public class CouponController {

    @Autowired
    private CouponTemplateService couponTemplateService;
    @Autowired
    private CouponService couponService;

    @ApiOperation("发送优惠券")
    @PostMapping("/publish/coupon")
    public Response publishCoupon(MultipartFile file, Long templateId) {
        try {
            InputStream inputStream = file.getInputStream();
            System.out.println(templateId);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @ApiOperation("优惠券模板列表")
    @PostMapping("/activity/coupon/template")
    public Response template(CouponTemplateRequest request) {
        CouponTemplateDTO dto = new CouponTemplateDTO();
        dto.setTemplateName(request.getTemplateName());
        dto.setTemplateType(request.getTemplateType());
        dto.setPage(request.getPage());
        dto.setPageSize(request.getPageSize());
        dto.setEvent(Constants.Event.LIST);
        return couponTemplateService.doService(dto);
    }

    @ApiOperation("优惠券模板新增或删除")
    @PostMapping("/activity/coupon/template/modify")
    public Response modifyTemplate(CouponTemplateRequest request) {
        CouponTemplateDTO dto = new CouponTemplateDTO();
        dto.setId(request.getId());
        dto.setTemplateName(request.getTemplateName());
        dto.setTemplateType(request.getTemplateType());
        dto.setDiscountAmount(request.getDiscountAmount());
        dto.setOrderAmount(request.getOrderAmount());
        dto.setCreateUser(request.getCreateUser());
        dto.setDescription(request.getDescription());
        dto.setDeleteStatus(request.getDeleteStatus());
        dto.setEvent(request.getEvent());

        return couponTemplateService.doService(dto);
    }

    @ApiOperation("用户优惠券列表")
    @PostMapping("/activity/coupon/list")
    public Response coupons(CouponRequest request) {
        CouponDTO dto = new CouponDTO();
        dto.setCouponName(request.getCouponName());
        dto.setDiscountType(request.getDiscountType());
        dto.setBeginTime(request.getBeginTime());
        dto.setEndTime(request.getEndTime());
        dto.setPage(request.getPage());
        dto.setPageSize(request.getPageSize());
        dto.setEvent(request.getEvent());
        return couponService.doService(dto);
    }
}
