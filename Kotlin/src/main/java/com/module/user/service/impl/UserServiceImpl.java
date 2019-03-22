package com.module.user.service.impl;

import com.module.user.dao.UserInfoMapper;
import com.module.user.model.UserInfo;
import com.module.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl  implements UserService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    public UserInfo getUserById(int id) {
        return this.userInfoMapper.selectByPrimaryKey(Integer.valueOf(id));
    }

    public UserInfo getUserByMobile(String mobile) {
        return this.userInfoMapper.selectByMobile(mobile);
    }

    public void addUser(UserInfo userInfo) {
        this.userInfoMapper.insert(userInfo);
    }

    public int modifyUser(UserInfo userInfo) {
        return this.userInfoMapper.updateByPrimaryKeySelective(userInfo);
    }
}