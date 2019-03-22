 package com.module.user.model;
 
 public class ShipAddress
 {
   private Integer id;
   private String shipUserName;
   private String shipUserMobile;
   private String shipAddress;
   private Integer shipIsDefault;
   private Integer userId;

     public Integer getId() {
         return id;
     }

     public void setId(Integer id) {
         this.id = id;
     }

     public String getShipUserName() {
         return shipUserName;
     }

     public void setShipUserName(String shipUserName) {
         this.shipUserName = shipUserName;
     }

     public String getShipUserMobile() {
         return shipUserMobile;
     }

     public void setShipUserMobile(String shipUserMobile) {
         this.shipUserMobile = shipUserMobile;
     }

     public String getShipAddress() {
         return shipAddress;
     }

     public void setShipAddress(String shipAddress) {
         this.shipAddress = shipAddress;
     }

     public Integer getShipIsDefault() {
         return shipIsDefault;
     }

     public void setShipIsDefault(Integer shipIsDefault) {
         this.shipIsDefault = shipIsDefault;
     }

     public Integer getUserId() {
         return userId;
     }

     public void setUserId(Integer userId) {
         this.userId = userId;
     }
 }
