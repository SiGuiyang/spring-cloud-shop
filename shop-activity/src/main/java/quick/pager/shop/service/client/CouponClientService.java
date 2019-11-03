package quick.pager.shop.service.client;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.dto.BaseDTO;
import quick.pager.shop.mapper.DiscountCouponMapper;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.IService;
import quick.pager.shop.dto.activity.CouponDTO;
import quick.pager.shop.model.activity.DiscountCoupon;

/**
 * 用户优惠券服务
 */
@Service
@Slf4j
public class CouponClientService implements IService {

    @Autowired
    private DiscountCouponMapper discountCouponMapper;

    @Override
    public Response doService(BaseDTO dto) {

        CouponDTO couponDTO = (CouponDTO) dto;
        Response response;

        if (Constants.Event.LIST.equals(couponDTO.getEvent())) {
            response = queryCoupons(couponDTO);
        } else {
            response = new Response<>(ResponseStatus.Code.FAIL_CODE, ResponseStatus.PARAMS_EXCEPTION);
        }

        return response;
    }

    /**
     * 查询用户优惠券列表
     */
    private Response<List<DiscountCoupon>> queryCoupons(CouponDTO couponDTO) {

        List<DiscountCoupon> discountCoupons = discountCouponMapper.selectCoupons(couponDTO);


        QueryWrapper<DiscountCoupon> discountCouponQueryWrapper = new QueryWrapper<>();

        return Response.toResponse(discountCouponMapper.selectPage(new Page<>(couponDTO.getPage(), couponDTO.getPageSize()), discountCouponQueryWrapper));
    }
}
