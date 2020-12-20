package quick.pager.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import quick.pager.shop.constants.IConsts;
import quick.pager.shop.mapper.BlacklistMapper;
import quick.pager.shop.model.BlackList;
import quick.pager.shop.risk.request.WhiteBlacklistPageRequest;
import quick.pager.shop.risk.request.WhiteBlacklistSaveRequest;
import quick.pager.shop.risk.response.WhiteBlacklistResponse;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.service.BlacklistService;
import quick.pager.shop.utils.Assert;
import quick.pager.shop.utils.DateUtils;

@Service
@Slf4j
public class BlackListServiceImpl extends ServiceImpl<BlacklistMapper, BlackList> implements BlacklistService {


    @Override
    public Response<List<WhiteBlacklistResponse>> queryPage(final WhiteBlacklistPageRequest request) {

        LambdaQueryWrapper<BlackList> wrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotEmpty(request.getPhone())) {
            wrapper.eq(BlackList::getPhone, request.getPhone());
        }
        if (Objects.nonNull(request.getState())) {
            wrapper.eq(BlackList::getState, request.getState());
        }
        if (CollectionUtils.isNotEmpty(request.getRange())) {
            wrapper.ge(BlackList::getUpdateTime, request.getRange().get(IConsts.ZERO));
            wrapper.le(BlackList::getUpdateTime, request.getRange().get(IConsts.ONE));
        }

        Response<List<BlackList>> page = this.toPage(request.getPage(), request.getPageSize(), wrapper);

        return Response.toResponse(page.getData().stream().map(this::convert).collect(Collectors.toList()), page.getTotal());
    }

    @Override
    public Response<List<String>> queryList() {
//        BlackList blackList = new BlackList();
//        BeanUtils.copyProperties(blackListDTO, blackList);
//        QueryWrapper<BlackList> qw = new QueryWrapper<>();
//        if (!StringUtils.isEmpty(blackListDTO.getPhone())) {
//            qw.eq("phone", blackListDTO.getPhone());
//        }
//        return Response.toResponse(blackListMapper.selectPage(new Page<>(blackListDTO.getPage(), blackListDTO.getPageSize()), qw));
        return null;
    }

    @Override
    public Response<Long> create(final WhiteBlacklistSaveRequest request) {
        BlackList blackList = new BlackList();
        blackList.setState(Boolean.FALSE);
        blackList.setPhone(request.getPhone());
        blackList.setCreateTime(DateUtils.dateTime());
        blackList.setUpdateTime(DateUtils.dateTime());
        blackList.setCreateUser(request.getCreateUser());
        blackList.setUpdateUser(request.getUpdateUser());
        blackList.setDeleteStatus(Boolean.FALSE);
        Assert.isTrue(this.baseMapper.insert(blackList) > 0, () -> "添加黑名单失败");
        return Response.toResponse(blackList.getId());
    }

    @Override
    public Response<Long> modify(final WhiteBlacklistSaveRequest request) {
        BlackList blackList = new BlackList();
        blackList.setState(request.getState());
        blackList.setPhone(request.getPhone());
        blackList.setUpdateTime(DateUtils.dateTime());
        blackList.setUpdateUser(request.getUpdateUser());
        Assert.isTrue(this.baseMapper.update(blackList, new LambdaQueryWrapper<BlackList>().eq(BlackList::getId, request.getId())) > 0, () -> "更新黑名单失败¬");
        return Response.toResponse(request.getId());
    }

    @Override
    public Response<Long> delete(final Long id) {

        BlackList blackList = this.baseMapper.selectById(id);

        Assert.isTrue(Objects.nonNull(blackList), () -> "黑名单不存在");

        Assert.isTrue(this.baseMapper.deleteById(id) > 0, () -> "删除黑名单失败");
        return Response.toResponse(id);
    }

    /**
     * 数据转换
     *
     * @param blackList 黑名单
     * @return 数据响应
     */
    private WhiteBlacklistResponse convert(final BlackList blackList) {
        WhiteBlacklistResponse response = new WhiteBlacklistResponse();
        response.setId(blackList.getId());
        response.setPhone(blackList.getPhone());
        response.setState(blackList.getState());
        response.setCreateTime(blackList.getCreateTime());
        response.setUpdateTime(blackList.getUpdateTime());
        response.setCreateUser(blackList.getCreateUser());
        response.setUpdateUser(blackList.getUpdateUser());
        return response;
    }
}
