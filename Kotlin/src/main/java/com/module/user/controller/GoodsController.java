package com.module.user.controller;

import com.module.user.domain.BaseResp;
import com.module.user.domain.GetGoodsDetailReq;
import com.module.user.domain.GetGoodsListByKeywordReq;
import com.module.user.domain.GetGoodsListReq;
import com.module.user.model.GoodsInfo;
import com.module.user.model.GoodsSku;
import com.module.user.service.GoodsService;
import com.module.user.utils.YuanFenConverter;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(produces = {"application/json;charset=UTF-8"}, value = {"/goods"})
public class GoodsController extends BaseController {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping(value = {"/getGoodsList"}, method = {org.springframework.web.bind.annotation.RequestMethod.POST})
    @ResponseBody
    public BaseResp<List<GoodsInfo>> getGoodsList(@RequestBody GetGoodsListReq req) {
        BaseResp resp = new BaseResp();

        List<GoodsInfo> list = this.goodsService.getGoodsList(req.getCategoryId(), req.getPageNo());
        if ((list == null) || (list.size() == 0)) {
            resp.setStatus(0);
            resp.setMessage("列表为空");
            return resp;
        }

        for (GoodsInfo info : list) {
            info.setGoodsDefaultPrice(YuanFenConverter.changeY2F(info.getGoodsDefaultPrice()));
            info.setMaxPage(Integer.valueOf(this.goodsService.getAllGoodsList(req.getCategoryId()).size() / 6 + 1));
        }

        resp.setStatus(0);
        resp.setMessage("列表获取成功");
        resp.setData(list);
        return resp;
    }

    @RequestMapping(value = {"/getGoodsDetail"}, method = {org.springframework.web.bind.annotation.RequestMethod.POST})
    @ResponseBody
    public BaseResp<GoodsInfo> getGoodsDetail(@RequestBody GetGoodsDetailReq req) {
        BaseResp resp = new BaseResp();

        GoodsInfo goodsInfo = this.goodsService.getGoodsDetail(req.getGoodsId());
        if (goodsInfo == null) {
            resp.setStatus(0);
            resp.setMessage("商品为空");
            return resp;
        }

        goodsInfo.setGoodsDefaultPrice(YuanFenConverter.changeY2F(goodsInfo.getGoodsDefaultPrice()));

        List<GoodsSku> skuList = this.goodsService.getGoodsSkuList(goodsInfo.getId());
        for (GoodsSku sku : skuList) {
            sku.setSkuTitle(sku.getGoodsSkuTitle());
            sku.setSkuContent(Arrays.asList(sku.getGoodsSkuContent().split(",")));
        }
        goodsInfo.setGoodsSku(skuList);

        resp.setStatus(0);
        resp.setMessage("列表获取成功");
        resp.setData(goodsInfo);
        return resp;
    }

    @RequestMapping(value = {"/getGoodsListByKeyword"}, method = {org.springframework.web.bind.annotation.RequestMethod.POST})
    @ResponseBody
    public BaseResp<List<GoodsInfo>> getGoodsListByKeyword(@RequestBody GetGoodsListByKeywordReq req) {
        BaseResp resp = new BaseResp();

        List<GoodsInfo> list = this.goodsService.getGoodsListByKeyword(req.getKeyword(), req.getPageNo());
        if ((list == null) || (list.size() == 0)) {
            resp.setStatus(0);
            resp.setMessage("列表为空");
            return resp;
        }

        for (GoodsInfo info : list) {
            info.setGoodsDefaultPrice(YuanFenConverter.changeY2F(info.getGoodsDefaultPrice()));
            info.setMaxPage(Integer.valueOf(this.goodsService.getAllByKeyword(req.getKeyword()).size() / 6 + 1));
        }

        resp.setStatus(0);
        resp.setMessage("列表获取成功");
        resp.setData(list);
        return resp;
    }
}