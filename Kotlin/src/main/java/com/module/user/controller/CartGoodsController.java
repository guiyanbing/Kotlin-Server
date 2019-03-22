package com.module.user.controller;

import com.module.user.common.InitAction;
import com.module.user.domain.AddCartGoodsReq;
import com.module.user.domain.BaseResp;
import com.module.user.domain.DeleteCartGoodsReq;
import com.module.user.domain.SubmitCartReq;
import com.module.user.model.CartGoods;
import com.module.user.model.OrderGoods;
import com.module.user.model.OrderInfo;
import com.module.user.model.ShipAddress;
import com.module.user.service.CartGoodsService;
import com.module.user.service.OrderService;
import com.module.user.service.ShipAddressService;
import com.module.user.utils.YuanFenConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(produces = {"application/json;charset=UTF-8"}, value = {"/cart"})
public class CartGoodsController extends BaseController {

    @Autowired
    private CartGoodsService cartGoodsService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ShipAddressService shipAddressService;

    @RequestMapping(value = {"/getList"}, method = {org.springframework.web.bind.annotation.RequestMethod.POST})
    @ResponseBody
    public BaseResp<List<CartGoods>> getList() {
        BaseResp resp = new BaseResp();

        if ((this.request.getHeader("token") == null) || (this.request.getHeader("token").equals(""))) {
            resp.setStatus(0);
            resp.setMessage("未登录");
            return resp;
        }

        List list = this.cartGoodsService.getCartGoodsList(Integer.valueOf(this.request.getHeader("token")));
        if ((list == null) || (list.size() == 0)) {
            resp.setStatus(0);
            resp.setMessage("列表为空");
            return resp;
        }

        resp.setStatus(0);
        resp.setMessage("列表获取成功");
        resp.setData(list);
        return resp;
    }

    @RequestMapping(value = {"/add"}, method = {org.springframework.web.bind.annotation.RequestMethod.POST})
    @ResponseBody
    public BaseResp<Integer> addCartGoods(@RequestBody AddCartGoodsReq req) {
        BaseResp resp = new BaseResp();

        CartGoods cartGoods = new CartGoods();
        cartGoods.setGoodsId(req.getGoodsId());
        cartGoods.setUserId(Integer.valueOf(this.request.getHeader("token")));
        cartGoods.setGoodsIcon(req.getGoodsIcon());
        cartGoods.setGoodsDesc(req.getGoodsDesc());
        cartGoods.setGoodsPrice(req.getGoodsPrice());
        cartGoods.setGoodsCount(req.getGoodsCount());
        cartGoods.setGoodsSku(req.getGoodsSku());

        this.cartGoodsService.addCartGoods(cartGoods);
        resp.setMessage("添加购物车成功");
        resp.setData(Integer.valueOf(this.cartGoodsService.getCartGoodsList(Integer.valueOf(this.request.getHeader("token"))).size()));
        return resp;
    }

    @RequestMapping(value = {"/delete"}, method = {org.springframework.web.bind.annotation.RequestMethod.POST})
    @ResponseBody
    public BaseResp deleteCartGoods(@RequestBody DeleteCartGoodsReq req) {

        BaseResp resp = new BaseResp();

        this.cartGoodsService.deleteCartGoods(req.getCartIdList());
        resp.setStatus(0);
        resp.setMessage("添加购物车成功");

        return resp;
    }

    @RequestMapping(value = {"/submit"}, method = {org.springframework.web.bind.annotation.RequestMethod.POST})
    @ResponseBody
    public BaseResp<Integer> submitCart(@RequestBody SubmitCartReq req) {

        BaseResp resp = new BaseResp();

        int userId = Integer.valueOf(this.request.getHeader("token")).intValue();

        OrderInfo orderInfo = new OrderInfo();

        orderInfo.setUserId(Integer.valueOf(userId));
        try {

            orderInfo.setTotalPrice(YuanFenConverter.changeF2Y(req.getTotalPrice()));
        } catch (Exception e) {

            e.printStackTrace();
        }


        List<ShipAddress> shipList = this.shipAddressService.getShipAddress(Integer.valueOf(userId));

        if ((shipList == null) || (shipList.size() == 0))
            orderInfo.setShipId(Integer.valueOf(0));
        else {

            for (ShipAddress shipAddress : shipList) {

                if (shipAddress.getShipIsDefault().intValue() == 0) {

                    orderInfo.setShipId(shipAddress.getId());
                }
            }
        }

        orderInfo.setOrderStatus(Integer.valueOf(-1));

        orderInfo.setPayType(Integer.valueOf(0));

        int orderId = this.orderService.addOrder(orderInfo);

        List cartIdList = new ArrayList();

        for (OrderGoods orderGoods : req.getGoodsList()) {

            cartIdList.add(orderGoods.getId());

            orderGoods.setOrderId(Integer.valueOf(orderId));
            try {

                orderGoods.setGoodsPrice(YuanFenConverter.changeF2Y(orderGoods.getGoodsPrice()));
            } catch (Exception e) {

                e.printStackTrace();
            }

            this.orderService.addOrderGoods(orderGoods);
        }


        InitAction.cartIdMap.put(Integer.valueOf(orderId), cartIdList);

        resp.setStatus(0);
        resp.setMessage("购物车提交成功");
        resp.setData(Integer.valueOf(orderId));
        return resp;
    }
}