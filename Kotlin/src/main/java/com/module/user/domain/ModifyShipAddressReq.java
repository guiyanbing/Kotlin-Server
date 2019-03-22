package com.module.user.domain;

public class ModifyShipAddressReq extends BaseReq {
    private Integer id;
    private String shipUserName;
    private String shipUserMobile;
    private String shipAddress;
    private Integer shipIsDefault;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShipUserName() {
        return this.shipUserName;
    }

    public void setShipUserName(String shipUserName) {
        this.shipUserName = shipUserName;
    }

    public String getShipUserMobile() {
        return this.shipUserMobile;
    }

    public void setShipUserMobile(String shipUserMobile) {
        this.shipUserMobile = shipUserMobile;
    }

    public String getShipAddress() {
        return this.shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    public Integer getShipIsDefault() {
        return this.shipIsDefault;
    }

    public void setShipIsDefault(Integer shipIsDefault) {
        this.shipIsDefault = shipIsDefault;
    }
}
