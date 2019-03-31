package quick.pager.shop.service;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.Province;
import quick.pager.shop.dto.BaseDTO;
import quick.pager.shop.response.AreaResponse;
import quick.pager.shop.response.Response;
import quick.pager.shop.Area;
import quick.pager.shop.City;
import quick.pager.shop.mapper.AreaMapper;
import quick.pager.shop.mapper.CityMapper;
import quick.pager.shop.mapper.ProvinceMapper;

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
    public Response<AreaResponse> doService(BaseDTO dto) {

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
