 package com.module.user.dao;
 
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.data.redis.core.StringRedisTemplate;
 import org.springframework.data.redis.serializer.RedisSerializer;
 
 public abstract class AbstractBaseRedisDao<K, V>
 {
 
   @Autowired
   protected StringRedisTemplate redisTemplate;
 
   public StringRedisTemplate getRedisTemplate()
   {
   return this.redisTemplate;
   }
 
   public void setRedisTemplate(StringRedisTemplate redisTemplate) {
    this.redisTemplate = redisTemplate;
   }
 
   protected RedisSerializer<String> getRedisSerializer() {
    return this.redisTemplate.getStringSerializer();
   }
 }
