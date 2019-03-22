/*    */ package com.module.user.model;
/*    */ 
/*    */ public class Category
/*    */ {
/*    */   private Integer id;
/*    */   private String categoryName;
/*    */   private String categoryIcon;
/*    */   private Integer parentId;
/*    */ 
/*    */   public Category()
/*    */   {
/*    */   }
/*    */ 
/*    */   public Category(String categoryName, Integer parentId)
/*    */   {
/* 16 */     this.categoryName = categoryName;
/* 17 */     this.parentId = parentId;
/*    */   }
/*    */ 
/*    */   public Category(String categoryName, String categoryIcon, Integer parentId) {
/* 21 */     this.categoryName = categoryName;
/* 22 */     this.categoryIcon = categoryIcon;
/* 23 */     this.parentId = parentId;
/*    */   }
/*    */ 
/*    */   public Integer getId() {
/* 27 */     return this.id;
/*    */   }
/*    */ 
/*    */   public void setId(Integer id) {
/* 31 */     this.id = id;
/*    */   }
/*    */ 
/*    */   public String getCategoryName() {
/* 35 */     return this.categoryName;
/*    */   }
/*    */ 
/*    */   public void setCategoryName(String categoryName) {
/* 39 */     this.categoryName = (categoryName == null ? null : categoryName.trim());
/*    */   }
/*    */ 
/*    */   public String getCategoryIcon() {
/* 43 */     return this.categoryIcon;
/*    */   }
/*    */ 
/*    */   public void setCategoryIcon(String categoryIcon) {
/* 47 */     this.categoryIcon = (categoryIcon == null ? null : categoryIcon.trim());
/*    */   }
/*    */ 
/*    */   public Integer getParentId() {
/* 51 */     return this.parentId;
/*    */   }
/*    */ 
/*    */   public void setParentId(Integer parentId) {
/* 55 */     this.parentId = parentId;
/*    */   }
/*    */ }

/* Location:           E:\WorkSpace\App\Test\appidzbnbo3hx6t\ROOT\WEB-INF\classes\
 * Qualified Name:     com.module.user.model.Category
 * JD-Core Version:    0.6.2
 */