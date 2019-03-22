package com.module.user.model;

import java.util.List;

public class GoodsInfo {
    private Integer id;
    private Integer categoryId;
    private String goodsDesc;
    private String goodsDefaultIcon;
    private String goodsDefaultPrice;
    private String goodsDetailOne;
    private String goodsDetailTwo;
    private Integer goodsSalesCount;
    private Integer goodsStockCount;
    private String goodsCode;
    private String goodsDefaultSku;
    private String goodsBanner;
    private List<GoodsSku> goodsSku;
    private Integer maxPage;

    public GoodsInfo() {
    }

    public GoodsInfo(Integer categoryId, String goodsDesc, String goodsDefaultIcon, String goodsDefaultPrice, String goodsDetailOne, String goodsDetailTwo, Integer goodsSalesCount, Integer goodsStockCount, String goodsCode, String goodsDefaultSku, String goodsBanner) {
        this.categoryId = categoryId;
        this.goodsDesc = goodsDesc;
        this.goodsDefaultIcon = goodsDefaultIcon;
        this.goodsDefaultPrice = goodsDefaultPrice;
        this.goodsDetailOne = goodsDetailOne;
        this.goodsDetailTwo = goodsDetailTwo;
        this.goodsSalesCount = goodsSalesCount;
        this.goodsStockCount = goodsStockCount;
        this.goodsCode = goodsCode;
        this.goodsDefaultSku = goodsDefaultSku;
        this.goodsBanner = goodsBanner;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public String getGoodsDefaultIcon() {
        return goodsDefaultIcon;
    }

    public void setGoodsDefaultIcon(String goodsDefaultIcon) {
        this.goodsDefaultIcon = goodsDefaultIcon;
    }

    public String getGoodsDefaultPrice() {
        return goodsDefaultPrice;
    }

    public void setGoodsDefaultPrice(String goodsDefaultPrice) {
        this.goodsDefaultPrice = goodsDefaultPrice;
    }

    public String getGoodsDetailOne() {
        return goodsDetailOne;
    }

    public void setGoodsDetailOne(String goodsDetailOne) {
        this.goodsDetailOne = goodsDetailOne;
    }

    public String getGoodsDetailTwo() {
        return goodsDetailTwo;
    }

    public void setGoodsDetailTwo(String goodsDetailTwo) {
        this.goodsDetailTwo = goodsDetailTwo;
    }

    public Integer getGoodsSalesCount() {
        return goodsSalesCount;
    }

    public void setGoodsSalesCount(Integer goodsSalesCount) {
        this.goodsSalesCount = goodsSalesCount;
    }

    public Integer getGoodsStockCount() {
        return goodsStockCount;
    }

    public void setGoodsStockCount(Integer goodsStockCount) {
        this.goodsStockCount = goodsStockCount;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getGoodsDefaultSku() {
        return goodsDefaultSku;
    }

    public void setGoodsDefaultSku(String goodsDefaultSku) {
        this.goodsDefaultSku = goodsDefaultSku;
    }

    public String getGoodsBanner() {
        return goodsBanner;
    }

    public void setGoodsBanner(String goodsBanner) {
        this.goodsBanner = goodsBanner;
    }

    public List<GoodsSku> getGoodsSku() {
        return goodsSku;
    }

    public void setGoodsSku(List<GoodsSku> goodsSku) {
        this.goodsSku = goodsSku;
    }

    public Integer getMaxPage() {
        return maxPage;
    }

    public void setMaxPage(Integer maxPage) {
        this.maxPage = maxPage;
    }
}