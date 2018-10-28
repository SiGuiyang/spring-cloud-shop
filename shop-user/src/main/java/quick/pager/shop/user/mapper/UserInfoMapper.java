package quick.pager.shop.user.mapper;

import quick.pager.shop.model.user.UserInfo;

public interface UserInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserInfo record);

}