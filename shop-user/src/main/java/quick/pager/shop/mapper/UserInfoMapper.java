package quick.pager.shop.mapper;

import quick.pager.shop.UserInfo;

public interface UserInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserInfo record);

}