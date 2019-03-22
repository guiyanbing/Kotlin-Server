package com.module.user.dao;

import com.module.user.model.CartGoods;

import java.util.List;

public interface CartGoodsMapper {
    int deleteByPrimaryKey(Integer paramInteger);

    int insert(CartGoods paramCartGoods);

    int insertSelective(CartGoods paramCartGoods);

    CartGoods selectByPrimaryKey(Integer paramInteger);

    int updateByPrimaryKeySelective(CartGoods paramCartGoods);

    int updateByPrimaryKey(CartGoods paramCartGoods);

    List<CartGoods> selectCartGoodsList(int paramInt);

    void deleteCartGoods(List<Integer> paramList);
}