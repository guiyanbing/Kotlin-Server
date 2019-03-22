package com.module.user.dao;

import com.module.user.model.OrderInfo;

import java.util.List;
import java.util.Map;

public interface OrderInfoMapper {
    int deleteByPrimaryKey(Integer paramInteger);

    int insert(OrderInfo paramOrderInfo);

    int insertSelective(OrderInfo paramOrderInfo);

    OrderInfo selectByPrimaryKey(Integer paramInteger);

    int updateByPrimaryKeySelective(OrderInfo paramOrderInfo);

    int updateByPrimaryKey(OrderInfo paramOrderInfo);

    List<OrderInfo> selectOrderList(Map paramMap);

    List<OrderInfo> selectAllOrderList(Integer paramInteger);
}