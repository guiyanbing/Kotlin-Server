package com.module.user.service;

import com.module.user.model.VerifyCodeModel;

public interface SmsService {
    boolean sendVerifyCode(VerifyCodeModel paramVerifyCodeModel);

    String getVerifyCode(String paramString);
}