/*    */ package com.module.user.model;
/*    */ 
/*    */ import java.util.List;
/*    */ 
/*    */ public class GoodsSku
/*    */ {
/*    */   private Integer id;
/*    */   private Integer goodsId;
/*    */   private String goodsSkuTitle;
/*    */   private String goodsSkuContent;
/*    */   private String skuTitle;
/*    */   private List<String> skuContent;
/*    */ 
/*    */   public GoodsSku()
/*    */   {
/*    */   }
/*    */ 
/*    */   public GoodsSku(Integer goodsId, String goodsSkuTitle, String goodsSkuContent)
/*    */   {
/* 20 */     this.goodsId = goodsId;
/* 21 */     this.goodsSkuTitle = goodsSkuTitle;
/* 22 */     this.goodsSkuContent = goodsSkuContent;
/*    */   }
/*    */ 
/*    */   public Integer getId() {
/* 26 */     return this.id;
/*    */   }
/*    */ 
/*    */   public void setId(Integer id) {
/* 30 */     this.id = id;
/*    */   }
/*    */ 
/*    */   public Integer getGoodsId() {
/* 34 */     return this.goodsId;
/*    */   }
/*    */ 
/*    */   public void setGoodsId(Integer goodsId) {
/* 38 */     this.goodsId = goodsId;
/*    */   }
/*    */ 
/*    */   public String getGoodsSkuContent()
/*    */   {
/* 43 */     return this.goodsSkuContent;
/*    */   }
/*    */ 
/*    */   public void setGoodsSkuContent(String goodsSkuContent) {
/* 47 */     this.goodsSkuContent = (goodsSkuContent == null ? null : goodsSkuContent.trim());
/*    */   }
/*    */ 
/*    */   public String getSkuTitle() {
/* 51 */     return this.skuTitle;
/*    */   }
/*    */ 
/*    */   public void setSkuTitle(String skuTitle) {
/* 55 */     this.skuTitle = skuTitle;
/*    */   }
/*    */ 
/*    */   public List<String> getSkuContent() {
/* 59 */     return this.skuContent;
/*    */   }
/*    */ 
/*    */   public void setSkuContent(List<String> skuContent) {
/* 63 */     this.skuContent = skuContent;
/*    */   }
/*    */ 
/*    */   public String getGoodsSkuTitle() {
/* 67 */     return this.goodsSkuTitle;
/*    */   }
/*    */ 
/*    */   public void setGoodsSkuTitle(String goodsSkuTitle) {
/* 71 */     this.goodsSkuTitle = goodsSkuTitle;
/*    */   }
/*    */ }

/* Location:           E:\WorkSpace\App\Test\appidzbnbo3hx6t\ROOT\WEB-INF\classes\
 * Qualified Name:     com.module.user.model.GoodsSku
 * JD-Core Version:    0.6.2
 */