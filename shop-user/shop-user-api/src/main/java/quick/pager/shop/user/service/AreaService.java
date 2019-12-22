package quick.pager.shop.user.service;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.dto.BaseDTO;
import quick.pager.shop.user.response.AreaResponse;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.IService;

@Service
@Slf4j
public class AreaService implements IService<AreaResponse> {

//    @Autowired
//    private AreaMapper areaMapper;
//    @Autowired
//    private CityMapper cityMapper;
//    @Autowired
//    private ProvinceMapper provinceMapper;

    @Override
    public Response<AreaResponse> doService(BaseDTO dto) {

        AreaResponse areaDTO = new AreaResponse();

//        List<Area> areas = areaMapper.selectAll();
//        List<City> cities = cityMapper.selectAll();
//        List<Province> provinces = provinceMapper.selectAll();
//
//        areaDTO.setAreas(areas);
//        areaDTO.setCities(cities);
//        areaDTO.setProvinces(provinces);

        return new Response<>(areaDTO);
    }
}
