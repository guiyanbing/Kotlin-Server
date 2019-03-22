package com.module.user.dao;

import com.module.user.model.VerifyCodeModel;

public interface SmsDao {
    boolean putVerifyCode(VerifyCodeModel paramVerifyCodeModel);

    String getVerifyCode(String paramString);
}
