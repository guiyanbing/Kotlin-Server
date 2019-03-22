package com.module.user.dao;

import com.module.user.model.UserInfo;

public interface UserInfoMapper {
    int deleteByPrimaryKey(Integer paramInteger);

    int insert(UserInfo paramUserInfo);

    int insertSelective(UserInfo paramUserInfo);

    UserInfo selectByPrimaryKey(Integer paramInteger);

    UserInfo selectByMobile(String paramString);

    int updateByPrimaryKeySelective(UserInfo paramUserInfo);

    int updateByPrimaryKey(UserInfo paramUserInfo);
}
