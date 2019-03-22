package com.module.user.service;

import com.module.user.model.UserInfo;

public interface UserService {
    UserInfo getUserById(int paramInt);

    UserInfo getUserByMobile(String paramString);

    void addUser(UserInfo paramUserInfo);

    int modifyUser(UserInfo paramUserInfo);
}
