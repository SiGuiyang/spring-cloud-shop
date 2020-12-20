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
import quick.pager.shop.mapper.WhitelistMapper;
import quick.pager.shop.model.Whitelist;
import quick.pager.shop.risk.request.WhiteBlacklistPageRequest;
import quick.pager.shop.risk.request.WhiteBlacklistSaveRequest;
import quick.pager.shop.risk.response.WhiteBlacklistResponse;
import quick.pager.shop.service.WhitelistService;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.utils.Assert;
import quick.pager.shop.utils.DateUtils;

@Service
@Slf4j
public class WhiteListServiceImpl extends ServiceImpl<WhitelistMapper, Whitelist> implements WhitelistService {


    @Override
    public Response<List<WhiteBlacklistResponse>> queryPage(final WhiteBlacklistPageRequest request) {

        LambdaQueryWrapper<Whitelist> wrapper = new LambdaQueryWrapper<>();

        if (StringUtils.isNotEmpty(request.getPhone())) {
            wrapper.eq(Whitelist::getPhone, request.getPhone());
        }
        if (Objects.nonNull(request.getState())) {
            wrapper.eq(Whitelist::getState, request.getState());
        }
        if (CollectionUtils.isNotEmpty(request.getRange())) {
            wrapper.ge(Whitelist::getUpdateTime, request.getRange().get(IConsts.ZERO));
            wrapper.le(Whitelist::getUpdateTime, request.getRange().get(IConsts.ONE));
        }

        Response<List<Whitelist>> page = this.toPage(request.getPage(), request.getPageSize(), wrapper);

        return Response.toResponse(page.getData().stream().map(this::convert).collect(Collectors.toList()), page.getTotal());
    }

    @Override
    public Response<List<String>> queryList() {
        return null;
    }

    @Override
    public Response<Long> create(final WhiteBlacklistSaveRequest request) {
        Whitelist whitelist = new Whitelist();
        whitelist.setState(Boolean.FALSE);
        whitelist.setPhone(request.getPhone());
        whitelist.setCreateTime(DateUtils.dateTime());
        whitelist.setUpdateTime(DateUtils.dateTime());
        whitelist.setCreateUser(request.getCreateUser());
        whitelist.setUpdateUser(request.getUpdateUser());
        whitelist.setDeleteStatus(Boolean.FALSE);
        Assert.isTrue(this.baseMapper.insert(whitelist) > 0, () -> "添加白名单失败");
        return Response.toResponse(whitelist.getId());
    }

    @Override
    public Response<Long> modify(final WhiteBlacklistSaveRequest request) {
        Whitelist whitelist = new Whitelist();
        whitelist.setState(request.getState());
        whitelist.setPhone(request.getPhone());
        whitelist.setUpdateTime(DateUtils.dateTime());
        whitelist.setUpdateUser(request.getUpdateUser());
        Assert.isTrue(this.baseMapper.update(whitelist, new LambdaQueryWrapper<Whitelist>().eq(Whitelist::getId, request.getId())) > 0, () -> "更新白名单失败¬");
        return Response.toResponse(request.getId());
    }

    @Override
    public Response<Long> delete(final Long id) {

        Whitelist whitelist = this.baseMapper.selectById(id);

        Assert.isTrue(Objects.nonNull(whitelist), () -> "白名单不存在");

        Assert.isTrue(this.baseMapper.deleteById(id) > 0, () -> "删除白名单失败");
        return Response.toResponse(id);
    }

    /**
     * 数据转换
     *
     * @param whitelist 白名单
     * @return 数据响应
     */
    private WhiteBlacklistResponse convert(final Whitelist whitelist) {
        WhiteBlacklistResponse response = new WhiteBlacklistResponse();
        response.setId(whitelist.getId());
        response.setPhone(whitelist.getPhone());
        response.setState(whitelist.getState());
        response.setCreateTime(whitelist.getCreateTime());
        response.setUpdateTime(whitelist.getUpdateTime());
        response.setCreateUser(whitelist.getCreateUser());
        response.setUpdateUser(whitelist.getUpdateUser());
        return response;
    }
}
