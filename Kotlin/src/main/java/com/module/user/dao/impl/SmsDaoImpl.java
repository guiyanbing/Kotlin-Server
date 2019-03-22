package com.module.user.dao.impl;

import com.module.user.dao.AbstractBaseRedisDao;
import com.module.user.dao.SmsDao;
import com.module.user.model.VerifyCodeModel;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Repository;

@Repository("smsDao")
public class SmsDaoImpl extends AbstractBaseRedisDao<String, VerifyCodeModel>
        implements SmsDao {
    public boolean putVerifyCode(final VerifyCodeModel model) {

        Boolean result = (Boolean) this.redisTemplate.execute(new RedisCallback() {
                                                                  public Boolean doInRedis(RedisConnection redisConnection) throws DataAccessException {

                                                                      RedisSerializer serializer = SmsDaoImpl.this.getRedisSerializer();

                                                                      byte[] key = serializer.serialize(model.getMobile());

                                                                      byte[] value = serializer.serialize(model.getVerifyCode());


                                                                      redisConnection.set(key, value);

                                                                      redisConnection.expire(key, 60L);


                                                                      return Boolean.valueOf(true);
                                                                  }
                                                              }
                , false, true);

        return result.booleanValue();
    }

    public String getVerifyCode(final String mobile) {
        String verifyCode = (String) this.redisTemplate.execute(new RedisCallback() {
            public String doInRedis(RedisConnection redisConnection) throws DataAccessException {
                RedisSerializer serializer = SmsDaoImpl.this.getRedisSerializer();
                byte[] key = serializer.serialize(mobile);
                byte[] value = redisConnection.get(key);
                if (value == null) {
                    return null;
                }

                return (String) serializer.deserialize(value);
            }
        });
        return verifyCode;
    }
}