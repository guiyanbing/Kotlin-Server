package com.module.user.domain;

public class GetGoodsListByKeywordReq extends BaseReq {
    private String keyword;
    private Integer pageNo;

    public String getKeyword() {
        return this.keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getPageNo() {
        return this.pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }
}

