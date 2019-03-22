package com.module.user.domain;

public class ModifyPwdReq extends BaseReq {
    private String mobile;
    private String pwd;

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPwd() {
        return this.pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}

