package com.module.user.service;

import com.module.user.model.CartGoods;

import java.util.List;

public interface CartGoodsService {
    int addCartGoods(CartGoods paramCartGoods);

    List<CartGoods> getCartGoodsList(Integer paramInteger);

    void deleteCartGoods(List<Integer> paramList);
}
