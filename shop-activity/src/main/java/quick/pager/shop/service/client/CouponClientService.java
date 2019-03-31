package quick.pager.shop.service.client;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
import quick.pager.shop.dto.CouponDTO;
import quick.pager.shop.model.DiscountCoupon;

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
        Response response = new Response();

        switch (couponDTO.getEvent()) {
            case Constants.Event.MODIFY:
                break;
            case Constants.Event.LIST:
                response = queryCoupons(couponDTO);
                break;
            default:
                response = new Response<>(ResponseStatus.Code.FAIL_CODE, ResponseStatus.PARAMS_EXCEPTION);
        }

        return response;
    }

    /**
     * 查询用户优惠券列表
     */
    private Response<List<DiscountCoupon>> queryCoupons(CouponDTO couponDTO) {

        PageHelper.startPage(couponDTO.getPage(), couponDTO.getPageSize());
        List<DiscountCoupon> discountCoupons = discountCouponMapper.selectCoupons(couponDTO);

        PageInfo<DiscountCoupon> pageInfo = new PageInfo<>(discountCoupons);

        Response<List<DiscountCoupon>> listResponse = new Response<>();
        listResponse.setData(pageInfo.getList());
        listResponse.setTotal(pageInfo.getTotal());

        return listResponse;
    }
}
