package com.module.user.controller;

import com.module.user.domain.BaseResp;
import com.module.user.domain.GetSignReq;
import com.module.user.utils.YuanFenConverter;
import com.module.user.utils.pay.PaySignUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(produces = {"application/json; charset=UTF-8"}, value = {"/pay"})
public class PayController extends BaseController {
    @RequestMapping(value = {"/getPaySign"}, method = {org.springframework.web.bind.annotation.RequestMethod.POST})
    @ResponseBody
    public BaseResp<String> getPaySign(@RequestBody GetSignReq req) {
        BaseResp resp = new BaseResp();
        resp.setStatus(0);
        resp.setMessage("");
        try {
            resp.setData(PaySignUtils.sign(YuanFenConverter.changeF2Y(String.valueOf(req.getTotalPrice())), req.getOrderId() + ""));
        } catch (Exception e) {
            e.printStackTrace();
        }
 
        return resp;
    }
}
