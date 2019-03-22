package com.module.user.service.impl;

import com.module.user.dao.OrderGoodsMapper;
import com.module.user.dao.OrderInfoMapper;
import com.module.user.model.OrderGoods;
import com.module.user.model.OrderInfo;
import com.module.user.service.OrderService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("orderService")
public class OrderServiceImpl
        implements OrderService {

    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @Autowired
    private OrderGoodsMapper orderGoodsMapper;

    public int addOrder(OrderInfo model) {
        this.orderInfoMapper.insert(model);
        return model.getId().intValue();
    }

    public List<OrderInfo> getOrderList(Integer userId, Integer orderStatus) {
        if (orderStatus.intValue() == 0) {
            return this.orderInfoMapper.selectAllOrderList(userId);
        }

        Map map = new HashMap();
        map.put("userId", userId);
        map.put("orderStatus", orderStatus);
        return this.orderInfoMapper.selectOrderList(map);
    }

    public int addOrderGoods(OrderGoods model) {
        return this.orderGoodsMapper.insert(model);
    }

    public OrderInfo getOrderById(Integer id) {
        return this.orderInfoMapper.selectByPrimaryKey(id);
    }

    public List<OrderGoods> getOrderGoodsList(Integer orderId) {
        return this.orderGoodsMapper.selectGoodsList(orderId);
    }

    public int modifyOrder(OrderInfo orderInfo) {
        return this.orderInfoMapper.updateByPrimaryKey(orderInfo);
    }
}