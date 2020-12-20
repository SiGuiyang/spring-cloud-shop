package quick.pager.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.mapper.UserAccountMapper;
import quick.pager.shop.model.UserAccount;
import quick.pager.shop.service.UserAccountService;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.user.response.UserAccountResponse;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    private UserAccountMapper userAccountMapper;

    @Override
    public Response<UserAccountResponse> account(final Long userId) {

        UserAccount userAccount = userAccountMapper.selectOne(new LambdaQueryWrapper<UserAccount>()
                .eq(UserAccount::getUserId, userId));

        return Response.toResponse(this.convert(userAccount));
    }


    private UserAccountResponse convert(final UserAccount userAccount) {
        UserAccountResponse ur = new UserAccountResponse();
        ur.setId(userAccount.getId());
        ur.setUserId(userAccount.getUserId());
        ur.setIntegral(userAccount.getIntegral());
        return ur;
    }
}
