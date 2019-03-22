package com.module.user.service;

import com.module.user.model.OrderGoods;
import com.module.user.model.OrderInfo;

import java.util.List;

public interface OrderService {
    int addOrder(OrderInfo paramOrderInfo);

    List<OrderInfo> getOrderList(Integer paramInteger1, Integer paramInteger2);

    int addOrderGoods(OrderGoods paramOrderGoods);

    OrderInfo getOrderById(Integer paramInteger);

    List<OrderGoods> getOrderGoodsList(Integer paramInteger);

    int modifyOrder(OrderInfo paramOrderInfo);
}
