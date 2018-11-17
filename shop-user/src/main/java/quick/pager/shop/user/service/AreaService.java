package quick.pager.shop.user.service;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.common.dto.DTO;
import quick.pager.common.response.Response;
import quick.pager.common.service.IService;
import quick.pager.shop.model.user.Area;
import quick.pager.shop.model.user.City;
import quick.pager.shop.model.user.Province;
import quick.pager.shop.user.response.AreaResponse;
import quick.pager.shop.user.mapper.AreaMapper;
import quick.pager.shop.user.mapper.CityMapper;
import quick.pager.shop.user.mapper.ProvinceMapper;

@Service
@Slf4j
public class AreaService implements IService<AreaResponse> {

    @Autowired
    private AreaMapper areaMapper;
    @Autowired
    private CityMapper cityMapper;
    @Autowired
    private ProvinceMapper provinceMapper;

    @Override
    public Response<AreaResponse> doService(DTO dto) {

        AreaResponse areaDTO = new AreaResponse();

        List<Area> areas = areaMapper.selectAll();
        List<City> cities = cityMapper.selectAll();
        List<Province> provinces = provinceMapper.selectAll();

        areaDTO.setAreas(areas);
        areaDTO.setCities(cities);
        areaDTO.setProvinces(provinces);

        return new Response<>(areaDTO);
    }
}
