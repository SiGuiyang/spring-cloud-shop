package quick.pager.shop.manage.service.activity;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.Date;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.common.constants.Constants;
import quick.pager.common.dto.DTO;
import quick.pager.common.response.Response;
import quick.pager.common.service.IService;
import quick.pager.shop.manage.dto.CouponTemplateDTO;
import quick.pager.shop.manage.mapper.DiscountCouponTemplateMapper;
import quick.pager.shop.model.activity.DiscountCouponTemplate;

/**
 * 优惠券模板服务
 *
 * @author siguiyang
 */
@Service
@Slf4j
public class CouponTemplateService implements IService {

    @Autowired
    private DiscountCouponTemplateMapper discountCouponTemplateMapper;

    @Override
    public Response doService(DTO dto) {

        CouponTemplateDTO couponTemplateDTO = (CouponTemplateDTO) dto;
        Response response = new Response();
        switch (couponTemplateDTO.getEvent()) {
            case Constants.Event.ADD:
            case Constants.Event.MODIFY:
                response = modifyDiscountCouponTemplate(couponTemplateDTO);
                break;
            case Constants.Event.LIST:
                response = queryDiscountCouponTemplate(couponTemplateDTO);

        }
        return response;
    }

    /**
     * 查询列表
     */
    private Response queryDiscountCouponTemplate(CouponTemplateDTO couponTemplateDTO) {

        PageHelper.startPage(couponTemplateDTO.getPage(), couponTemplateDTO.getPageSize());
        List<DiscountCouponTemplate> discountCouponTemplates = discountCouponTemplateMapper.selectTemplates(couponTemplateDTO.getTemplateName(),
                couponTemplateDTO.getTemplateType());
        PageInfo<DiscountCouponTemplate> pageInfo = new PageInfo<>(discountCouponTemplates);
        Response<List<DiscountCouponTemplate>> response = new Response<>();

        response.setTotal(pageInfo.getTotal());
        response.setData(pageInfo.getList());

        return response;
    }

    /**
     * 新增或者修改
     */
    private Response modifyDiscountCouponTemplate(CouponTemplateDTO couponTemplateDTO) {
        DiscountCouponTemplate template = new DiscountCouponTemplate();
        BeanUtils.copyProperties(couponTemplateDTO, template);

        if (Constants.Event.ADD.equals(couponTemplateDTO.getEvent())) {
            template.setCreateTime(new Date());
            discountCouponTemplateMapper.insertSelective(template);
        } else {
            discountCouponTemplateMapper.updateByPrimaryKeySelective(template);
        }
        return new Response();
    }
}
