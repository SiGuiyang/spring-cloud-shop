package quick.pager.shop.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import quick.pager.shop.dto.CouponDTO;
import quick.pager.shop.model.DiscountCoupon;

public interface DiscountCouponMapper {

    int insertSelective(DiscountCoupon record);

    DiscountCoupon selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DiscountCoupon record);

    /**
     * 根据id批量获取优惠券
     *
     * @param ids
     */
    List<DiscountCoupon> selectBatchByPrimaryKey(List<Long> ids);

    /**
     * 批量插入优惠券
     */
    int batchInsertSelective(List<DiscountCoupon> records);

    /**
     * 查询用户优惠券列表<br />
     * 只选择最近一个月的数据
     */
    List<DiscountCoupon> selectCoupons(CouponDTO dto);

    /**
     * 查询用户近一个月内的优惠券
     *
     * @param userId 用户Id
     */
    List<DiscountCoupon> selectCouponsByUserId(@Param("userId") Long userId,
                                               @Param("page") Integer page,
                                               @Param("pageSize") Integer pageSize);
}