package com.module.user.dao;

import com.module.user.model.OrderGoods;

import java.util.List;

public interface OrderGoodsMapper {
    int deleteByPrimaryKey(Integer paramInteger);

    int insert(OrderGoods paramOrderGoods);

    int insertSelective(OrderGoods paramOrderGoods);

    OrderGoods selectByPrimaryKey(Integer paramInteger);

    int updateByPrimaryKeySelective(OrderGoods paramOrderGoods);

    int updateByPrimaryKey(OrderGoods paramOrderGoods);

    List<OrderGoods> selectGoodsList(Integer paramInteger);
}
