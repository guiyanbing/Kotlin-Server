/*    */ package com.module.user.model;
/*    */ 
/*    */ import java.util.List;
/*    */ 
/*    */ public class Order
/*    */ {
/*    */   private Integer id;
/*    */   private Integer payType;
/*    */   private ShipAddress shipAddress;
/*    */   private String totalPrice;
/*    */   private Integer orderStatus;
/*    */   private List<OrderGoods> orderGoodsList;
/*    */ 
/*    */   public Integer getId()
/*    */   {
/* 19 */     return this.id;
/*    */   }
/*    */ 
/*    */   public void setId(Integer id) {
/* 23 */     this.id = id;
/*    */   }
/*    */ 
/*    */   public Integer getPayType() {
/* 27 */     return this.payType;
/*    */   }
/*    */ 
/*    */   public void setPayType(Integer payType) {
/* 31 */     this.payType = payType;
/*    */   }
/*    */ 
/*    */   public ShipAddress getShipAddress() {
/* 35 */     return this.shipAddress;
/*    */   }
/*    */ 
/*    */   public void setShipAddress(ShipAddress shipAddress) {
/* 39 */     this.shipAddress = shipAddress;
/*    */   }
/*    */ 
/*    */   public String getTotalPrice() {
/* 43 */     return this.totalPrice;
/*    */   }
/*    */ 
/*    */   public void setTotalPrice(String totalPrice) {
/* 47 */     this.totalPrice = totalPrice;
/*    */   }
/*    */ 
/*    */   public Integer getOrderStatus() {
/* 51 */     return this.orderStatus;
/*    */   }
/*    */ 
/*    */   public void setOrderStatus(Integer orderStatus) {
/* 55 */     this.orderStatus = orderStatus;
/*    */   }
/*    */ 
/*    */   public List<OrderGoods> getOrderGoodsList() {
/* 59 */     return this.orderGoodsList;
/*    */   }
/*    */ 
/*    */   public void setOrderGoodsList(List<OrderGoods> orderGoodsList) {
/* 63 */     this.orderGoodsList = orderGoodsList;
/*    */   }
/*    */ }

/* Location:           E:\WorkSpace\App\Test\appidzbnbo3hx6t\ROOT\WEB-INF\classes\
 * Qualified Name:     com.module.user.model.Order
 * JD-Core Version:    0.6.2
 */