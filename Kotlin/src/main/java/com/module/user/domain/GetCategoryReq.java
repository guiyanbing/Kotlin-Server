package com.module.user.domain;

public class GetCategoryReq extends BaseReq {
    private Integer parentId;

    public Integer getParentId() {
        return this.parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}