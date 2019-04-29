package quick.pager.shop.service.client;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.Date;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.dto.BaseDTO;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.IService;
import quick.pager.shop.mapper.BannerMapper;
import quick.pager.shop.dto.BannerDTO;
import quick.pager.shop.model.Banner;

@Service
@Slf4j
public class BannerClientService implements IService {

    @Autowired
    private BannerMapper bannerMapper;

    @Override
    public Response doService(BaseDTO dto) {

        BannerDTO bannerDTO = (BannerDTO) dto;
        Response response = new Response();

        switch (bannerDTO.getEvent()) {
            case Constants.Event.ADD:
            case Constants.Event.MODIFY:
                modifyBanner(bannerDTO);
                break;
            case Constants.Event.LIST:
                response = queryBanners(bannerDTO);
                break;
            default:
                response = new Response<>(ResponseStatus.Code.FAIL_CODE, ResponseStatus.PARAMS_EXCEPTION);
        }

        return response;
    }

    /**
     * 查询列表
     */
    private Response queryBanners(BannerDTO bannerDTO) {
        Response<List<Banner>> response = new Response<>();

        PageHelper.startPage(bannerDTO.getPage(), bannerDTO.getPageSize());
        List<Banner> banners = bannerMapper.selectBanner(bannerDTO.getTitle(), bannerDTO.getBannerType());

        PageInfo<Banner> pageInfo = new PageInfo<>(banners);

        response.setTotal(pageInfo.getTotal());
        response.setData(pageInfo.getList());

        return response;
    }


    /**
     * 修改配置
     */
    private void modifyBanner(BannerDTO dto) {
        Banner banner = new Banner();
        BeanUtils.copyProperties(dto, banner);
        if (!StringUtils.isEmpty(dto.getShareChannel())) {
            banner.setShareChannel(JSON.toJSONString(dto.getShareChannel()));
        }
        if ("[]".equals(dto.getShareChannel())){
            banner.setShareChannel(null);
        }

        if (Constants.Event.ADD.equals(dto.getEvent())) {
            banner.setCreateTime(new Date());
            banner.setDeleteStatus(false);
            bannerMapper.insertSelective(banner);
        } else {
            bannerMapper.updateByPrimaryKeySelective(banner);
        }
    }
}
