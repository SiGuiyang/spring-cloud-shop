package quick.pager.shop.auth.service;

import com.alibaba.fastjson.JSON;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.common.constants.RedisKeys;
import quick.pager.common.dto.BaseDTO;
import quick.pager.common.response.Response;
import quick.pager.common.service.IService;
import quick.pager.common.service.RedisService;
import quick.pager.shop.auth.mapper.WhiteListMapper;
import quick.pager.shop.model.manage.WhiteList;

/**
 * 白名单反问接口服务
 *
 * @author siguiyang
 */
@Service
public class WhiteListService implements IService {

    @Autowired
    private RedisService redisService;
    @Autowired
    private WhiteListMapper whiteListMapper;

    @Override
    public Response doService(BaseDTO dto) {
        return null;
    }

    public void init() {
        List<WhiteList> whiteLists = whiteListMapper.selectEnableAll();
        List<String> collect = whiteLists.stream().map(WhiteList::getWhiteUrl).collect(Collectors.toList());
        redisService.set(RedisKeys.CommonKeys.REQUEST_URL_WHITE_LIST, JSON.toJSONString(collect), 24 * 60 * 60 * 365);
    }

}
