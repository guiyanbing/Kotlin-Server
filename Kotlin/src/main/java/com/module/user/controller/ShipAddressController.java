package com.module.user.controller;

import com.module.user.domain.AddShipAddressReq;
import com.module.user.domain.BaseResp;
import com.module.user.domain.DeleteShipAddressReq;
import com.module.user.domain.ModifyShipAddressReq;
import com.module.user.model.ShipAddress;
import com.module.user.service.ShipAddressService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(produces = {"application/json;charset=UTF-8"}, value = {"/shipAddress"})
public class ShipAddressController extends BaseController {
    public static final int IS_DEFAULT = 0;
    public static final int IS_NOT_DEFAULT = 1;

    @Autowired
    private ShipAddressService shipAddressService;

    @RequestMapping(value = {"/getList"}, method = {org.springframework.web.bind.annotation.RequestMethod.POST})
    @ResponseBody
    public BaseResp<List<ShipAddress>> getList() {
        BaseResp resp = new BaseResp();

        List list = this.shipAddressService.getShipAddress(Integer.valueOf(this.request.getHeader("token")));
        if ((list == null) || (list.size() == 0)) {
            resp.setStatus(0);
            resp.setMessage("地址列表为空");
            return resp;
        }

        resp.setStatus(0);
        resp.setMessage("分类列表获取成功");
        resp.setData(list);
        return resp;
    }

    @RequestMapping(value = {"/add"}, method = {org.springframework.web.bind.annotation.RequestMethod.POST})
    @ResponseBody
    public BaseResp add(@RequestBody AddShipAddressReq req) {
        BaseResp resp = new BaseResp();

        ShipAddress address = new ShipAddress();
        address.setShipAddress(req.getShipAddress());
        address.setShipUserMobile(req.getShipUserMobile());
        address.setShipUserName(req.getShipUserName());
        address.setUserId(Integer.valueOf(this.request.getHeader("token")));
        List list = this.shipAddressService.getShipAddress(Integer.valueOf(this.request.getHeader("token")));
        if ((list == null) || (list.size() == 0))
            address.setShipIsDefault(Integer.valueOf(0));
        else {
            address.setShipIsDefault(Integer.valueOf(1));
        }
        this.shipAddressService.addShipAddress(address);
        resp.setStatus(0);
        resp.setMessage("添加地址成功");
        return resp;
    }

    @RequestMapping(value = {"/modify"}, method = {org.springframework.web.bind.annotation.RequestMethod.POST})
    @ResponseBody
    public BaseResp modify(@RequestBody ModifyShipAddressReq req) {
        BaseResp resp = new BaseResp();
 
        ShipAddress address = new ShipAddress();
        address.setId(req.getId());
        address.setShipAddress(req.getShipAddress());
        address.setShipUserMobile(req.getShipUserMobile());
        address.setShipUserName(req.getShipUserName());
        address.setShipIsDefault(req.getShipIsDefault());
 
        if (req.getShipIsDefault().intValue() == 0) {
            for (ShipAddress shipAddress : this.shipAddressService.getShipAddress(Integer.valueOf(this.request.getHeader("token")))) {
                shipAddress.setShipIsDefault(Integer.valueOf(1));
                this.shipAddressService.modifyShipAddress(shipAddress);
            }

        }
 
        this.shipAddressService.modifyShipAddress(address);
        resp.setStatus(0);
        resp.setMessage("修改成功");
        return resp;
    }

    @RequestMapping(value = {"/delete"}, method = {org.springframework.web.bind.annotation.RequestMethod.POST})
    @ResponseBody
    public BaseResp delete(@RequestBody DeleteShipAddressReq req) {
        BaseResp resp = new BaseResp();
 
        boolean isDefault = this.shipAddressService.getShipAddressById(req.getId()).getShipIsDefault().intValue() == 0;
        this.shipAddressService.deleteShipAddress(req.getId());
        List list = this.shipAddressService.getShipAddress(Integer.valueOf(this.request.getHeader("token")));
        if ((isDefault) && (list != null) && (list.size() > 0)) {
            ShipAddress address = (ShipAddress) list.get(0);
            address.setShipIsDefault(Integer.valueOf(0));
            this.shipAddressService.modifyShipAddress(address);
        }
 
        resp.setStatus(0);
        resp.setMessage("刪除成功");
        return resp;
    }
}