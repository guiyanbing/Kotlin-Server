package com.module.user.model;

public class VerifyCodeModel {
    private String mobile;
    private String verifyCode;

    public VerifyCodeModel(String mobile, String verifyCode) {
        this.mobile = mobile;
        this.verifyCode = verifyCode;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getVerifyCode() {
        return this.verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }
}