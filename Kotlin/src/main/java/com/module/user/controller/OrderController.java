package com.module.user.controller;

import com.module.user.common.InitAction;
import com.module.user.domain.BaseResp;
import com.module.user.domain.CancelOrderReq;
import com.module.user.domain.ConfirmOrderReq;
import com.module.user.domain.GetOrderByIdReq;
import com.module.user.domain.GetOrderListReq;
import com.module.user.domain.PayOrderReq;
import com.module.user.domain.SubmitOrderReq;
import com.module.user.model.MessageInfo;
import com.module.user.model.Order;
import com.module.user.model.OrderGoods;
import com.module.user.model.OrderInfo;
import com.module.user.service.CartGoodsService;
import com.module.user.service.MessageService;
import com.module.user.service.OrderService;
import com.module.user.service.ShipAddressService;
import com.module.user.service.UserService;
import com.module.user.utils.DateUtil;
import com.module.user.utils.YuanFenConverter;
import com.module.user.utils.push.PushSender;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(produces = {"application/json;charset=UTF-8"}, value = {"/order"})
public class OrderController extends BaseController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ShipAddressService shipAddressService;

    @Autowired
    private CartGoodsService cartGoodsService;

    @Autowired
    private MessageService messageService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/getOrderList"}, method = {org.springframework.web.bind.annotation.RequestMethod.POST})
    @ResponseBody
    public BaseResp<List<Order>> getOrderList(@RequestBody GetOrderListReq req) {
        BaseResp resp = new BaseResp();
 
        List<OrderInfo> list = this.orderService.getOrderList(Integer.valueOf(this.request.getHeader("token")), req.getOrderStatus());
        if ((list == null) || (list.size() == 0)) {
            resp.setStatus(0);
            resp.setMessage("列表为空");
            return resp;
        }
 
        List orderList = new ArrayList();
        for (OrderInfo info : list) {
            Order order = new Order();
            order.setId(info.getId());
            order.setOrderStatus(info.getOrderStatus());
            order.setPayType(info.getPayType());
            order.setTotalPrice(YuanFenConverter.changeY2F(Long.valueOf(info.getTotalPrice())));
            order.setShipAddress(this.shipAddressService.getShipAddressById(info.getShipId()));
 
            List<OrderGoods> goodsList = this.orderService.getOrderGoodsList(info.getId());
            for (OrderGoods orderGoods : goodsList) {
                orderGoods.setGoodsPrice(YuanFenConverter.changeY2F(orderGoods.getGoodsPrice()));
            }
 
            order.setOrderGoodsList(goodsList);
 
            orderList.add(order);
        }
 
        resp.setStatus(0);
        resp.setMessage("列表获取成功");
        resp.setData(orderList);
        return resp;
    }

    @RequestMapping(value = {"/getOrderById"}, method = {org.springframework.web.bind.annotation.RequestMethod.POST})
    @ResponseBody
    public BaseResp<Order> getOrderById(@RequestBody GetOrderByIdReq req) {
        BaseResp resp = new BaseResp();
 
        Order order = new Order();
 
        OrderInfo orderInfo = this.orderService.getOrderById(req.getOrderId());
        order.setId(orderInfo.getId());
        order.setOrderStatus(orderInfo.getOrderStatus());
        order.setPayType(orderInfo.getPayType());
        order.setTotalPrice(YuanFenConverter.changeY2F(Long.valueOf(orderInfo.getTotalPrice())));
 
        order.setShipAddress(this.shipAddressService.getShipAddressById(orderInfo.getShipId()));
 
        List<OrderGoods> orderGoodsList = this.orderService.getOrderGoodsList(orderInfo.getId());
        for (OrderGoods orderGoods : orderGoodsList) {
            orderGoods.setGoodsPrice(YuanFenConverter.changeY2F(orderGoods.getGoodsPrice()));
        }
 
        order.setOrderGoodsList(orderGoodsList);
 
        resp.setStatus(0);
        resp.setMessage("获取订单成功");
        resp.setData(order);
        return resp;
    }

    @RequestMapping(value = {"/submitOrder"}, method = {org.springframework.web.bind.annotation.RequestMethod.POST})
    @ResponseBody
    public BaseResp submitOrder(@RequestBody SubmitOrderReq req) {
        BaseResp resp = new BaseResp();
 
        OrderInfo orderInfo = this.orderService.getOrderById(req.getOrder().getId());
        orderInfo.setOrderStatus(Integer.valueOf(1));
        orderInfo.setShipId(req.getOrder().getShipAddress().getId());
 
        this.orderService.modifyOrder(orderInfo);
 
        List cartIdList = (List) InitAction.cartIdMap.get(req.getOrder().getId());
        this.cartGoodsService.deleteCartGoods(cartIdList);
        InitAction.cartIdMap.remove(req.getOrder().getId());
 
        int userId = Integer.valueOf(this.request.getHeader("token")).intValue();
        String pushId = this.userService.getUserById(userId).getPushId();
        sendMessage(Integer.valueOf(userId), pushId, req.getOrder().getId() + "");
 
        resp.setStatus(0);
        resp.setMessage("订单提交成功");
        return resp;
    }

    private void sendMessage(Integer userId, String pushId, String orderId) {
        String curTime = DateUtil.format(new Date(), DateUtil.FORMAT_LONG_NEW);
        MessageInfo msg = new MessageInfo();
        msg.setMsgIcon("http://osea2fxp7.bkt.clouddn.com/108x108.png");
        msg.setMsgTitle("下单成功");
        msg.setMsgContent("恭喜您下单成功，有一笔订单等待支付");
        msg.setMsgTime(curTime);
        msg.setUserId(userId);
        this.messageService.addMessage(msg);
 
        PushSender.sendOrderEvent(pushId, orderId);
    }

    @RequestMapping(value = {"/cancel"}, method = {org.springframework.web.bind.annotation.RequestMethod.POST})
    @ResponseBody
    public BaseResp cancelOrder(@RequestBody CancelOrderReq req) {
        BaseResp resp = new BaseResp();
 
        OrderInfo orderInfo = this.orderService.getOrderById(req.getOrderId());
        orderInfo.setOrderStatus(Integer.valueOf(4));
        this.orderService.modifyOrder(orderInfo);
 
        resp.setStatus(0);
        resp.setMessage("订单取消成功");
        return resp;
    }

    @RequestMapping(value = {"/confirm"}, method = {org.springframework.web.bind.annotation.RequestMethod.POST})
    @ResponseBody
    public BaseResp confirmOrder(@RequestBody ConfirmOrderReq req) {
        BaseResp resp = new BaseResp();
 
        OrderInfo orderInfo = this.orderService.getOrderById(req.getOrderId());
        orderInfo.setOrderStatus(Integer.valueOf(3));
        this.orderService.modifyOrder(orderInfo);
 
        resp.setStatus(0);
        resp.setMessage("订单确认收货成功");
        return resp;
    }

    @RequestMapping(value = {"/pay"}, method = {org.springframework.web.bind.annotation.RequestMethod.POST})
    @ResponseBody
    public BaseResp payOrder(@RequestBody PayOrderReq req) {
        BaseResp resp = new BaseResp();
 
        OrderInfo orderInfo = this.orderService.getOrderById(req.getOrderId());
        orderInfo.setOrderStatus(Integer.valueOf(2));
        this.orderService.modifyOrder(orderInfo);
 
        resp.setStatus(0);
        resp.setMessage("订单支付成功");
        return resp;
    }
}
