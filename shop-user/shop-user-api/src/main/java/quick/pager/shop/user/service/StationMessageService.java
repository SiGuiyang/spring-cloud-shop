package quick.pager.shop.user.service;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.dto.BaseDTO;
import quick.pager.shop.user.model.StationLetter;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.IService;
import quick.pager.shop.user.mapper.StationLetterMapper;

/**
 * 站内信服务
 *
 * @author siguiyang
 */
@Service
@Slf4j
public class StationMessageService implements IService {

    @Autowired
    private StationLetterMapper stationLetterMapper;

    @Override
    public Response doService(BaseDTO dto) {
//        StationMessageDTO stationMessageDTO = (StationMessageDTO) dto;
//        Response response = new Response();
//        switch (dto.getEvent()) {
//            case Constants.Event.LIST:
//                response = queryStationMessages(stationMessageDTO.getUserId(), dto.getPage(), dto.getPageSize());
//                break;
//            case Constants.Event.MODIFY:
//                response = modifyStationMessage(stationMessageDTO.getMessageId().get(0));
//                break;
//            case Constants.Event.DELETE:
//                response = deleteStationMessage(stationMessageDTO.getMessageId());
//                break;
//            case "count":
//                response = queryUnReadMessageCount(stationMessageDTO.getUserId());
//                break;
//            default:
//                response = new Response<>(ResponseStatus.Code.FAIL_CODE, ResponseStatus.PARAMS_EXCEPTION);
//        }
//        return response;
        return null;
    }

    /**
     * 查询未读站内信的个数
     *
     * @param userId 用户Id
     */
    private Response<Integer> queryUnReadMessageCount(Long userId) {

        return new Response<>(stationLetterMapper.selectUnReadMessageCount(userId));
    }

    /**
     * 批量删除站内行
     *
     * @param messageId t_station_message id 集合
     */
    private Response deleteStationMessage(List<Long> messageId) {
        messageId.forEach(id -> {
            StationLetter stationLetter = new StationLetter();
            stationLetter.setId(id);
            stationLetter.setDeleteStatus(true);
            stationLetterMapper.updateByPrimaryKeySelective(stationLetter);
        });
        return new Response();
    }

    /**
     * 将未读设置已读
     *
     * @param aLong t_station_message id
     */
    private Response modifyStationMessage(Long aLong) {
        StationLetter stationLetter = new StationLetter();
        stationLetter.setId(aLong);
        stationLetter.setStatus(1);
        stationLetterMapper.updateByPrimaryKeySelective(stationLetter);
        return new Response();
    }

    /**
     * 查询站内信列表
     *
     * @param userId 用户Id
     */
    private Response<List<StationLetter>> queryStationMessages(Long userId, Integer page, Integer pageSize) {

        List<StationLetter> stationLetters = stationLetterMapper.selectStationMessages(userId, (page - 1) * pageSize, pageSize);

        return new Response<>(stationLetters);
    }
}
